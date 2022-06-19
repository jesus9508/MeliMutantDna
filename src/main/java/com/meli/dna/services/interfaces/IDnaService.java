package com.meli.dna.services.interfaces;

import com.meli.dna.dto.RequestDna;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDnaService {

    ResponseEntity<?> processDna(RequestDna request);

}
