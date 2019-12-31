package com.kozik.nursery.services;

import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired EmployeeRepository employeeRepository;
    
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public void save(Employee employee){
        employeeRepository.save(employee);
    }
    
    public Employee get(long id){
        return employeeRepository.findById(id).get();
    }
    
    public void delete(long id){
        employeeRepository.deleteById(id);
    }
}
