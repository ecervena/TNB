/*
 * Horreum REST API
 * Horreum automated change anomaly detection. For more information, please see [https://horreum.hyperfoil.io/](https://horreum.hyperfoil.io/)
 *
 * The version of the OpenAPI document: 0.17
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package software.tnb.horreum.validation.generated.model;

import software.tnb.horreum.validation.generated.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Generated;

/**
 * An Experiment Profile defines the labels and filters for the dataset and baseline
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class ExperimentProfile {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    @javax.annotation.Nonnull
    private Integer id;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    @javax.annotation.Nonnull
    private String name;

    public static final String SERIALIZED_NAME_TEST_ID = "testId";
    @SerializedName(SERIALIZED_NAME_TEST_ID)
    @javax.annotation.Nullable
    private Integer testId;

    public static final String SERIALIZED_NAME_SELECTOR_LABELS = "selectorLabels";
    @SerializedName(SERIALIZED_NAME_SELECTOR_LABELS)
    @javax.annotation.Nonnull
    private List<String> selectorLabels = new ArrayList<>();

    public static final String SERIALIZED_NAME_SELECTOR_FILTER = "selectorFilter";
    @SerializedName(SERIALIZED_NAME_SELECTOR_FILTER)
    @javax.annotation.Nullable
    private String selectorFilter;

    public static final String SERIALIZED_NAME_BASELINE_LABELS = "baselineLabels";
    @SerializedName(SERIALIZED_NAME_BASELINE_LABELS)
    @javax.annotation.Nonnull
    private List<String> baselineLabels = new ArrayList<>();

    public static final String SERIALIZED_NAME_BASELINE_FILTER = "baselineFilter";
    @SerializedName(SERIALIZED_NAME_BASELINE_FILTER)
    @javax.annotation.Nullable
    private String baselineFilter;

    public static final String SERIALIZED_NAME_COMPARISONS = "comparisons";
    @SerializedName(SERIALIZED_NAME_COMPARISONS)
    @javax.annotation.Nonnull
    private List<ExperimentComparison> comparisons = new ArrayList<>();

    public static final String SERIALIZED_NAME_EXTRA_LABELS = "extraLabels";
    @SerializedName(SERIALIZED_NAME_EXTRA_LABELS)
    @javax.annotation.Nullable
    private List<String> extraLabels = new ArrayList<>();

    public ExperimentProfile() {
    }

    public ExperimentProfile id(@javax.annotation.Nonnull Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Experiment Profile unique ID
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(@javax.annotation.Nonnull Integer id) {
        this.id = id;
    }

    public ExperimentProfile name(@javax.annotation.Nonnull String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of Experiment Profile
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(@javax.annotation.Nonnull String name) {
        this.name = name;
    }

    public ExperimentProfile testId(@javax.annotation.Nullable Integer testId) {
        this.testId = testId;
        return this;
    }

    /**
     * Test ID that Experiment Profile relates to
     *
     * @return testId
     */
    @javax.annotation.Nullable
    public Integer getTestId() {
        return testId;
    }

    public void setTestId(@javax.annotation.Nullable Integer testId) {
        this.testId = testId;
    }

    public ExperimentProfile selectorLabels(@javax.annotation.Nonnull List<String> selectorLabels) {
        this.selectorLabels = selectorLabels;
        return this;
    }

    public ExperimentProfile addSelectorLabelsItem(String selectorLabelsItem) {
        if (this.selectorLabels == null) {
            this.selectorLabels = new ArrayList<>();
        }
        this.selectorLabels.add(selectorLabelsItem);
        return this;
    }

    /**
     * Array of selector labels
     *
     * @return selectorLabels
     */
    @javax.annotation.Nonnull
    public List<String> getSelectorLabels() {
        return selectorLabels;
    }

    public void setSelectorLabels(@javax.annotation.Nonnull List<String> selectorLabels) {
        this.selectorLabels = selectorLabels;
    }

    public ExperimentProfile selectorFilter(@javax.annotation.Nullable String selectorFilter) {
        this.selectorFilter = selectorFilter;
        return this;
    }

    /**
     * Selector filter to apply to Selector label values
     *
     * @return selectorFilter
     */
    @javax.annotation.Nullable
    public String getSelectorFilter() {
        return selectorFilter;
    }

    public void setSelectorFilter(@javax.annotation.Nullable String selectorFilter) {
        this.selectorFilter = selectorFilter;
    }

    public ExperimentProfile baselineLabels(@javax.annotation.Nonnull List<String> baselineLabels) {
        this.baselineLabels = baselineLabels;
        return this;
    }

    public ExperimentProfile addBaselineLabelsItem(String baselineLabelsItem) {
        if (this.baselineLabels == null) {
            this.baselineLabels = new ArrayList<>();
        }
        this.baselineLabels.add(baselineLabelsItem);
        return this;
    }

    /**
     * Array of selector labels for comparison Baseline
     *
     * @return baselineLabels
     */
    @javax.annotation.Nonnull
    public List<String> getBaselineLabels() {
        return baselineLabels;
    }

    public void setBaselineLabels(@javax.annotation.Nonnull List<String> baselineLabels) {
        this.baselineLabels = baselineLabels;
    }

    public ExperimentProfile baselineFilter(@javax.annotation.Nullable String baselineFilter) {
        this.baselineFilter = baselineFilter;
        return this;
    }

    /**
     * Selector filter to apply to Baseline label values
     *
     * @return baselineFilter
     */
    @javax.annotation.Nullable
    public String getBaselineFilter() {
        return baselineFilter;
    }

    public void setBaselineFilter(@javax.annotation.Nullable String baselineFilter) {
        this.baselineFilter = baselineFilter;
    }

    public ExperimentProfile comparisons(@javax.annotation.Nonnull List<ExperimentComparison> comparisons) {
        this.comparisons = comparisons;
        return this;
    }

    public ExperimentProfile addComparisonsItem(ExperimentComparison comparisonsItem) {
        if (this.comparisons == null) {
            this.comparisons = new ArrayList<>();
        }
        this.comparisons.add(comparisonsItem);
        return this;
    }

    /**
     * Collection of Experiment Comparisons to run during an Experiment evaluation
     *
     * @return comparisons
     */
    @javax.annotation.Nonnull
    public List<ExperimentComparison> getComparisons() {
        return comparisons;
    }

    public void setComparisons(@javax.annotation.Nonnull List<ExperimentComparison> comparisons) {
        this.comparisons = comparisons;
    }

    public ExperimentProfile extraLabels(@javax.annotation.Nullable List<String> extraLabels) {
        this.extraLabels = extraLabels;
        return this;
    }

    public ExperimentProfile addExtraLabelsItem(String extraLabelsItem) {
        if (this.extraLabels == null) {
            this.extraLabels = new ArrayList<>();
        }
        this.extraLabels.add(extraLabelsItem);
        return this;
    }

    /**
     * These labels are not used by Horreum but are added to the result event and therefore can be used e.g. when firing an Action.
     *
     * @return extraLabels
     */
    @javax.annotation.Nullable
    public List<String> getExtraLabels() {
        return extraLabels;
    }

    public void setExtraLabels(@javax.annotation.Nullable List<String> extraLabels) {
        this.extraLabels = extraLabels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExperimentProfile experimentProfile = (ExperimentProfile) o;
        return Objects.equals(this.id, experimentProfile.id) &&
            Objects.equals(this.name, experimentProfile.name) &&
            Objects.equals(this.testId, experimentProfile.testId) &&
            Objects.equals(this.selectorLabels, experimentProfile.selectorLabels) &&
            Objects.equals(this.selectorFilter, experimentProfile.selectorFilter) &&
            Objects.equals(this.baselineLabels, experimentProfile.baselineLabels) &&
            Objects.equals(this.baselineFilter, experimentProfile.baselineFilter) &&
            Objects.equals(this.comparisons, experimentProfile.comparisons) &&
            Objects.equals(this.extraLabels, experimentProfile.extraLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, testId, selectorLabels, selectorFilter, baselineLabels, baselineFilter, comparisons, extraLabels);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExperimentProfile {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
        sb.append("    selectorLabels: ").append(toIndentedString(selectorLabels)).append("\n");
        sb.append("    selectorFilter: ").append(toIndentedString(selectorFilter)).append("\n");
        sb.append("    baselineLabels: ").append(toIndentedString(baselineLabels)).append("\n");
        sb.append("    baselineFilter: ").append(toIndentedString(baselineFilter)).append("\n");
        sb.append("    comparisons: ").append(toIndentedString(comparisons)).append("\n");
        sb.append("    extraLabels: ").append(toIndentedString(extraLabels)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("id");
        openapiFields.add("name");
        openapiFields.add("testId");
        openapiFields.add("selectorLabels");
        openapiFields.add("selectorFilter");
        openapiFields.add("baselineLabels");
        openapiFields.add("baselineFilter");
        openapiFields.add("comparisons");
        openapiFields.add("extraLabels");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("id");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("selectorLabels");
        openapiRequiredFields.add("baselineLabels");
        openapiRequiredFields.add("comparisons");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ExperimentProfile
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ExperimentProfile.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                    String.format("The required field(s) %s in ExperimentProfile is not found in the empty JSON string",
                        ExperimentProfile.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ExperimentProfile.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `ExperimentProfile` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ExperimentProfile.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
        }
        // ensure the required json array is present
        if (jsonObj.get("selectorLabels") == null) {
            throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
        } else if (!jsonObj.get("selectorLabels").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `selectorLabels` to be an array in the JSON string but got `%s`",
                jsonObj.get("selectorLabels").toString()));
        }
        if ((jsonObj.get("selectorFilter") != null && !jsonObj.get("selectorFilter").isJsonNull()) && !jsonObj.get("selectorFilter")
            .isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `selectorFilter` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("selectorFilter").toString()));
        }
        // ensure the required json array is present
        if (jsonObj.get("baselineLabels") == null) {
            throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
        } else if (!jsonObj.get("baselineLabels").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `baselineLabels` to be an array in the JSON string but got `%s`",
                jsonObj.get("baselineLabels").toString()));
        }
        if ((jsonObj.get("baselineFilter") != null && !jsonObj.get("baselineFilter").isJsonNull()) && !jsonObj.get("baselineFilter")
            .isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `baselineFilter` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("baselineFilter").toString()));
        }
        // ensure the json data is an array
        if (!jsonObj.get("comparisons").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `comparisons` to be an array in the JSON string but got `%s`",
                jsonObj.get("comparisons").toString()));
        }

        JsonArray jsonArraycomparisons = jsonObj.getAsJsonArray("comparisons");
        // validate the required field `comparisons` (array)
        for (int i = 0; i < jsonArraycomparisons.size(); i++) {
            ExperimentComparison.validateJsonElement(jsonArraycomparisons.get(i));
        }
        ;
        // ensure the optional json data is an array if present
        if (jsonObj.get("extraLabels") != null && !jsonObj.get("extraLabels").isJsonNull() && !jsonObj.get("extraLabels").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `extraLabels` to be an array in the JSON string but got `%s`",
                jsonObj.get("extraLabels").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ExperimentProfile.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ExperimentProfile' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ExperimentProfile> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(ExperimentProfile.class));

            return (TypeAdapter<T>) new TypeAdapter<ExperimentProfile>() {
                @Override
                public void write(JsonWriter out, ExperimentProfile value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ExperimentProfile read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of ExperimentProfile given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ExperimentProfile
     * @throws IOException if the JSON string is invalid with respect to ExperimentProfile
     */
    public static ExperimentProfile fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ExperimentProfile.class);
    }

    /**
     * Convert an instance of ExperimentProfile to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
