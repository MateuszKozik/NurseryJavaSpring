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
        
    @Override
    public void run(String... args)  {
        
        //test user entity
        userRepository.save(new User("test", "test", "test@test.com","ADMIN"));
        for(User user: userRepository.findAll()){
            System.out.println(user);
        }
        
        //test employee entity
        Employee supervisor = new Employee("Joseph", "Simmons", LocalDate.now(), "123456789");
        employeeRepository.save(supervisor);
        
        Employee employee1 = new Employee("Samuel", "Griffin", LocalDate.now(), "123456789");
        Employee employee2 = new Employee("Sebastian", "Bennett", LocalDate.now(), "123456789");
           
        employee1.setSupervisor(supervisor);
        employee1.setBaseSalary(1500.00);
        employeeRepository.save(employee1);
        
        employee2.setPosition("accountant");
        employeeRepository.save(employee2);
        for(Employee employee: employeeRepository.findAll()){
            System.out.println(employee);
        }
    }

}
