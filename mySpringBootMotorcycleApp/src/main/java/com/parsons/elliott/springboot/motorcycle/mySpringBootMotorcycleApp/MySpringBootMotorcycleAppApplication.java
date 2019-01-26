package com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MySpringBootMotorcycleAppApplication 
{
    public static void main()
    {
        SpringApplication.run(MySpringBootMotorcycleAppApplication.class);
    }
}
