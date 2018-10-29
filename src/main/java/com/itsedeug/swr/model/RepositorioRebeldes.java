package com.itsedeug.swr.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRebeldes extends JpaRepository<Rebelde, Long>{
	
	public Rebelde findByNome(String name);
	public Rebelde findById(long id);
	public void deleteByNome(String name);
	public Rebelde findByLocalizacaoNome(String localizacaoNome);

}
