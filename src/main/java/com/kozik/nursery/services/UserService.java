package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.UserRepository;
import com.kozik.nursery.entities.Role;
import com.kozik.nursery.entities.User;
import java.util.List;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    
    @Autowired private UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public void save(User user, Set<Role> role){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRetypedPassword(encoder.encode(user.getRetypedPassword()));
        user.setRoles(role);
        userRepository.save(user);
    }
    
    public User get(String email){
        return userRepository.findById(email).get();
    }
    
    public void delete(String email){
        userRepository.deleteById(email);
    }

    public boolean isUserPresent(String email) {
       return userRepository.existsById(email);
    }
}
