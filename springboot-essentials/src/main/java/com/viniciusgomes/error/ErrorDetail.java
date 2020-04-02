package com.viniciusgomes.error;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ErrorDetail {
    protected String title;
    protected int status;
    protected String detail;
    protected ZonedDateTime timestamp;
    protected String developerMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ZonedDateTime getTimestamp() {
        ZoneId defaultZone = ZoneId.systemDefault();
        timestamp = LocalDateTime.now().atZone(defaultZone);
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {

        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
