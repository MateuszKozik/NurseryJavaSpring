package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Long>{
    Record findByChildPesel(String pesel);
}
