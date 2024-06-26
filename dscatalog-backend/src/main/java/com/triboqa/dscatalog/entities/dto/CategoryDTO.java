package com.triboqa.dscatalog.entities.dto;

import java.io.Serializable;

import com.triboqa.dscatalog.entities.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;

	
	//Construtor padão do DTO
	public CategoryDTO() {
		
	}

	
	//Construtor com argumentos do DTO
	public CategoryDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	/***
	 * Construtor que recebe a entidade principal Category
	 */
	public CategoryDTO(Category entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	
	//GET e SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
