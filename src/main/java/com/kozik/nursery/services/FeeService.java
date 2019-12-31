package com.kozik.nursery.services;

import com.kozik.nursery.entities.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.FeeRepository;
import java.util.List;

@Service
public class FeeService {
    
    @Autowired private FeeRepository feeRepository;
    
    public List<Fee> getAll(){
        return feeRepository.findAll();
    }
    
    public void save(Fee fee){
        feeRepository.save(fee);
    }
    
    public Fee get(long id){
        return feeRepository.findById(id).get();
    }
    
    public void delete(long id){
        feeRepository.deleteById(id);
    }
}
