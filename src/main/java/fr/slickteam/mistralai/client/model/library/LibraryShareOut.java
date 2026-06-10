package fr.slickteam.mistralai.client.model.library;

import java.util.List;

/**
 * Response for library sharing.
 */
public record LibraryShareOut(
    String id,
    List<String> sharedWith,
    String permissions
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private List<String> sharedWith;
        private String permissions;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder sharedWith(List<String> sharedWith) {
            this.sharedWith = sharedWith;
            return this;
        }

        public Builder permissions(String permissions) {
            this.permissions = permissions;
            return this;
        }

        public LibraryShareOut build() {
            return new LibraryShareOut(id, sharedWith, permissions);
        }
    }
}
