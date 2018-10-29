package com.itsedeug.swr.testesdeintegracao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioRebeldes;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteDoRepositorioDeRebeldes {
	
	//gerenciador de entidades forneciso pelo spring boot permite simular persistencia
    @Autowired
    private TestEntityManager gerenciadorDeEntidades;
    @Autowired
    private RepositorioRebeldes repositorioDeRebeldes;

    @Test
    public void buscaDeRebeldedePeloNome() {
        // configurar e salvar novo rebelde
        Rebelde luke = new Rebelde("Luke", "24", "M", "PlanetaX", "latitude", "longitude",1, 1, 0, 0);
        gerenciadorDeEntidades.persist(luke);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        Rebelde encontrado = repositorioDeRebeldes.findByNome(luke.getNome());
     
        // verificar
        assertThat(encontrado.getNome()).isEqualTo(luke.getNome());
        assertThat(encontrado.getIdade()).isEqualTo(luke.getIdade());
        assertThat(encontrado.getGenero()).isEqualTo(luke.getGenero());
        assertThat(encontrado.getLocalizacaoNome()).isEqualTo(luke.getLocalizacaoNome());
        assertThat(encontrado.getLocalizacaoLatitude()).isEqualTo(luke.getLocalizacaoLatitude());
        assertThat(encontrado.getLocalizacaoLongitude()).isEqualTo(luke.getLocalizacaoLongitude());
        assertThat(encontrado.getQtdArmas() == luke.getQtdArmas());
        assertThat(encontrado.getQtdMunicao() == luke.getQtdMunicao());
        assertThat(encontrado.getQtdComida() == luke.getQtdComida());
        assertThat(encontrado.getQtdAgua() == luke.getQtdAgua());
    }
}
