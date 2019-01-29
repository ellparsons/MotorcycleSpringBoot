package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Motorcycle")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate","lastModified"}, allowGetters = true)
public class MySpringBootMotorcycleModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank 
	private String manufacturer;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String displacement;
	
	@NotBlank
	private String classM;
	
	@NotBlank
	private String horsepower;
	
	@NotBlank
	private int price;
	
	@NotBlank
	private String license;

	public MySpringBootMotorcycleModel() {
		
	}
	
	public MySpringBootMotorcycleModel(long id, @NotBlank String manufacturer, @NotBlank String brand,
		@NotBlank String displacement, @NotBlank String classM, @NotBlank String horsepower, @NotBlank int price,
		@NotBlank String license) {
	super();
	this.id = id;
	this.manufacturer = manufacturer;
	this.brand = brand;
	this.displacement = displacement;
	this.classM = classM;
	this.horsepower = horsepower;
	this.price = price;
	this.license = license;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	public String getClassM() {
		return classM;
	}
	public void setClassM(String classM) {
		this.classM = classM;
	}
	public String getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}


	
	
}
