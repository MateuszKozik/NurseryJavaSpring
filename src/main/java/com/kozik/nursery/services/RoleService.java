package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.kozik.nursery.repositories.RoleRepository;
import com.kozik.nursery.entities.Role;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    
    @Autowired private RoleRepository roleRepository;
    
    public List<Role> getAll(){
        return  roleRepository.findAll();
    }
    
    public void save(Role role){
        roleRepository.save(role);
    }
    
    public Role get(String name){
        return roleRepository.findById(name).get();
    }
    
    public void delete(String name){
        roleRepository.deleteById(name);
    }
}
