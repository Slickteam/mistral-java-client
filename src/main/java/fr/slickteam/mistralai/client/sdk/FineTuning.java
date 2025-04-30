package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.Config;

/**
 * API resource for interacting with fine-tuning.
 */
public class FineTuning extends ApiResource {
    private Jobs jobs;

    /**
     * Creates a new fine-tuning API resource with the specified options.
     *
     * @param options The SDK options
     */
    public FineTuning(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Gets the jobs API for fine-tuning operations.
     *
     * @return The jobs API
     */
    public Jobs getJobs() {
        if (jobs == null) {
            jobs = new Jobs(getOptions());
        }
        return jobs;
    }
}
