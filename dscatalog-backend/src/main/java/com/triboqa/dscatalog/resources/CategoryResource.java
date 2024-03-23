package com.triboqa.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.triboqa.dscatalog.entities.dto.CategoryDTO;
import com.triboqa.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	//Primeiro EndPoint
	//Método Get todas as categorias
	
	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Metodo Get para retornar categorfua por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO dto = categoryService.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	
	//Método que insere uma nova categoria 
	@PostMapping
	public ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO dto){
		dto = categoryService.insert(dto);
		
		//Cria a url do novo recurso
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	
	
	

}
