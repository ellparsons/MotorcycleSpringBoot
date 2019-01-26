package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate","lastModified"}, allowGetters = true)
public class MySpringBootMotorcycleModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank 
	private String Manufacturer;
	
	@NotBlank
	private String Brand;
	
	@NotBlank
	private String Displacement;
	
	@NotBlank
	private String ClassM;
	
	@NotBlank
	private String Horsepower;
	
	@NotBlank
	private int Price;
	
	@NotBlank
	private String License;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedDate;
	
	public MySpringBootMotorcycleModel() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getDisplacement() {
		return Displacement;
	}

	public void setDisplacement(String displacement) {
		Displacement = displacement;
	}

	public String getClassM() {
		return ClassM;
	}

	public void setClassM(String classM) {
		ClassM = classM;
	}

	public String getHorsepower() {
		return Horsepower;
	}

	public void setHorsepower(String horsepower) {
		Horsepower = horsepower;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getLicense() {
		return License;
	}

	public void setLicense(String license) {
		License = license;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
}
