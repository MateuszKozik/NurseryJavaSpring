package com.kozik.nursery.services;

import com.kozik.nursery.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.kozik.nursery.repositories.AddressRepository;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired private AddressRepository addressRepository;
    
    public List<Address> getAll(){
        return addressRepository.findAll();
    } 
    
    public void save(Address adress){
        addressRepository.save(adress);
    }
    
    public Address get(long id){
        return addressRepository.findById(id).get();
    }
    
    public void delete(long id){
       addressRepository.deleteById(id);
    }

    public Address getByParent(long id) {
        return addressRepository.findByParentsParentID(id);
    }

    public Address getByEmployee(long id) {
        return addressRepository.findByEmployeesEmployeeID(id);
    }
}
