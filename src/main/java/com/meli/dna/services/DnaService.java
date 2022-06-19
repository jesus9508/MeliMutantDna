package com.meli.dna.services;

import com.meli.dna.dto.RequestDna;
import com.meli.dna.dto.ResponseFailDna;
import com.meli.dna.services.interfaces.IDnaService;
import com.meli.dna.services.logic.MutantDna;
import com.meli.dna.services.logic.validator.interfaces.IValidMutantDna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DnaService implements IDnaService {

    @Autowired
    IValidMutantDna iValidMutantDna;

    @Override
    public ResponseEntity<?> processDna(RequestDna request) {

        Map<String, String> validated = iValidMutantDna.validationsList(request.getList());
        String valid = validated.get("valid");
        String message = validated.get("message");
        if(valid.equals("false")){
           return getResponseEntity(setResponseFailDna(message),HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private ResponseEntity<?> getResponseEntity(Object object, HttpStatus httpStatus){
        return new ResponseEntity<>(object,httpStatus);
    }

    private ResponseFailDna setResponseFailDna(String message){
        return new ResponseFailDna(message);
    }
}
