package com.kozik.nursery.services;

import com.kozik.nursery.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.GroupRepository;
import java.util.List;
import com.kozik.nursery.entities.Group;

@Service
public class GroupService {
    
    @Autowired private GroupRepository groupRepository;
    
    public List<Group> getAll(){
        return groupRepository.findAll();
    }
    
    public void save(Group group){
        groupRepository.save(group);
    }
    
    public Group get(long id){
        return groupRepository.findById(id).get();
    }
    
    public void delete(long id){
        groupRepository.deleteById(id);
    }
    
    public List<Group> getByEmployee(Employee employee){
        return groupRepository.findByEmployees(employee);
    }
}
