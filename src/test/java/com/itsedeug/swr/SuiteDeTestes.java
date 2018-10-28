package com.itsedeug.swr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.itsedeug.swr.testesdeintegracao.TesteDoRepositorioDeRebeldes;
import com.itsedeug.swr.testesdeunidade.HomeControllerTest;
import com.itsedeug.swr.testesdeunidade.TesteDeBase;
import com.itsedeug.swr.testesdeunidade.TesteDeInicializacaoAplicacaoSwrSocialNetwork;
import com.itsedeug.swr.testesdeunidade.TesteDeInventario;
import com.itsedeug.swr.testesdeunidade.TesteDeRebelde;
import com.itsedeug.swr.testesdeunidade.TesteDeRequisicaoHttp;

@RunWith(Suite.class)
@SuiteClasses({ TesteDeInicializacaoAplicacaoSwrSocialNetwork.class,  HomeControllerTest.class, TesteDeRequisicaoHttp.class,
	TesteDoRepositorioDeRebeldes.class, TesteDeBase.class, TesteDeInventario.class, TesteDeRebelde.class})
public class SuiteDeTestes {

}
