package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object for file signed URL operations.
 */
public class FileSignedURLResponse {
    /**
     * The signed URL for the file.
     */
    @JsonProperty("url")
    private String url;

    public FileSignedURLResponse() {
    }

    public FileSignedURLResponse(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FileSignedURLResponse{" +
                "url='" + url + '\'' +
                '}';
    }
}
