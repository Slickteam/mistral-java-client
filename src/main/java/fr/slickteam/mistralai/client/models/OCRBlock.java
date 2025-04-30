package fr.slickteam.mistralai.client.models;

/**
 * OCR block model representing a text block with bounding box coordinates.
 */
public class OCRBlock {

    /**
     * Represents the textual content extracted by the OCR process for a specific block.
     * This field contains the text identified within the bounding box associated with
     * the current OCRBlock instance.
     */
    public String text;

    /**
     * Represents the bounding box coordinates for a text block.
     * The bounding box is defined as an array containing four integers:
     *
     * - x: The x-coordinate of the top-left corner of the bounding box.
     * - y: The y-coordinate of the top-left corner of the bounding box.
     * - width: The width of the bounding box.
     * - height: The height of the bounding box.
     *
     * These coordinates are typically used to define the position and size of a text block
     * within an image or document in OCR (Optical Character Recognition) tasks.
     */
    public int[] bbox; // Bounding box coordinates [x, y, width, height]

}