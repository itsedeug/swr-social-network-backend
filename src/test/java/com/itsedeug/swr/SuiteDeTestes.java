package com.itsedeug.swr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.itsedeug.swr.testesdeintegracao.TesteDoRepositorioDeBases;
import com.itsedeug.swr.testesdeintegracao.TesteDoRepositorioDeRebeldes;
import com.itsedeug.swr.testesdeunidade.TesteDeInicializacaoAplicacaoSwrSocialNetwork;
import com.itsedeug.swr.testesdeunidade.TesteDeRequisicaoHttp;

@RunWith(Suite.class)
@SuiteClasses({ TesteDeInicializacaoAplicacaoSwrSocialNetwork.class,  TesteDeRequisicaoHttp.class,
	TesteDoRepositorioDeBases.class, TesteDoRepositorioDeRebeldes.class})
public class SuiteDeTestes {

}
