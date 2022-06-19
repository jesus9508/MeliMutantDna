package com.meli.dna.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dna.dto.RequestDna;
import com.meli.dna.services.interfaces.IDnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DnaController {

    @Autowired
    private IDnaService iDnaService;

    @PostMapping("/dna")
    ResponseEntity<?> postDna(@RequestBody RequestDna requestDna) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        System.out.println(obj.writeValueAsString(requestDna));

        return iDnaService.processDna(requestDna);
    }
}