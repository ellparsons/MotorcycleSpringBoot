package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model.MySpringBootMotorcycleModel;

public interface MySpringBootMotorcycleRepository extends JpaRepository<MySpringBootMotorcycleModel,Integer>{

}
