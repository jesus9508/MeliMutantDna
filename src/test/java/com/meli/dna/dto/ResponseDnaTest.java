package com.meli.dna.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ResponseDnaTest {

    @Mock
    ResponseDna responseDna;

    @Test
    public void testDto(){
        Assertions.assertInstanceOf(ResponseDna.class,responseDna);
    }

    @Test
    public void testDtoContructorBool(){
        ResponseDna entity = new ResponseDna(true);
        Assertions.assertNotNull(entity);
    }

    @Test
    public void testDtoConstructor(){
        ResponseDna entity = new ResponseDna(true,"");
        Assertions.assertNotNull(entity);
    }

    @Test
    public void testDtoSetters(){
        ResponseDna entity = new ResponseDna(true,"");
        Assertions.assertNotNull(entity.getMessage());
        Assertions.assertNotNull(entity.getMutant());
    }


}
