package com.kozik.nursery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NurseryApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NurseryApplication.class, args);
	}

    @Autowired
    private UserRepository userRepository;
        
    @Override
    public void run(String... args)  {
        userRepository.save(new User("test", "test", "test@test.com","ADMIN"));
        System.out.println(userRepository.findAll());
    }

}
