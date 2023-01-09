package com.attornatus.pessoas.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.attornatus.pessoas.dtos.EnderecoDto;
import com.attornatus.pessoas.dtos.PessoaDto;
import com.attornatus.pessoas.entities.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PessoaResourceIT {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void findAllShouldReturnAllResourcesSortedByName() throws Exception {

            ResultActions result = mockMvc.perform(get("/pessoas").contentType(MediaType.APPLICATION_JSON));

            result.andExpect(status().isOk());
            result.andExpect(jsonPath("$[0].nome").value("Brad Pitt"));
        }

        @Test
        public void insertShouldInsertResource() throws Exception {

            PessoaDto dto = new PessoaDto(null, "Brad Pitt", null);
            String jsonBody = objectMapper.writeValueAsString(dto);

            ResultActions result = mockMvc.perform(post("/pessoas").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isCreated());
            result.andExpect(jsonPath("$.nome").value("Brad Pitt"));

        }

    @Test
    public void deleteShouldReturnNoContentWhenIndependentId() throws Exception {

        Long independentId = 5L;

        ResultActions result = mockMvc.perform(delete("/pessoas/{id}", independentId));

        result.andExpect(status().isNoContent());
    }

    @Test
    public void deleteShouldReturnNotFoundWhenNonExistingId() throws Exception {

        Long nonExistingId = 50L;

        ResultActions result = mockMvc.perform(delete("/pessoas/{id}", nonExistingId));

        result.andExpect(status().isNotFound());
    }
}
