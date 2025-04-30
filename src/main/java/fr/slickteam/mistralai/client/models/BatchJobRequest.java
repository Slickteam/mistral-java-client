package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Request model for batch job creation.
 */
public class BatchJobRequest {

    /**
     * Specifies the unique identifier of the model to be used for batch job processing.
     * This field is essential to determine the underlying model configuration
     * and behavior for the request execution.
     */
    public String model;

    /**
     * A list of input strings to be processed in the batch job.
     * Each string represents a separate input for the model.
     */
    public List<String> inputs;

    /**
     * Represents the sampling temperature parameter for the batch job.
     * A higher temperature value results in more randomness in the output,
     * while a lower temperature value makes the output more deterministic.
     */
    public Double temperature;

    /**
     * Specifies the maximum number of tokens allowed for the generated output in a batch job.
     * This value imposes a limit on the total length of the tokenized completion
     * to ensure that the generated output does not exceed the defined constraints.
     */
    public Integer maxTokens;

    /**
     * The top-p setting, also known as nucleus sampling, controls the probability
     * threshold for selecting tokens during the decoding process. When decoding,
     * the model considers the smallest possible set of top tokens whose
     * cumulative probability exceeds this value. The lower the value, the more
     * constrained the output, while higher values result in more varied outputs.
     *
     * A value of 1.0 effectively disables top-p sampling, allowing the model to
     * consider all tokens.
     */
    public Double topP;

    /**
     * Indicates whether the prompt being used in the batch job is validated for safety.
     * If set to true, the system ensures the prompt adheres to safety and compliance standards
     * before execution.
     */
    public Boolean safePrompt;

    /**
     * Random seed for controlling the sequence of random numbers generated in the batch job.
     * This allows for reproducibility of results by using the same seed value across multiple runs.
     */
    public Integer randomSeed;
}