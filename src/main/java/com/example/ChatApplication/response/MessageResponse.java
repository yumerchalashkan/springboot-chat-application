package com.example.ChatApplication.response;

public class MessageResponse {
    private String message;
    private String sender;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
