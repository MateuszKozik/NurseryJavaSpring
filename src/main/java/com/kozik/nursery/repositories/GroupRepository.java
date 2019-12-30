
package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer>{
    
}
