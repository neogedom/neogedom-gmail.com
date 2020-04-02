package com.viniciusgomes.error;

import java.time.ZonedDateTime;

public class ValidationErrorDetails extends ErrorDetail {
    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private ZonedDateTime timestamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;

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

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }


        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.timestamp = this.timestamp;
            validationErrorDetails.title = this.title;
            validationErrorDetails.status = this.status;
            validationErrorDetails.developerMessage = this.developerMessage;
            validationErrorDetails.detail = this.detail;
            validationErrorDetails.field = this.field;
            validationErrorDetails.fieldMessage = this.fieldMessage;
            return validationErrorDetails;
        }
    }
}
