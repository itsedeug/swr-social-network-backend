package com.itsedeug.swr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsedeug.swr.model.Local;
import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioRebeldes;

@RestController
@RequestMapping("/atualizarLocal")
public class AtualizarController {
	
	  @Autowired
	  private RepositorioRebeldes rebeldes;// <<< Repositório de rebeldes.
	
	  @PostMapping
	  public Rebelde atualizarLocal(@RequestBody Local novoLocal) {
		String nomeRebelde = novoLocal.getRebelde();
		Rebelde rebelde = rebeldes.findByNome(nomeRebelde);
		rebelde.setLocalizacaoNome(novoLocal.getNome());
		rebelde.setLocalizacaoLatitude(novoLocal.getLatitude());
		rebelde.setLocalizacaoLongitude(novoLocal.getLongitude());
		rebeldes.deleteByNome(nomeRebelde);
		return rebeldes.save(rebelde);
	  }

}
