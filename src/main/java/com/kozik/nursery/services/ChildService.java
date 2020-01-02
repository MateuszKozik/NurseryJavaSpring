package com.kozik.nursery.services;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.repositories.ChildRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
   
    @Autowired private ChildRepository childRepository;
    
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
    
    public boolean isChildPresent(String pesel) {
          return childRepository.existsByPesel(pesel);
    }
     
    public List<Child> getByParent(Parent parent){
        return childRepository.findByParents(parent);
    } 
}
