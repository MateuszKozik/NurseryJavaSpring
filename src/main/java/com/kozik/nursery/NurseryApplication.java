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
        addressRepository.save(new Address(14, "43-433", "Cracow"));
        addressRepository.save(new Address(64, "56-342", "Warsaw"));
        for(Address address: addressRepository.findAll()){
            System.out.println(address);
        }
    }

}
