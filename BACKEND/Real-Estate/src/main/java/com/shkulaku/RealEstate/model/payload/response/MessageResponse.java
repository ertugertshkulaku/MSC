package com.shkulaku.RealEstate.model.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
