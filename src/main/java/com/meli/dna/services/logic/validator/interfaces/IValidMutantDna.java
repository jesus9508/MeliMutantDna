package com.meli.dna.services.logic.validator.interfaces;

import com.meli.dna.dto.RequestDna;

import java.util.List;
import java.util.Map;

public interface IValidMutantDna {
    Map<String,String> validationsList(RequestDna request);
}
