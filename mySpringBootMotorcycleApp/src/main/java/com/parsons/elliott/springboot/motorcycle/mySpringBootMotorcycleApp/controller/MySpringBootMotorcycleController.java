package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api")
public class MySpringBootMotorcycleController {

	@Autowired
	MySpringBootMotorcycleRepository myRepository;
	
	//Method to create a motorcycle//
	@PostMapping("/create/motorcycle")
	public MySpringBootMotorcycleModel createMotorcycleByID(@Valid @RequestBody MySpringBootMotorcycleModel mSDM){
		return myRepository.save(mSDM);
	}
	
	//Method to get all motorcycles//
	public List<MySpringBootMotorcycleModel> getAllVehicles()
	{
		return myRepository.findAll();
	}
	
	//Method to get a motorcycle//
	@GetMapping("/motorcycle/id/{id}")
	public MySpringBootMotorcycleModel getMotorcycleByID(@PathVariable("id")Long motorcycleID) {
		return myRepository.findById(motorcycleID).orElseThrow(()-> new MySpringBootMotorcycleException("MySpringBootMotorcycleModel","id",motorcycleID));
	}
	
	//Method to remove a vehicle//
	@DeleteMapping("/motorycycle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable("id")Long motorcycleID){
		MySpringBootMotorcycleModel mSDM = myRepository.findById(motorcycleID).orElseThrow(()->new MySpringBootMotorcycleException("vehicle","id",motorcycleID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
}
