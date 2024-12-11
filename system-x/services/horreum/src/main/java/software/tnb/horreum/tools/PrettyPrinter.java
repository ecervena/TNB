package software.tnb.horreum.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;

import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class PrettyPrinter {
    private static final Logger LOG = LoggerFactory.getLogger(PrettyPrinter.class);

    public PrettyPrinter() {
        this.mapper = new ObjectMapper();
    }

    private ObjectMapper mapper;

    public void printJsonBody(String jsonString) throws JsonProcessingException {
        LOG.info("Body:");
        Object json = mapper.readValue(jsonString, Object.class);
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        System.out.println(writer.writeValueAsString(json));
    }

    public String convertBodyToString(RequestBody body) {
        try {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            return buffer.readUtf8();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to convert RequestBody to String");
        }
    }

    public void printUrl(Request request) {
        LOG.info("URL:");
        request.url();
    }

    public void printHeaders(Request request) {
        LOG.info("Headers:");
        System.out.println(
            request.headers().toMultimap().entrySet()
            .stream()
            .map(entry -> entry.getKey() + ":" + String.join(", ", entry.getValue()))
            .collect(Collectors.joining("\n"))
        );
    }
}
