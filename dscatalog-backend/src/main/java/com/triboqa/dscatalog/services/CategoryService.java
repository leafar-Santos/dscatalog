package com.triboqa.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triboqa.dscatalog.entities.Category;
import com.triboqa.dscatalog.entities.dto.CategoryDTO;
import com.triboqa.dscatalog.repositories.CategoryRepository;

@Service //Registra essa classe como componente do sistema de ingestão de dependepência
public class CategoryService {
	

	//Injeta a dependencia do Category reposytory para acessar os dados
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true) //Evita travar o banco para operações quando faz leitura de dados
	public List<CategoryDTO> findAll(){
		
		//Vai no repositório e retorna a lista de categorias
		List<Category> list = categoryRepository.findAll();
		
		//Converte a lista de categorias para uma lista de categorias DTO
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
				
	}

}
