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
 * Represents a Schema with all associated data used for export/import operations.
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class SchemaExport {
    public static final String SERIALIZED_NAME_LABELS = "labels";
    @SerializedName(SERIALIZED_NAME_LABELS)
    @javax.annotation.Nullable
    private List<Label> labels = new ArrayList<>();

    public static final String SERIALIZED_NAME_TRANSFORMERS = "transformers";
    @SerializedName(SERIALIZED_NAME_TRANSFORMERS)
    @javax.annotation.Nullable
    private List<Transformer> transformers = new ArrayList<>();

    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    @javax.annotation.Nonnull
    private Integer id;

    public static final String SERIALIZED_NAME_URI = "uri";
    @SerializedName(SERIALIZED_NAME_URI)
    @javax.annotation.Nonnull
    private String uri;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    @javax.annotation.Nonnull
    private String name;

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    @javax.annotation.Nullable
    private String description;

    public static final String SERIALIZED_NAME_SCHEMA = "schema";
    @SerializedName(SERIALIZED_NAME_SCHEMA)
    @javax.annotation.Nullable
    private String schema;

    public static final String SERIALIZED_NAME_ACCESS = "access";
    @SerializedName(SERIALIZED_NAME_ACCESS)
    @javax.annotation.Nonnull
    private Access access;

    public static final String SERIALIZED_NAME_OWNER = "owner";
    @SerializedName(SERIALIZED_NAME_OWNER)
    @javax.annotation.Nonnull
    private String owner;

    public SchemaExport() {
    }

    public SchemaExport labels(@javax.annotation.Nullable List<Label> labels) {
        this.labels = labels;
        return this;
    }

    public SchemaExport addLabelsItem(Label labelsItem) {
        if (this.labels == null) {
            this.labels = new ArrayList<>();
        }
        this.labels.add(labelsItem);
        return this;
    }

    /**
     * Array of Labels associated with schema
     *
     * @return labels
     */
    @javax.annotation.Nullable
    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(@javax.annotation.Nullable List<Label> labels) {
        this.labels = labels;
    }

    public SchemaExport transformers(@javax.annotation.Nullable List<Transformer> transformers) {
        this.transformers = transformers;
        return this;
    }

    public SchemaExport addTransformersItem(Transformer transformersItem) {
        if (this.transformers == null) {
            this.transformers = new ArrayList<>();
        }
        this.transformers.add(transformersItem);
        return this;
    }

    /**
     * Array of Transformers associated with schema
     *
     * @return transformers
     */
    @javax.annotation.Nullable
    public List<Transformer> getTransformers() {
        return transformers;
    }

    public void setTransformers(@javax.annotation.Nullable List<Transformer> transformers) {
        this.transformers = transformers;
    }

    public SchemaExport id(@javax.annotation.Nonnull Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Unique Schema ID
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

    public SchemaExport uri(@javax.annotation.Nonnull String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Unique, versioned schema URI
     *
     * @return uri
     */
    @javax.annotation.Nonnull
    public String getUri() {
        return uri;
    }

    public void setUri(@javax.annotation.Nonnull String uri) {
        this.uri = uri;
    }

    public SchemaExport name(@javax.annotation.Nonnull String name) {
        this.name = name;
        return this;
    }

    /**
     * Schema name
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

    public SchemaExport description(@javax.annotation.Nullable String description) {
        this.description = description;
        return this;
    }

    /**
     * Schema Description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@javax.annotation.Nullable String description) {
        this.description = description;
    }

    public SchemaExport schema(@javax.annotation.Nullable String schema) {
        this.schema = schema;
        return this;
    }

    /**
     * JSON validation schema. Used to validate uploaded JSON documents
     *
     * @return schema
     */
    @javax.annotation.Nullable
    public String getSchema() {
        return schema;
    }

    public void setSchema(@javax.annotation.Nullable String schema) {
        this.schema = schema;
    }

    public SchemaExport access(@javax.annotation.Nonnull Access access) {
        this.access = access;
        return this;
    }

    /**
     * Access rights for the test. This defines the visibility of the Test in the UI
     *
     * @return access
     */
    @javax.annotation.Nonnull
    public Access getAccess() {
        return access;
    }

    public void setAccess(@javax.annotation.Nonnull Access access) {
        this.access = access;
    }

    public SchemaExport owner(@javax.annotation.Nonnull String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Name of the team that owns the test. Users must belong to the team that owns a test to make modifications
     *
     * @return owner
     */
    @javax.annotation.Nonnull
    public String getOwner() {
        return owner;
    }

    public void setOwner(@javax.annotation.Nonnull String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchemaExport schemaExport = (SchemaExport) o;
        return Objects.equals(this.labels, schemaExport.labels) &&
            Objects.equals(this.transformers, schemaExport.transformers) &&
            Objects.equals(this.id, schemaExport.id) &&
            Objects.equals(this.uri, schemaExport.uri) &&
            Objects.equals(this.name, schemaExport.name) &&
            Objects.equals(this.description, schemaExport.description) &&
            Objects.equals(this.schema, schemaExport.schema) &&
            Objects.equals(this.access, schemaExport.access) &&
            Objects.equals(this.owner, schemaExport.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, transformers, id, uri, name, description, schema, access, owner);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SchemaExport {\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    transformers: ").append(toIndentedString(transformers)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    access: ").append(toIndentedString(access)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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
        openapiFields.add("uri");
        openapiFields.add("name");
        openapiFields.add("description");
        openapiFields.add("schema");
        openapiFields.add("access");
        openapiFields.add("owner");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("id");
        openapiRequiredFields.add("uri");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("access");
        openapiRequiredFields.add("owner");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to SchemaExport
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!SchemaExport.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in SchemaExport is not found in the empty JSON string",
                    SchemaExport.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!SchemaExport.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `SchemaExport` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : SchemaExport.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("labels") != null && !jsonObj.get("labels").isJsonNull()) {
            JsonArray jsonArraylabels = jsonObj.getAsJsonArray("labels");
            if (jsonArraylabels != null) {
                // ensure the json data is an array
                if (!jsonObj.get("labels").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `labels` to be an array in the JSON string but got `%s`",
                        jsonObj.get("labels").toString()));
                }

                // validate the optional field `labels` (array)
                for (int i = 0; i < jsonArraylabels.size(); i++) {
                    Label.validateJsonElement(jsonArraylabels.get(i));
                }
                ;
            }
        }
        if (jsonObj.get("transformers") != null && !jsonObj.get("transformers").isJsonNull()) {
            JsonArray jsonArraytransformers = jsonObj.getAsJsonArray("transformers");
            if (jsonArraytransformers != null) {
                // ensure the json data is an array
                if (!jsonObj.get("transformers").isJsonArray()) {
                    throw new IllegalArgumentException(
                        String.format("Expected the field `transformers` to be an array in the JSON string but got `%s`",
                            jsonObj.get("transformers").toString()));
                }

                // validate the optional field `transformers` (array)
                for (int i = 0; i < jsonArraytransformers.size(); i++) {
                    Transformer.validateJsonElement(jsonArraytransformers.get(i));
                }
                ;
            }
        }
        if (!jsonObj.get("uri").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uri").toString()));
        }
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
        }
        if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("description").toString()));
        }
        if ((jsonObj.get("schema") != null && !jsonObj.get("schema").isJsonNull()) && !jsonObj.get("schema").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `schema` to be a primitive type in the JSON string but got `%s`",
                jsonObj.get("schema").toString()));
        }
        // validate the required field `access`
        Access.validateJsonElement(jsonObj.get("access"));
        if (!jsonObj.get("owner").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `owner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("owner").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!SchemaExport.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'SchemaExport' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SchemaExport> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(SchemaExport.class));

            return (TypeAdapter<T>) new TypeAdapter<SchemaExport>() {
                @Override
                public void write(JsonWriter out, SchemaExport value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public SchemaExport read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of SchemaExport given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SchemaExport
     * @throws IOException if the JSON string is invalid with respect to SchemaExport
     */
    public static SchemaExport fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, SchemaExport.class);
    }

    /**
     * Convert an instance of SchemaExport to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
