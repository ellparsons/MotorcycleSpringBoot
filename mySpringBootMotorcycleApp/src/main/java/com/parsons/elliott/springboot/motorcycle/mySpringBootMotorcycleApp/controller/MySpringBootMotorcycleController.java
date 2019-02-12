package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.exception.MySpringBootMotorcycleException;
import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model.MySpringBootMotorcycleModel;
import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.repository.MySpringBootMotorcycleRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MySpringBootMotorcycleController {

	@Autowired
	MySpringBootMotorcycleRepository myRepository;
	
	@PostMapping("/create/motorcycle")
	public MySpringBootMotorcycleModel createMotorcycle(@Valid @RequestBody MySpringBootMotorcycleModel mSDM){
		return myRepository.save(mSDM);
	}
 
	@GetMapping("/get/all/motorcycles") 
	public List<MySpringBootMotorcycleModel> getAllVehicles()
	{ 
		return myRepository.findAll();
	} 
		
	@DeleteMapping("/delete/all/motorcycles")
	public void deleteAllVehicles()
	{
		List<MySpringBootMotorcycleModel> mSDM = myRepository.findAll();
		myRepository.deleteAll(mSDM);
	}
}
