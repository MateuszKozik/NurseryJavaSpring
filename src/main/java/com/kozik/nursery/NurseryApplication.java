package com.kozik.nursery;

import java.time.LocalDate;
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
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ParentRepository parentRepository;
    
    @Override
    public void run(String... args)  {
        
        //test user entity
        User user1 = new User("user1", "test", "test@test.com","ADMIN");
        User user2 = new User("user2", "test", "test@test.com");
        User user3 = new User("user3", "test", "test@test.com");
        
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        for(User user: userRepository.findAll()){
            System.out.println(user);
        }
        
        //test employee entity
        Employee supervisor = new Employee("Joseph", "Simmons", LocalDate.now(), "123456789", user1);
        employeeRepository.save(supervisor);
        
        Employee employee1 = new Employee("Samuel", "Griffin", LocalDate.now(), "123456789", user2);
        Employee employee2 = new Employee("Sebastian", "Bennett", LocalDate.now(), "123456789", user3);
           
        employee1.setSupervisor(supervisor);
        employee1.setBaseSalary(1500.00);
        employeeRepository.save(employee1);
        
        employee2.setPosition("accountant");
        employeeRepository.save(employee2);
        for(Employee employee: employeeRepository.findAll()){
            System.out.println(employee);
        }   
        
        //test address entity
        Address address1 = new Address(14, "43-433", "Cracow");
        Address address2 = new Address(64, "56-342", "Warsaw");
        addressRepository.save(address1);
        addressRepository.save(address2);
        for(Address address: addressRepository.findAll()){
            System.out.println(address);
        }
        
        //test parent entity
        User user4 = new User("user4", "test", "test@test.com");
        User user5 = new User("user5", "test", "test@test.com");
        userRepository.save(user4);
        userRepository.save(user5);
        
        Parent parent1 = new Parent("Dominic", "Ross", "123456789", user4);
        Parent parent2 = new Parent("Sofia", "Spencer", "123456789", user5);
        
        parent1.setAddress(address1);
        parent2.setAddress(address2);
        parentRepository.save(parent1);
        parentRepository.save(parent2);
    }

}
