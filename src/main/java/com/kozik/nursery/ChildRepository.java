
package com.kozik.nursery;

import com.kozik.nursery.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String>{
    
}
