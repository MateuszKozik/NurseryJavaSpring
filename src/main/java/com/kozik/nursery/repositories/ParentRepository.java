
package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long>{

    public boolean existsByUserEmail(String email);
    public Parent findByUserEmail(String email);
    
}
