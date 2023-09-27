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
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	Integer roleID;
	@Column(name="ROLENAME")
	String roleName;

	@OneToMany(mappedBy="role")
	Collection<Account> Accounts;

	public Integer getRoleId() {
		return roleID;
	}

	public void setRoleId(Integer roleId) {
		this.roleID = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<Account> getAccounts() {
		return Accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		Accounts = accounts;
	}




}
