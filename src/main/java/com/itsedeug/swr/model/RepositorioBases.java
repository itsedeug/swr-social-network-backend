package com.itsedeug.swr.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioBases extends JpaRepository<Base, Long> {
	
	public Base findByNome(String nome);

}
