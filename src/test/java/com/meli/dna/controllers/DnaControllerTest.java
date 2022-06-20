package com.meli.dna.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dna.dto.RequestDna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class DnaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postDna() throws Exception {
        List<String> list = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
        Integer actualResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getRequestDna(list))))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getStatus();
        Assertions.assertEquals(actualResult,200);
    }

    @Test
    public void postDnaErrorRequest() throws Exception {
        List<String> list = Arrays.asList("FTGCGA","CAGTGC","TTCTGT","AGAAGG","CCCCTA","TCACTG");
        Integer actualResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getRequestDna(list))))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn().getResponse().getStatus();
        Assertions.assertEquals(actualResult,403);
    }

    @Test
    public void postDnaErrorRequestInvalidRange() throws Exception {
        List<String> list = Arrays.asList("FTGC","CAGTGC","TTCTGT","AGAAGG","CCCCTA","TCACTG");
        Integer actualResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getRequestDna(list))))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn().getResponse().getStatus();
        Assertions.assertEquals(actualResult,403);
    }

    @Test
    public void getStats() throws Exception {
        Integer actualResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/stats").contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getStatus();
        Assertions.assertEquals(actualResult,200);
    }

    public RequestDna getRequestDna(List<String> list){
        RequestDna entity = new RequestDna();
        entity.setDna(list);
        return entity;
    }

    public static String asJsonString(RequestDna requestDna) {
        try {
            return new ObjectMapper().writeValueAsString(requestDna);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
