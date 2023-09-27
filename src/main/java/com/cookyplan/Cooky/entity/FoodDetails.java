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
@Table(name = "fooddetails")

public class FoodDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "QUANTITY")
	Integer quantity;
	@Column(name = "UNITPRICE")
	String unitPrice;
	@Column(name = "UNITCALORIES")
	String unitCalories;

	@ManyToOne
	@JoinColumn(name = "ID_INGREDIENTS")
	Ingredients ingredients;

	@ManyToOne
	@JoinColumn(name = "ID_FOOD")
	Foods foods;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitCalories() {
		return unitCalories;
	}

	public void setUnitCalories(String unitCalories) {
		this.unitCalories = unitCalories;
	}
}