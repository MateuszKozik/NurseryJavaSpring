
package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    public boolean existsByUserEmail(String email);

    public Employee findByUserEmail(String email);
    
}
