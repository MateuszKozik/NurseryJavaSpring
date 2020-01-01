package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.UserRepository;
import com.kozik.nursery.entities.User;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    
    @Autowired private UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public void save(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRetypePassword(encoder.encode(user.getRetypePassword()));
        userRepository.save(user);
    }
    
    public User get(String email){
        return userRepository.findById(email).get();
    }
    
    public void delete(String email){
        userRepository.deleteById(email);
    }
}
