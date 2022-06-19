package com.meli.dna.dto;

public class ResponseFailDna {
    String message;

    public ResponseFailDna(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
