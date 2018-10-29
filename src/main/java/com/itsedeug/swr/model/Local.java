package com.itsedeug.swr.model;

/**
 * bean utilizado em requisicoes post para atualizacao de local
 * @author italo
 *
 */
public class Local {
	
	private String rebelde;
	private String nome;
	private String latitude;
	private String longitude;
	
	public Local(String rebelde, String nome, String latitude, String longitude) {
		setRebelde(rebelde);
		setNome(nome);
		setLatitude(latitude);
		setLongitude(longitude);
	}
	
	public String getRebelde() { return rebelde; }
	public void setRebelde(String rebelde) { this.rebelde = rebelde; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getLatitude() { return latitude; }
	public void setLatitude(String latitude) { this.latitude = latitude; }
	public String getLongitude() { return longitude; }
	public void setLongitude(String longitude) { this.longitude = longitude; }

}
