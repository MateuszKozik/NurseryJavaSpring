package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{
    
}
