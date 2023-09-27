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
@Table(name="foods")
public class Foods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	Integer id;
	@Column(name="FOODNAME")
	String foodName;
	@Column(name="PREPARETIME")
	String prepareTime;
	@Column(name="COOKINGTIME")
	String cookingTime;
	@Column(name="DIFFICULTY")
	String difficulty;
	@Column(name="TIPS")
	String tips;
	@Column(name="RECIPE")
	String recipe;
	@Column(name="DETAILS")
	String details;
	
	
	@OneToMany(mappedBy="foods")
	Collection<CategoryDetails> categoryDetails;
	
	@OneToMany(mappedBy="foods")
	Collection<FoodDetails> foodDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getPrepareTime() {
		return prepareTime;
	}

	public void setPrepareTime(String prepareTime) {
		this.prepareTime = prepareTime;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Collection<CategoryDetails> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(Collection<CategoryDetails> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public Collection<FoodDetails> getFoodDetails() {
		return foodDetails;
	}

	public void setFoodDetails(Collection<FoodDetails> foodDetails) {
		this.foodDetails = foodDetails;
	}
	
	
	
}