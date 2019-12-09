package com.kozik.nursery;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Integer>{
    
}
