package com.kozik.nursery.services;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.RecordRepository;
import com.kozik.nursery.entities.Record;
import java.util.List;

@Service
public class RecordService {
    
    @Autowired private RecordRepository recordRepository;
    @Autowired
    private FeeService feeService;
    
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
    
    public void saveByParent(Child child, String date){
        Record record = new Record();
        Fee fee = feeService.getLast();
        record.setChild(child);
        record.setDateOfRecord(date);
        record.setFee(fee);
        recordRepository.save(record);
    }
}
