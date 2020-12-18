package com.ruchi.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruchi.assignment.domain.Catalogue;
import com.ruchi.assignment.repository.CatalogueRepository;



@Service
public class CatalogueService {
	@Autowired
	private CatalogueRepository repo;
	
	public List<Catalogue> listAll() {
		return repo.findAll();
	}
	
	public List<Catalogue> findByText(String product) {
		return repo.findByText(product);
	}

	public void save(Catalogue std) {
		repo.save(std);
	}
	
	public Catalogue get(int id) {
		return repo.findById(id).get();
	}

	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
