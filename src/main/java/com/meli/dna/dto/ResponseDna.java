package com.meli.dna.dto;

public class ResponseDna {
    String message;
    Boolean isMutant;

    public ResponseDna(String message) {
        this.message = message;
    }
    public ResponseDna(Boolean isMutant) {
        this.isMutant = isMutant;
    }

    public ResponseDna(Boolean isMutant,String message) {
        this.isMutant = isMutant;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getMutant() {
        return isMutant;
    }

    public void setMutant(Boolean mutant) {
        isMutant = mutant;
    }
}
