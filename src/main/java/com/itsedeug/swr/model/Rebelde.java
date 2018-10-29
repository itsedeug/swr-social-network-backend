package com.itsedeug.swr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//campos
	private String nome;
	private String idade;
	private String genero;
	private String localizacaoNome;
	private String localizacaoLatitude;
	private String localizacaoLongitude;
	private int qtdArmas;
	private int qtdMunicao;
	private int qtdComida;
	private int qtdAgua;
	
	public Rebelde(
			String nome, 
			String idade, 
			String genero, 
			String localizacaoNome,
			String localizacaoLatitude, 
			String localizacaoLongitude,  
			int qtdArmas,
			int qtdMunicao,
			int qtdComida,
			int qtdAgua) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setGenero(genero);
		this.setLocalizacaoNome(localizacaoNome);
		this.setQtdArmas(qtdArmas);
		this.setQtdMunicao(qtdMunicao);
		this.setQtdComida(qtdComida);
		this.setQtdAgua(qtdAgua);
		}

	//metodos de acesso
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getIdade() { return idade; }
	public void setIdade(String idade) { this.idade = idade; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }

	public String getLocalizacaoNome() { return localizacaoNome; }
	public void setLocalizacaoNome(String local) { 	this.localizacaoNome = local; }

	public String getLocalizacaoLatitude() { return localizacaoLatitude; }
	public void setLocalizacaoLatitude(String latitude) {	this.localizacaoLatitude = latitude; }

	public String getLocalizacaoLongitude() { return localizacaoLongitude; }
	public void setLocalizacaoLongitude(String longitude) { this.localizacaoLongitude = longitude; }

	public int getQtdArmas() { return qtdArmas; }
	public void setQtdArmas(int qtdArmas) { this.qtdArmas = qtdArmas; }

	public int getQtdMunicao() { return qtdMunicao; }
	public void setQtdMunicao(int qtdMunicao) { this.qtdMunicao = qtdMunicao; }

	public int getQtdComida() { return qtdComida; }
	public void setQtdComida(int qtdComida) { this.qtdComida = qtdComida; }

	public int getQtdAgua() { return qtdAgua; }
	public void setQtdAgua(int qtdAgua) { this.qtdAgua = qtdAgua; }
}
