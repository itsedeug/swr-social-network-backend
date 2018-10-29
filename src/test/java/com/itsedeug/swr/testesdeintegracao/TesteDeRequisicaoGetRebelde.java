package com.itsedeug.swr.testesdeintegracao;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsedeug.swr.model.Rebelde;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@WebMvcTest
public class TesteDeRequisicaoGetRebelde {
	
    @LocalServerPort
    private int port;
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    Rebelde rebelde;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private TestEntityManager gerenciadorDeEntidades;

    @Test
    public void deveRetornarRebeldeRecemAdicionado() throws Exception {
    	rebelde = new Rebelde("Luke", "24", "M", "PlanetaX", "latitude", "longitude",1, 1, 0, 0);
    	gerenciadorDeEntidades.persist(rebelde);
        gerenciadorDeEntidades.flush();
        
        mockMvc.perform(get("/rebeldes" + "/Luke")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(rebelde)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nome", is("Luke")))
            .andExpect(jsonPath("$.idade", is("24")))
            .andExpect(jsonPath("$.genero", is("M")));
    }

}
