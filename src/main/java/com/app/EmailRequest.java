package com.app;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailContent;
    private String tone;

    // Constructor for GET API usage
    public EmailRequest(String emailContent, String tone) {
        this.emailContent = emailContent;
        this.tone = tone;
    }

    // Default constructor (required for POST deserialization)
    public EmailRequest() {
    }
}
