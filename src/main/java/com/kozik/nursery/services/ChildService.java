package com.kozik.nursery.services;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.repositories.ChildRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
   
    @Autowired ChildRepository childRepository;
    
    public List<Child> getAll(){
        return childRepository.findAll();
    }
    
    public void save(Child child){
        childRepository.save(child);
    }
    
    public Child get(String pesel){
        return childRepository.findById(pesel).get();
    }
    
    public void delete(String pesel){
        childRepository.deleteById(pesel);
    }
}
