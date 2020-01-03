package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Record;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Long>{
    Record findByChildPesel(String pesel);
    Record findTopByChildOrderByDateOfRecordDesc(Child child);
    List<Record> findByGroupNullAndDateOfRecordGreaterThan(LocalDate date);
}
