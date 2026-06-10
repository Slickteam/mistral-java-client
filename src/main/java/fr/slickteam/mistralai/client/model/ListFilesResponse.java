package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.slickteam.mistralai.client.model.FileObject;

import java.util.List;

/**
 * Response object for listing files.
 */
public class ListFilesResponse {
    /**
     * The object type, which is 'list'.
     */
    @JsonProperty("object")
    private String object;

    /**
     * The list of file objects.
     */
    @JsonProperty("data")
    private List<FileObject> data;

    public ListFilesResponse() {
    }

    public ListFilesResponse(String object, List<FileObject> data) {
        this.object = object;
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<FileObject> getData() {
        return data;
    }

    public void setData(List<FileObject> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListFilesResponse{" +
                "object='" + object + '\'' +
                ", data.size=" + (data != null ? data.size() : "null") +
                '}';
    }
}
