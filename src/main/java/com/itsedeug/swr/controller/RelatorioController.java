package com.itsedeug.swr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioRebeldes;
import com.itsedeug.swr.model.RepositorioTraidores;
import com.itsedeug.swr.model.Traidor;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {
	  @Autowired
	  private RepositorioRebeldes rebeldes;
	  @Autowired
	  private RepositorioTraidores traidores;
	   
	  @GetMapping
	  public String pesquisar() {
		List<Rebelde> listaR = rebeldes.findAll();
		List<Traidor> listaT = traidores.findAll();
		float porcentagemDeTraidores = ((float) listaT.size() / (float) listaR.size()) * 100;
		float porcentagemDeRebeldes = 100 - porcentagemDeTraidores;
	    return "Porcentagem de traidores: " + porcentagemDeTraidores + ", " 
			+ "Porcentagem de rebeldes: " + porcentagemDeRebeldes;
	  }
}
