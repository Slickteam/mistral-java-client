package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.ClientSDK;
import fr.slickteam.mistralai.client.lib.Config;

/**
 * Base class for API resources.
 */
public abstract class ApiResource extends ClientSDK {
    /**
     * Creates a new API resource with the specified options.
     *
     * @param options The SDK options
     */
    public ApiResource(Config.SDKOptions options) {
        super(options);
    }
}