package com.itsedeug.swr.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTraidores extends JpaRepository<Traidor, Long>{
	public Traidor findByNome(String nome);
	public Traidor findById(long id);
}
