package com.viniciusgomes.error;

import java.time.ZonedDateTime;

public class ResourceNotFoundDetails extends ErrorDetails {


    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private ZonedDateTime timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.status = this.status;
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.detail = this.detail;
            return resourceNotFoundDetails;
        }
    }
}
