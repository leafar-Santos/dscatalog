package com.triboqa.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triboqa.dscatalog.entities.Category;
import com.triboqa.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	//Primeiro EndPoint
	//Método Get todas as categorias
	
	@GetMapping()
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryService.listaTodasCategorias();
		return ResponseEntity.ok().body(list);

	}
	

}
