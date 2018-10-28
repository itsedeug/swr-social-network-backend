package com.itsedeug.swr.testesdeintegracao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.itsedeug.swr.model.Base;
import com.itsedeug.swr.model.RepositorioBases;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteDoRepositorioDeBases {
	
	//gerenciador de entidades forneciso pelo spring boot permite simular persistencia
    @Autowired
    private TestEntityManager gerenciadorDeEntidades;
    @Autowired
    private RepositorioBases repositorioDeBases;

    @Test
    public void buscaDeLocaldePeloNome() {
        // configurar e salvar nova base
    	// considerndo entidade Base com atributos nome, longitude galáctica e latitude galáctica.
        Base planetaX = new Base("PlanetaX", "latitude", "longitude");
	        gerenciadorDeEntidades.persist(planetaX);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        Base base = repositorioDeBases.findByNome(planetaX.getNome());
     
        // verificar
        assertThat(base.getNome()).isEqualTo(planetaX.getNome());
    }

}
