package com.kozik.nursery;

import com.kozik.nursery.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Integer>{
    
}
