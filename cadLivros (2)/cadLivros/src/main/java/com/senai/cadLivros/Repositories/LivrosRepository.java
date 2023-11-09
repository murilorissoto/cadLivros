package com.senai.cadLivros.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cadLivros.Entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{
	
}
