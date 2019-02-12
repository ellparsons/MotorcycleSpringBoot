package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@Entity
@Table(name = "Motorcycle")
@EntityListeners(AuditingEntityListener.class)

public class MySpringBootMotorcycleModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idm;
	
	@NotNull
	private String manufacturer;
	
	@NotNull
	private String model;
	
	
	private String displacement;
	
	@NotNull
	private String category;
	
	
	private String horsepower;
	
	
	private Integer price; 
	
	@NotNull 
	private String license;

	public MySpringBootMotorcycleModel() {
	}

	public MySpringBootMotorcycleModel(Integer idm, String manufacturer, String model, String displacement, String category,
			String horsepower, Integer price, String license) {
		super();
		this.idm = idm;
		this.manufacturer = manufacturer;
		this.model = model;
		this.displacement = displacement;
		this.category = category;
		this.horsepower = horsepower;
		this.price = price;
		this.license = license;
	}



	public Integer getId() {
		return idm;
	}

	public void setId(Integer idm) {
		this.idm = idm;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}


}
