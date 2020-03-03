package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientJDBCRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientJDBCRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Inserting -> {}", clientRepository.insert(new Client(105, "Rajat", 23)));
		logger.info("Inserting -> {}", clientRepository.insert(new Client(107, "John", 22)));
		logger.info("Inserting -> {}", clientRepository.insert(new Client(109, "Smith", 24)));
		
		logger.info("Client id 101 -> {}", clientRepository.getById(101));

        

        clientRepository.deleteById(103);

        logger.info("All users -> {}", clientRepository.getAll());
    }
	


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
