package com.itsedeug.swr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entidade Base. Rebelde deve indicar local da base de origem no cadastro. 
 * @author italo
 *
 */
@Entity
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	//campos
	private String nome;
	private String latitude;
	private String longitude;

	public Base(String nome, String latitude, String longitude) {
		this.setNome(nome);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}

	//metodos de acesso
	public String getNome() { return nome; }
	public void setNome(String nome) { 	this.nome = nome; }

	public String getLatitude() { return latitude; }
	public void setLatitude(String latitude) {	this.latitude = latitude; }

	public String getLongitude() { return longitude; }
	public void setLongitude(String longitude) { this.longitude = longitude; }

}
