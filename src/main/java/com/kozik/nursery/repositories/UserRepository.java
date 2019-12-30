package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    
}
