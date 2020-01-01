package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.RecordRepository;
import com.kozik.nursery.entities.Record;
import java.util.List;

@Service
public class RecordService {
    
    @Autowired private RecordRepository recordRepository;
    
    public List<Record> getAll(){
        return recordRepository.findAll();
    }
    
    public void save(Record record){
        recordRepository.save(record);
    }
    
    public Record get(long id){
        return recordRepository.findById(id).get();
    }
    
    public void delete(long id){
        recordRepository.deleteById(id);
    }
}
