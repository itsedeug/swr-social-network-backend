package com.itsedeug.swr.testesdeunidade;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itsedeug.swr.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {

    @Autowired
    private HomeController controller;

    @Test
    public void carregarContextoDaAplicacaoHomeController() throws Exception {
        assertThat(controller).isNotNull();
    }

}
