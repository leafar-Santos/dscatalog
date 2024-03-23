package com.triboqa.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triboqa.dscatalog.entities.Category;
import com.triboqa.dscatalog.entities.dto.CategoryDTO;
import com.triboqa.dscatalog.repositories.CategoryRepository;
import com.triboqa.dscatalog.services.exceptions.EntityNotFoundException;

@Service //Registra essa classe como componente do sistema de ingestão de dependepência
public class CategoryService {
	

	//Injeta a dependencia do Category reposytory para acessar os dados
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//Método que busca todas as categorias na base de dados
	@Transactional(readOnly = true) //Evita travar o banco para operações quando faz leitura de dados
	public List<CategoryDTO> findAll(){
		
		//Vai no repositório e retorna a lista de categorias
		List<Category> list = categoryRepository.findAll();
		//Converte a lista de categorias para uma lista de categorias DTO
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
				
	}

	//Método que busca a categoria por id na base de dados
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
		return new CategoryDTO(entity);
	
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		
		//Converter o dto para uma category
		Category entity =  new Category();
		entity.setName(dto.getName());
		entity = categoryRepository.save(entity);
		
		return new CategoryDTO(entity);
	}

}
