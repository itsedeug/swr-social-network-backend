package com.itsedeug.swr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entidade Rebelde. Com atributos de acordo com especificacao. 
 * @author italo
 *
 */
@Entity
public class Rebelde implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	//campos
	private String nome;
	private String idade;
	private String genero;
	private Base localizacao;
	private Inventario inventario;

	public Rebelde(String nome, String idade, String genero, Base localizacao, Inventario inv) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setGenero(genero);
		this.setLocalizacao(localizacao);
		this.setInventario(inv);
	}

	//metodos de acesso
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getIdade() { return idade; }
	public void setIdade(String idade) { this.idade = idade; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }

	public Base getLocalizacao() { return localizacao; }
	public void setLocalizacao(Base localizacao) { this.localizacao = localizacao; }

	public Inventario getInventario() { return inventario; }
	public void setInventario(Inventario inventario) { this.inventario = inventario; }
}
