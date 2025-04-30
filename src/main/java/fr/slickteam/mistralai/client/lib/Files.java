package fr.slickteam.mistralai.client.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Utility methods for file handling in the SDK.
 */
public class Files {
    /**
     * Reads an input stream into a byte array.
     *
     * @param inputStream The input stream to read
     * @return The byte array containing the stream data
     * @throws IOException If an I/O error occurs
     */
    public static byte[] readInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384]; // 16KB buffer

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }

    /**
     * Asynchronously reads an input stream into a byte array.
     *
     * @param inputStream The input stream to read
     * @return A CompletableFuture for the byte array containing the stream data
     */
    public static CompletableFuture<byte[]> readInputStreamToByteArrayAsync(InputStream inputStream) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return readInputStreamToByteArray(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read input stream", e);
            }
        });
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes The byte array to convert
     * @return The hexadecimal string
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    /**
     * Gets the content type for a file based on its extension.
     *
     * @param fileName The file name
     * @return The content type, or "application/octet-stream" if unknown
     */
    public static String getContentType(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1).toLowerCase();
        }

        switch (extension) {
            case "txt":
                return "text/plain";
            case "html":
            case "htm":
                return "text/html";
            case "json":
                return "application/json";
            case "xml":
                return "application/xml";
            case "pdf":
                return "application/pdf";
            case "png":
                return "image/png";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "gif":
                return "image/gif";
            case "svg":
                return "image/svg+xml";
            default:
                return "application/octet-stream";
        }
    }
}