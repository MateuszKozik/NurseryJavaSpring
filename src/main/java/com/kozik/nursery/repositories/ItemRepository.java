package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
