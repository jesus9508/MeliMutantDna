package com.meli.dna.services;

import com.meli.dna.dto.RequestDna;
import com.meli.dna.projections.IStats;
import com.meli.dna.repositories.IDnaRepository;
import com.meli.dna.services.logic.AbstractMutantDna;
import com.meli.dna.services.logic.validator.ValidMutantDna;
import com.meli.dna.services.logic.validator.interfaces.IValidMutantDna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DnaServiceTest {
    @Mock
    IValidMutantDna iValidMutantDna;

    @Mock
    IDnaRepository iDnaRepository;

    @InjectMocks
    DnaService dnaService;

    @InjectMocks
    ValidMutantDna validMutantDna;

    @Test
    public void processDnaTest(){
        List<String> list = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        Mockito.when(iValidMutantDna.validationsList(Mockito.any())).thenReturn(getValidResponse("true",null));
        ResponseEntity<?> result = dnaService.processDna(getRequestCorrectInstance(list));
        Assertions.assertTrue(result.getStatusCodeValue() == 200);
    }

    @Test
    public void processDnaTestWithFatalError(){
        List<String> list = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        //the error is because valid is null
        Mockito.when(iValidMutantDna.validationsList(Mockito.any())).thenReturn(getValidResponse(null,null));
        ResponseEntity<?> result = dnaService.processDna(getRequestCorrectInstance(list));
        Assertions.assertTrue(result.getStatusCodeValue() == 500);
    }

    @Test
    public void processDnaTestWithFatalErrorException(){
        List<String> list = Arrays.asList("ATGCGA","CAGTGC");
        //the error is because valid is null
        Mockito.when(iValidMutantDna.validationsList(Mockito.any())).thenReturn(getValidResponse("true",null));
        ResponseEntity<?> result = dnaService.processDna(getRequestCorrectInstance(list));
        Assertions.assertTrue(result.getStatusCodeValue() == 500);
    }

    @Test
    public void validError(){
        List<String> list = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        RequestDna requestForService = getRequestCorrectInstance(list);
        //the error is because valid is null
        Map<String,String> result = validMutantDna.validationsList(requestForService);
        Assertions.assertEquals("true", result.get("valid"));
    }

    @Test
    public void validErrorNumberOfCharacters(){
        List<String> list = Arrays.asList("AGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        RequestDna requestForService = getRequestCorrectInstance(list);
        //the error is because valid is null
        Map<String,String> result = validMutantDna.validationsList(requestForService);
        Assertions.assertEquals("false", result.get("valid"));
    }

    @Test
    public void validErrorListEmpty(){
        List<String> list = Arrays.asList();
        RequestDna requestForService = getRequestCorrectInstance(list);
        //the error is because valid is null
        Map<String,String> result = validMutantDna.validationsList(requestForService);
        Assertions.assertEquals("false", result.get("valid"));
    }

    @Test
    public void validErrorInvalidCharacter(){
        List<String> list = Arrays.asList("ATFCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        RequestDna requestForService = getRequestCorrectInstance(list);
        //the error is because valid is null
        Map<String,String> result = validMutantDna.validationsList(requestForService);
        Assertions.assertEquals("false", result.get("valid"));
    }

    @Test
    public void testAbstractMethod(){
        AbstractMutantDna absctractEntity = new AbstractMutantDna() {
            @Override
            public Boolean isMutant() {
                return super.isMutant();
            }
        };

        Assertions.assertEquals(false,absctractEntity.isMutant());
    }
    @Test
    public void getStatsTest(){
        Mockito.when(iDnaRepository.getStatsOf(Mockito.anyLong())).thenReturn(getResponseStats(1.0));
        ResponseEntity<?> result = dnaService.getStats();
        Assertions.assertTrue(result.getStatusCodeValue() == 200);
    }

    private IStats getResponseStats(double value){
        return () -> value;
    }

    private RequestDna getRequestCorrectInstance(List<String> list){
        RequestDna request = new RequestDna();
        request.setDna(list);
        return request;
    }

    private Map<String,String> getValidResponse(String valid,String message){
        Map<String,String> response = new HashMap<>();
        response.put("valid",valid);
        response.put("message",message);
        return response;
    }
}
