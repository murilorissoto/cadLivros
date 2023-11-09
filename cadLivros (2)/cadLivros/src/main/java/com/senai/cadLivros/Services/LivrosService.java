package com.senai.cadLivros.Services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.cadLivros.Entities.*;
import com.senai.cadLivros.Repositories.*;

@Service
public class LivrosService {
	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosService( LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}
	
	public Livros saveLivros (Livros livros) {
		return livrosRepository.save(livros);
	}
	
	public Livros getLivrosById (Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
	
	public List<Livros> getAllLivros(){
		return livrosRepository.findAll();
	}
	
	public void deleteLivros (Long id) {
		livrosRepository.deleteById(id);
	}
		
		// Update dos livros com Optional
		public Livros updateLivros(Long id, Livros novoLivros) {
			Optional<Livros> LivrosOptional = livrosRepository.findById(id);
			if (LivrosOptional.isPresent()) {
				Livros livrosExistente = LivrosOptional.get();
					livrosExistente.setdescricao(novoLivros.getisbn());
				livrosExistente.setisbn(novoLivros.getisbn());
					return livrosRepository.save(livrosExistente);
			}else{
				return null;
			}
	}

}
