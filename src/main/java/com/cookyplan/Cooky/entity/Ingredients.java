package com.cookyplan.Cooky.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "NAME")
	String name;
	@Column(name = "PRICE")
	Integer price;
	@Column(name = "CALORIES")
	Integer calories;
	@Column(name = "UNIT")
	String unit;
	
	@OneToMany(mappedBy="ingredients")
	Collection<FoodDetails> foodDetails;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Collection<FoodDetails> getFoodDetails() {
		return foodDetails;
	}

	public void setFoodDetails(Collection<FoodDetails> foodDetails) {
		this.foodDetails = foodDetails;
	}

	
	
}