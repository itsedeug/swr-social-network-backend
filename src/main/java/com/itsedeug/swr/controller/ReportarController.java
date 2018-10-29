package com.itsedeug.swr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsedeug.swr.model.RepositorioRebeldes;
import com.itsedeug.swr.model.RepositorioTraidores;

@RestController
@RequestMapping("/reportar")
public class ReportarController {

	  @Autowired
	  private RepositorioRebeldes rebeldes;
	  @Autowired
	  private RepositorioTraidores traidores;
	 
	  @GetMapping("/{nome}")
	  public void buscarPeloNome(@PathVariable String nome) {
	  }
	  
}
