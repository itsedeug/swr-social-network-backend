package com.itsedeug.swr.testesdeintegracao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.itsedeug.swr.model.Base;
import com.itsedeug.swr.model.Inventario;
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
        Base planetaX = new Base("PlanetaX", "latitude", "longitude");
        Inventario inv = new Inventario(1, 1, 0, 0);
        Rebelde luke = new Rebelde("Luke", "24", "M", planetaX, inv);
        gerenciadorDeEntidades.persist(luke);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        Rebelde encontrado = repositorioDeRebeldes.findByNome(luke.getNome());
     
        // verificar
        assertThat(encontrado.getNome()).isEqualTo(luke.getNome());
        assertThat(encontrado.getIdade()).isEqualTo(luke.getIdade());
        assertThat(encontrado.getGenero()).isEqualTo(luke.getGenero());
        assertThat(encontrado.getLocalizacao().getNome()).isEqualTo(planetaX.getNome());
        assertThat(encontrado.getLocalizacao().getLatitude()).isEqualTo(planetaX.getLatitude());
        assertThat(encontrado.getLocalizacao().getLongitude()).isEqualTo(planetaX.getLongitude());
        assertThat(encontrado.getInventario().getQtdArmas()).isEqualTo(inv.getQtdArmas());
        assertThat(encontrado.getInventario().getQtdMunicao()).isEqualTo(inv.getQtdMunicao());
        assertThat(encontrado.getInventario().getQtdAgua()).isEqualTo(inv.getQtdAgua());
        assertThat(encontrado.getInventario().getQtdComida()).isEqualTo(inv.getQtdComida());
    }
    
    @Test
    public void buscaDeRebeldedePorBase() {
        // configurar e salvar novo rebelde
        Base planetaX = new Base("PlanetaX", "latitude", "longitude");
        Rebelde luke = new Rebelde("Luke", "24", "M", planetaX, new Inventario(1, 1, 0, 0));
        Rebelde ze = new Rebelde("Ze", "25", "M", planetaX, new Inventario(1, 0, 3, 2));
        gerenciadorDeEntidades.persist(luke);
        gerenciadorDeEntidades.persist(ze);
        gerenciadorDeEntidades.flush();
     
        // chamada de metodo de consulta em repositorio de bases
        List<Rebelde> rebeldes = repositorioDeRebeldes.findByLocalizacao(planetaX);
     
        // verificar
        assertTrue(rebeldes.size() == 2);
        assertTrue(rebeldes.contains(luke));
        assertTrue(rebeldes.contains(ze));
    }
}
