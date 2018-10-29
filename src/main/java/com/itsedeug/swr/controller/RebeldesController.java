package com.itsedeug.swr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsedeug.swr.model.Rebelde;
import com.itsedeug.swr.model.RepositorioRebeldes;

@RestController
@RequestMapping("/rebeldes")
public class RebeldesController {
	
	  @Autowired
	  private RepositorioRebeldes rebeldes;// <<< Repositório de rebeldes.
	 
	  @GetMapping("/{nome}")
	  public Rebelde buscarPeloNome(@PathVariable String nome) {
	    return rebeldes.findByNome(nome);
	  }
	  
	  @GetMapping("/{id}")
	  public Rebelde buscar(@PathVariable long id) {
	    return rebeldes.findById(id);
	  }
	   
	  @GetMapping
	  public List<Rebelde> pesquisar() {
	    return rebeldes.findAll();
	  }
	   
	  @PostMapping
	  public Rebelde salvar(@RequestBody Rebelde rebelde) {
	    return rebeldes.save(rebelde);
	  }
	 
	  @DeleteMapping("/{nome}")
	  public void deletar(@PathVariable String nome) {
	    rebeldes.deleteByNome(nome);
	  }
}
