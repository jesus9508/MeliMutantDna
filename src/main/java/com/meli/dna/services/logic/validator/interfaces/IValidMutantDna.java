package com.meli.dna.services.logic.validator.interfaces;

import java.util.List;
import java.util.Map;

public interface IValidMutantDna {
    Map<String,String> validationsList(List<String> request);
}
