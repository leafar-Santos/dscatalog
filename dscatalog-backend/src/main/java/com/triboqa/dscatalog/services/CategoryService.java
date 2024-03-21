package com.triboqa.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triboqa.dscatalog.entities.Category;
import com.triboqa.dscatalog.repositories.CategoryRepository;

@Service //Registra essa classe como componente do sistema de ingestão de dependepência
public class CategoryService {
	

	//Injeta a dependencia do Category reposytory para acessar os dados
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listaTodasCategorias(){
		return categoryRepository.findAll();
		
	}

}
