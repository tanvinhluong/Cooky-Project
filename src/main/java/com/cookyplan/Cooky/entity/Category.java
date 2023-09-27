
package com.cookyplan.Cooky.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cookyplan.Cooky.entity.CategoryDetails;

@Entity

@Table(name = "category")
public class Category {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID_CATEGORY")
	private Integer id;

	@Column(name = "NAME")
	private String name;

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

	@OneToMany(mappedBy = "category")
	Collection<CategoryDetails> categoryDetails;

	public Collection<CategoryDetails> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(Collection<CategoryDetails> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

}
