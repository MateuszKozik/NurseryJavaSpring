package com.kozik.nursery;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private FeeRepository feeRepository;
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private RoomRepository roomRepository;
    
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
        User user6 = new User("user6", "test", "test@test.com");
        
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        
        Parent parent1 = new Parent("Dominic", "Ross", "123456789", user4);
        Parent parent2 = new Parent("Sofia", "Spencer", "123456789", user5);
        Parent parent3 = new Parent("Rebecca ", "Ross", "123456789", user6);
        
        parent1.setAddress(address1);
        parent2.setAddress(address2);
        parentRepository.save(parent1);
        parentRepository.save(parent2);
        parentRepository.save(parent3);
        
        //test child entity
        Child child1 = new Child("18290785718", "Emma", "Ross");
        Child child2 = new Child("19252536841", "Ewie", "Ross");
        Child child3 = new Child("19272884588", "John", "Spencer");
        
       childRepository.save(child1);
       childRepository.save(child2);
       childRepository.save(child3);
       
       Set <Child> children = new HashSet<Child>();
       children.add(child1);
       children.add(child2);
       
       parent1.setChildren(children);
       parent3.setChildren(children);
   
       parentRepository.save(parent1);
       parentRepository.save(parent3);
       
       children.clear();
       children.add(child3);
       parent2.setChildren(children);
    
       parentRepository.save(parent2);
       
       //test group entity
       Group group1 = new Group("One year");
       Group group2 = new Group("Two year");
       
       groupRepository.save(group1);
       groupRepository.save(group2);
       
       Set<Group> group = new HashSet<Group>();
       group.add(group1);
       
       employee1.setGroups(group);
       employeeRepository.save(employee1);
       
       group.clear();
       group.add(group2);
       employee2.setGroups(group);
       employeeRepository.save(employee2);
       
       //test fee entity
       Fee fee1 = new Fee(1200.00, 360.00, LocalDate.now());
       feeRepository.save(fee1);
       
       //test record entity
       Record record1 = new Record(LocalDate.of(2019, 12, 12), 3, child1);
       record1.setFee(fee1);
       record1.setGroup(group1);
       recordRepository.save(record1);
      
       //test room entity
       Room room1 = new Room("Playroom");
       roomRepository.save(room1);
       
       Set<Room> rooms = new HashSet<Room>();
       rooms.add(room1);
       group1.setRooms(rooms);
       groupRepository.save(group1);

       employee1.setRooms(rooms);
       employee2.setRooms(rooms);
       employeeRepository.save(employee1);
       employeeRepository.save(employee2);
    }

}
