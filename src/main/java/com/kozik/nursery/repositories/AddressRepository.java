package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long>{

    public Address findByParentsParentID(long id);
    
}
