package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.ParentRepository;
import com.kozik.nursery.entities.Parent;
import java.util.List;

@Service
public class ParentService {
    
    @Autowired private ParentRepository parentRepository;
    
    public List<Parent> getAll(){
        return parentRepository.findAll();
    }
    
    public void save(Parent parent){
        parentRepository.save(parent);
    }
    
    public Parent get(long id){
        return parentRepository.findById(id).get();
    }
    
    public void delete(long id){
        parentRepository.deleteById(id);
    }
}
