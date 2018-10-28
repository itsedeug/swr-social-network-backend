package com.itsedeug.swr.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRebeldes extends JpaRepository<Rebelde, Long>{
	
	public Rebelde findByName(String name);
	public List<Rebelde> findByBaseName(String nomeDaBase);

}
