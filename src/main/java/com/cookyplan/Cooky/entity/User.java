package com.cookyplan.Cooky.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USER")
	Integer id;
	
	@OneToOne
	@JoinColumn(name="ID_ACCOUNT")
	Account accountId;
	
	@Column(name="HO")
	String ho;
	@Column(name="TEN")
	String ten;
	@Column(name="PHAI")
	String phai;
	@Column(name="DIACHI")
	String diachi;
	@Column(name="SODT")
	String sodt;
	@Column(name="EMAIL")
	String email;
	@Column(name="NGAYTAO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")	
	Date ngayCap;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	
	
	
	
	
	
}
