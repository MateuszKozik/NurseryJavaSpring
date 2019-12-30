package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeeRepository extends JpaRepository<Fee, Long>{
    
}
