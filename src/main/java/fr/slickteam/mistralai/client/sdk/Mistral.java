package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.ClientSDK;
import fr.slickteam.mistralai.client.lib.Config;

/**
 * Main SDK class for interacting with the Mistral AI API.
 */
public class Mistral extends ClientSDK {
    private Models models;
    private Files files;
    private FineTuning fineTuning;
    private Batch batch;
    private Chat chat;
    private Fim fim;
    private Agents agents;
    private Embeddings embeddings;
    private Classifiers classifiers;
    private Ocr ocr;

    /**
     * Creates a new Mistral SDK client with the specified options.
     *
     * @param options The SDK options
     */
    public Mistral(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Creates a new Mistral SDK client with default options.
     */
    public Mistral() {
        super();
    }

    /**
     * Gets the models API.
     *
     * @return The models API
     */
    public Models getModels() {
        if (models == null) {
            models = new Models(getOptions());
        }
        return models;
    }

    /**
     * Gets the files API.
     *
     * @return The files API
     */
    public Files getFiles() {
        if (files == null) {
            files = new Files(getOptions());
        }
        return files;
    }

    /**
     * Gets the fine-tuning API.
     *
     * @return The fine-tuning API
     */
    public FineTuning getFineTuning() {
        if (fineTuning == null) {
            fineTuning = new FineTuning(getOptions());
        }
        return fineTuning;
    }

    /**
     * Gets the batch API.
     *
     * @return The batch API
     */
    public Batch getBatch() {
        if (batch == null) {
            batch = new Batch(getOptions());
        }
        return batch;
    }

    /**
     * Gets the chat API.
     *
     * @return The chat API
     */
    public Chat getChat() {
        if (chat == null) {
            chat = new Chat(getOptions());
        }
        return chat;
    }

    /**
     * Gets the FIM (Fill in the Middle) API.
     *
     * @return The FIM API
     */
    public Fim getFim() {
        if (fim == null) {
            fim = new Fim(getOptions());
        }
        return fim;
    }

    /**
     * Gets the agents API.
     *
     * @return The agents API
     */
    public Agents getAgents() {
        if (agents == null) {
            agents = new Agents(getOptions());
        }
        return agents;
    }

    /**
     * Gets the embeddings API.
     *
     * @return The embeddings API
     */
    public Embeddings getEmbeddings() {
        if (embeddings == null) {
            embeddings = new Embeddings(getOptions());
        }
        return embeddings;
    }

    /**
     * Gets the classifiers API.
     *
     * @return The classifiers API
     */
    public Classifiers getClassifiers() {
        if (classifiers == null) {
            classifiers = new Classifiers(getOptions());
        }
        return classifiers;
    }

    /**
     * Gets the OCR (Optical Character Recognition) API.
     *
     * @return The OCR API
     */
    public Ocr getOcr() {
        if (ocr == null) {
            ocr = new Ocr(getOptions());
        }
        return ocr;
    }
}