package com.itsedeug.swr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioRebeldes;

@Controller
public class AdicionarController {
	
	@Autowired
	private RepositorioRebeldes repositorioDeRebeldes;
	
	@GetMapping("/adicionar")
	public String exibirFormularioDeAdicaoDeRebelde() {
		return "FormularioicaoDeRebeldes";
	}
	
	@PostMapping("/adicionar")
	public void salvarRebelde(Rebelde rebelde) {
		this.repositorioDeRebeldes.save(rebelde);
	}

}
