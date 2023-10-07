
package com.cookyplan.Cooky.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity

@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORY")
	private Integer id;

	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy="categoryId")
	List<CategoryDetails> categorydetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDetails> getCategorydetails() {
		return categorydetails;
	}

	public void setCategorydetails(List<CategoryDetails> categorydetails) {
		this.categorydetails = categorydetails;
	}
	
	


}
