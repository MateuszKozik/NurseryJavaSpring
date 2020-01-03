
package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Group;
import com.kozik.nursery.entities.Employee;
import java.util.HashSet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long>{
    List<Group> findByEmployees(Employee employee);
}
