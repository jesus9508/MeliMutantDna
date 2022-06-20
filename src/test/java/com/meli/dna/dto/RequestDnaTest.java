package com.meli.dna.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RequestDnaTest {

    @Test
    public void testDto(){
        Assertions.assertInstanceOf(RequestDna.class,new RequestDna());
    }

    @Test
    public void testGetters(){
        RequestDna entity = new RequestDna();
        List<String> list = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        entity.setDna(list);
        Assertions.assertNotNull(entity.getDna());
    }

}
