
package com.kozik.nursery;

import com.kozik.nursery.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
    
}
