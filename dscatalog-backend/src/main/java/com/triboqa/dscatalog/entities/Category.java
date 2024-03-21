package com.triboqa.dscatalog.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	
	
	//Construtor padrão
	public Category() {
		
	}

	//Construtor com argumento
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	//Geters Setters
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

	
	//hashCode and Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
