package com.pablo.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.workshopmongo.domain.Post;
import com.pablo.workshopmongo.repository.PostRepository;
import com.pablo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
		
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		 maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		 return repo.fullSearch(text, minDate, maxDate);
	}
}
