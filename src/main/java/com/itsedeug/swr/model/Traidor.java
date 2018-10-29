package com.itsedeug.swr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Traidor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private List<String> delatores;
	
	public Traidor() {
		delatores = new ArrayList<String>();
	}

	public String getNome() { return nome; }
	public void setNome(String nomeDoTraidor) { this.nome = nomeDoTraidor; }
	
	public List<String> getDelatores() { return delatores; }
	public void addDelator(String nomeDoDelator) {
		if( (!delatores.contains(nomeDoDelator))) { delatores.add(nomeDoDelator); }
	}
}
