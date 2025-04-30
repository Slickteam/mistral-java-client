package fr.slickteam.mistralai.client.lib;

/**
 * Configuration for retry behavior in the SDK.
 */
public class RetryConfig {
    private int maxRetries;
    private int initialBackoffMs;
    private int maxBackoffMs;
    private double backoffMultiplier;
    private boolean retryConnectionErrors;
    private boolean retryTimeoutErrors;
    private boolean retryStatusCodes;

    /**
     * Creates a new retry configuration with default values.
     */
    public RetryConfig() {
        this.maxRetries = 2;
        this.initialBackoffMs = 500;
        this.maxBackoffMs = 60000;
        this.backoffMultiplier = 1.5;
        this.retryConnectionErrors = true;
        this.retryTimeoutErrors = true;
        this.retryStatusCodes = true;
    }

    /**
     * Gets the maximum number of retries.
     *
     * @return The maximum number of retries
     */
    public int getMaxRetries() {
        return maxRetries;
    }

    /**
     * Sets the maximum number of retries.
     *
     * @param maxRetries The maximum number of retries
     * @return This retry configuration
     */
    public RetryConfig setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    /**
     * Gets the initial backoff time in milliseconds.
     *
     * @return The initial backoff time in milliseconds
     */
    public int getInitialBackoffMs() {
        return initialBackoffMs;
    }

    /**
     * Sets the initial backoff time in milliseconds.
     *
     * @param initialBackoffMs The initial backoff time in milliseconds
     * @return This retry configuration
     */
    public RetryConfig setInitialBackoffMs(int initialBackoffMs) {
        this.initialBackoffMs = initialBackoffMs;
        return this;
    }

    /**
     * Gets the maximum backoff time in milliseconds.
     *
     * @return The maximum backoff time in milliseconds
     */
    public int getMaxBackoffMs() {
        return maxBackoffMs;
    }

    /**
     * Sets the maximum backoff time in milliseconds.
     *
     * @param maxBackoffMs The maximum backoff time in milliseconds
     * @return This retry configuration
     */
    public RetryConfig setMaxBackoffMs(int maxBackoffMs) {
        this.maxBackoffMs = maxBackoffMs;
        return this;
    }

    /**
     * Gets the backoff multiplier.
     *
     * @return The backoff multiplier
     */
    public double getBackoffMultiplier() {
        return backoffMultiplier;
    }

    /**
     * Sets the backoff multiplier.
     *
     * @param backoffMultiplier The backoff multiplier
     * @return This retry configuration
     */
    public RetryConfig setBackoffMultiplier(double backoffMultiplier) {
        this.backoffMultiplier = backoffMultiplier;
        return this;
    }

    /**
     * Gets whether to retry connection errors.
     *
     * @return Whether to retry connection errors
     */
    public boolean isRetryConnectionErrors() {
        return retryConnectionErrors;
    }

    /**
     * Sets whether to retry connection errors.
     *
     * @param retryConnectionErrors Whether to retry connection errors
     * @return This retry configuration
     */
    public RetryConfig setRetryConnectionErrors(boolean retryConnectionErrors) {
        this.retryConnectionErrors = retryConnectionErrors;
        return this;
    }

    /**
     * Gets whether to retry timeout errors.
     *
     * @return Whether to retry timeout errors
     */
    public boolean isRetryTimeoutErrors() {
        return retryTimeoutErrors;
    }

    /**
     * Sets whether to retry timeout errors.
     *
     * @param retryTimeoutErrors Whether to retry timeout errors
     * @return This retry configuration
     */
    public RetryConfig setRetryTimeoutErrors(boolean retryTimeoutErrors) {
        this.retryTimeoutErrors = retryTimeoutErrors;
        return this;
    }

    /**
     * Gets whether to retry certain status codes.
     *
     * @return Whether to retry certain status codes
     */
    public boolean isRetryStatusCodes() {
        return retryStatusCodes;
    }

    /**
     * Sets whether to retry certain status codes.
     *
     * @param retryStatusCodes Whether to retry certain status codes
     * @return This retry configuration
     */
    public RetryConfig setRetryStatusCodes(boolean retryStatusCodes) {
        this.retryStatusCodes = retryStatusCodes;
        return this;
    }
}