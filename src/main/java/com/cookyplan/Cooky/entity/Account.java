package com.cookyplan.Cooky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String username;
	String password;
//	String userRole;

	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToOne
	@JoinColumn(name="ROLENAME")
	Role role;	
	@OneToOne(mappedBy="account")
	User user;
	@OneToOne(mappedBy="account")
	Admin admin;

	
}