package com.triboqa.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triboqa.dscatalog.entities.Category;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {
	
	//Primeiro EndPoint
	//Método Get todas as categorias
	
	@GetMapping()
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = new ArrayList<Category>();
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Carros"));
		list.add(new Category(3L, "Motos"));
		return ResponseEntity.ok().body(list);
		
	}
	

}
