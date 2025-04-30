package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.Config;

/**
 * API resource for interacting with batch operations.
 */
public class Batch extends ApiResource {
    private MistralJobs jobs;

    /**
     * Creates a new batch API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Batch(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Gets the jobs API for batch operations.
     *
     * @return The jobs API
     */
    public MistralJobs getJobs() {
        if (jobs == null) {
            jobs = new MistralJobs(getOptions());
        }
        return jobs;
    }
}
