package fr.slickteam.mistralai.client;

public class MistralApiException extends RuntimeException {
    public MistralApiException(String message) {
        super(message);
    }

    public MistralApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
