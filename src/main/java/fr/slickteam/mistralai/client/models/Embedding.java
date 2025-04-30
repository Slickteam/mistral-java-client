package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an embedding vector for a given input.
 */
public class Embedding {
    /**
     * The type of object returned, which is 'embedding'.
     */
    @JsonProperty("object")
    private String object;

    /**
     * The index of this embedding in the list of embeddings.
     */
    @JsonProperty("index")
    private int index;

    /**
     * The embedding vector, which is a list of floating-point numbers.
     */
    @JsonProperty("embedding")
    private List<Float> embedding;

    public Embedding() {
    }

    public Embedding(String object, int index, List<Float> embedding) {
        this.object = object;
        this.index = index;
        this.embedding = embedding;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Float> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Float> embedding) {
        this.embedding = embedding;
    }

    @Override
    public String toString() {
        return "Embedding{" +
                "object='" + object + '\'' +
                ", index=" + index +
                ", embedding.size=" + (embedding != null ? embedding.size() : "null") +
                '}';
    }
}
