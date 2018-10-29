package com.itsedeug.swr.testesdeintegracao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.itsedeug.swr.model.Rebelde;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteDeIntegracaoCriacaoDeRebelde {
	
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void criarRebelde() {
    	Rebelde rebelde = new Rebelde("Luke", "24", "M", "PlanetaX", "latitude", "longitude",1, 1, 0, 0);
        
        ResponseEntity<Rebelde> responseEntity =
            restTemplate.postForEntity("/rebeldes", rebelde, Rebelde.class);
        Rebelde res = responseEntity.getBody();
        assertThat(HttpStatus.CREATED).isEqualTo(responseEntity.getStatusCode());
        assertThat("Luke").isEqualTo(res.getNome());
    }
}
