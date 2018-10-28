package com.itsedeug.swr.testesdeintegracao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.itsedeug.swr.model.Base;
import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioBases;
import com.itsedeug.swr.model.RepositorioRebeldes;

public class TesteDoRepositorioDeRebeldes {
	
	//gerenciador de entidades forneciso pelo spring boot permite simular persistencia
    @Autowired
    private TestEntityManager gerenciadorDeEntidades;
    @Autowired
    private RepositorioBases repositorioDeBases;
    @Autowired
    private RepositorioRebeldes repositorioDeRebeldes;

    @Test
    public void buscaDeRebeldedePeloNome() {
        // configurar e salvar novo rebelde
        Base planetaX = new Base("PlanetaX", "latitude", "longitude");
        Rebelde luke = new Rebelde("Luke", "24", "M", planetaX);
        gerenciadorDeEntidades.persist(luke);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        Rebelde found = repositorioDeRebeldes.findByName(luke.getName());
     
        // verificar
        assertThat(found.getName()).isEqualTo(luke.getName());
    }
    
    @Test
    public void buscaDeRebeldedePorBase() {
        // configurar e salvar novo rebelde
        Base planetaX = new Base("PlanetaX", "latitude", "longitude");
        Rebelde luke = new Rebelde("Luke", "24", "M", planetaX);
        Rebelde ze = new Rebelde("Ze", "25", "M", planetaX);
        gerenciadorDeEntidades.persist(luke);
        gerenciadorDeEntidades.persist(ze);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        List<Rebelde> rebeldes = repositorioDeRebeldes.findByBaseName(planetaX.getName());
     
        // verificar
        assertTrue(rebeldes.size() == 2);
        assertTrue(rebeldes.contains(luke));
        assertTrue(rebeldes.contains(ze));
    }
}
