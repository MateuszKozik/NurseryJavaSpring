package com.kozik.nursery;

import com.kozik.nursery.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
