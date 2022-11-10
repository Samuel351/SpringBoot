package com.project.spring;

import com.project.spring.repository.DepartamentRepository;
import com.project.spring.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration()
public class Application {
    
       @Autowired
       DepartamentRepository departamentRepository;
       
       @Autowired
       WorkerRepository workerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
