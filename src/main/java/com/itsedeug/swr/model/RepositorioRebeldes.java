package com.itsedeug.swr.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRebeldes extends JpaRepository<Rebelde, Long>{
	
	public Rebelde findByNome(String name);
	public List<Rebelde> findByLocalizacao(Base base);

}
