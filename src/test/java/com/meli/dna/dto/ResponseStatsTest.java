package com.meli.dna.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ResponseStatsTest {
    @Mock
    ResponseStats responseStats;

    @Test
    public void testDto(){
        Assertions.assertInstanceOf(ResponseStats.class,responseStats);
    }
    @Test
    public void testContructors(){
        ResponseStats entity = new ResponseStats(1.0,1.0,1.0);
        Assertions.assertNotNull(entity);
    }

    @Test
    public void testGetters(){
        ResponseStats entity = new ResponseStats(1.0,1.0,1.0);
        Double human = entity.getCount_human_dna();
        Double ratio = entity.getRatio();
        Double mutant = entity.getCount_mutant_dna();

        Assertions.assertNotNull(human);
        Assertions.assertNotNull(ratio);
        Assertions.assertNotNull(mutant);
    }
}
