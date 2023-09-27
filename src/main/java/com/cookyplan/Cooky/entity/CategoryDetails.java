
package com.cookyplan.Cooky.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "categorydetails")
public class CategoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ID")
	Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY")
	Category category;
	
	@ManyToOne
	@JoinColumn(name = "ID_FOOD")
	Foods foods;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
