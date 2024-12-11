package software.tnb.horreum.validation;

import com.google.common.reflect.TypeToken;

import okhttp3.Call;

import okhttp3.Request;

import software.tnb.common.utils.HTTPUtils;
import software.tnb.common.validation.Validation;
import software.tnb.horreum.account.HorreumAccount;
import software.tnb.horreum.configuration.HorreumConfiguration;
import software.tnb.horreum.tools.PrettyPrinter;
import software.tnb.horreum.validation.generated.ApiClient;
import software.tnb.horreum.validation.generated.ApiException;
import software.tnb.horreum.validation.generated.ApiResponse;
import software.tnb.horreum.validation.generated.api.RunApi;
import software.tnb.horreum.validation.generated.auth.ApiKeyAuth;
import software.tnb.horreum.validation.generated.model.Access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;

import java.lang.reflect.Type;
import java.util.stream.Collectors;

public class HorreumValidation implements Validation {

    public static final MediaType FORM_URLENC = MediaType.get("application/x-www-form-urlencoded; charset=utf-8");

    private static final Logger LOG = LoggerFactory.getLogger(HorreumValidation.class);

    private static final PrettyPrinter prettyPrinter = new PrettyPrinter();
    //private final DefaultApi defaultApi;
    private final RunApi runApi;
    private HorreumAccount horreumAccount;

    public HorreumValidation(HorreumAccount horreumAccount) {
        HTTPUtils.OkHttpClientBuilder okHttpClientBuilder = new HTTPUtils.OkHttpClientBuilder();
        okHttpClientBuilder.trustAllSslClient();
        if (HorreumConfiguration.isHttpLogEnabled()) {
            okHttpClientBuilder.log();
        }
        ApiKeyAuth auth = new ApiKeyAuth("header", "X-Horreum-API-Key");
        auth.setApiKey("HUSR_DF3146B9_1F13_462C_97DD_616A97622CF1");
        ApiClient apiClient = new ApiClient(okHttpClientBuilder.build(), "apikey", auth);
        apiClient.setBasePath(HorreumConfiguration.getUrl());
        apiClient.setVerifyingSsl(false);
        //apiClient.setApiKey(HorreumConfiguration.getApiKey());
        apiClient.setApiKey("HUSR_DF3146B9_1F13_462C_97DD_616A97622CF1");
        //defaultApi = new DefaultApi(apiClient);
        runApi = new RunApi(apiClient);
        this.horreumAccount = horreumAccount;
    }

    public Integer postRunData(String start, String stop, String test, String owner, Access access,
        String schema, String description, String body) throws Exception {
        Call uploadCall = runApi.addRunFromDataCall(start, stop, test, owner, access, schema, description, body, null);
        if (HorreumConfiguration.isRequestLogEnabled()) {
            Request request = uploadCall.request();
            LOG.info("Prepared upload request with run data:\n" + request);
            prettyPrinter.printUrl(request);
            prettyPrinter.printHeaders(request);
            prettyPrinter.printJsonBody(prettyPrinter.convertBodyToString(request.body()));
            LOG.info("Body from parameter:");
            prettyPrinter.printJsonBody(body);
        }
        Type responseType = new TypeToken<Integer>() {}.getType();
        ApiResponse<Integer> horreumResp = runApi.getApiClient().execute(uploadCall, responseType);
        LOG.info("Upload response \n:Status code: " + horreumResp.getStatusCode() + "\nHeaders: " + horreumResp.getHeaders().entrySet().stream().map(entry -> entry.getKey() + ":" + String.join(", ", entry.getValue())).collect(
            Collectors.joining("\n")) + "\nRunDataID" + horreumResp.getData());
        return horreumResp.getData();
       // return runApi.addRunFromDataCall(start, stop, test, owner, access, schema, description, body, null).execute().cacheResponse().code();
       // return runApi.addRunFromData(start, stop, test, owner, access, schema, description, body);
    }

    public Call getCall(String start, String stop, String test, String owner, Access access,
        String schema, String description, String body) throws ApiException {
        return runApi.addRunFromDataCall(start, stop, test, owner, access, schema, description, body, null);
    }

    //no tokens anymore
    //    public String getToken(String testName) throws Exception {
    //        KeycloakConfig keycloakConfig = configServiceApi.configServiceKeycloak();
    //        String oauthToken = getHorreumOauthToken(String.format("%s/realms/%s/protocol/openid-connect/token",
    //                keycloakConfig.getUrl(), keycloakConfig.getRealm()), keycloakConfig.getClientId(), horreumAccount.username(testName),
    //            horreumAccount.password(testName));
    //        return oauthToken;
    //    }

    //    private String getHorreumOauthToken(String url, String clientId, String username, String password) {
    //        HTTPUtils client = HTTPUtils.getInstance(HTTPUtils.trustAllSslClient());
    //        RequestBody body = RequestBody.create(FORM_URLENC,
    //            String.format("username=%s&password=%s&grant_type=password&client_id=%s", username, password, clientId)
    //        );
    //        Response response = client.post(url, body);
    //        JSON json = configServiceApi.getApiClient().getJSON();
    //        Map resp = json.deserialize(response.getBody(), Map.class);
    //        return (String) resp.get("access_token");
    //    }

    //change detection is used only in camelk tests which are dropped at the moment
    //    public List<Change> detectChanges(String testName, String accessToken, Integer runDataId, String fingerprint) throws Exception {
    //        runApi.getApiClient().addDefaultHeader("Authorization", "Bearer " + accessToken);
    //        Test test = runApi.testServiceGetByNameOrId(testName);
    //        List<Variable> variables = runApi.alertingServiceVariables(test.getId());
    //        List<Change> changes = variables.stream().flatMap(var -> {
    //            try {
    //                return runApi.alertingServiceChanges(var.getId(), fingerprint).stream();
    //            } catch (ApiException e) {
    //                throw new RuntimeException(e);
    //            }
    //        }).filter(change -> change.getDataset().getRunId().equals(runDataId)).collect(Collectors.toList());
    //        return changes;
    //    }
}
