package fr.slickteam.mistralai.client.models;

import java.io.File;

/**
 * OCR request model.
 */
public class OCRRequest {

    /**
     * Represents the model identifier to be used in an OCR request.
     * This field specifies the pre-trained model or configuration that will be used
     * for processing the corresponding OCR operation.
     */
    public String model;

    /**
     * Represents the input image for Optical Character Recognition (OCR) processing.
     *
     * This variable can hold multiple data types depending on the source or context
     * of the image data:
     * - File: Represents an image file stored on disk.
     * - byte[]: Represents the image content in byte array format.
     * - base64 String: Represents the image encoded as a Base64 string.
     *
     * The choice of format depends on how the image is supplied to the system,
     * offering flexibility for various input methods in OCR workflows.
     */
    public Object image; // Can be a File, byte[], or base64 String

}