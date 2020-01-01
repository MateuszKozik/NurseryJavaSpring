package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.RoomRepository;
import com.kozik.nursery.entities.Room;
import java.util.List;

@Service
public class RoomService {
    
    @Autowired private RoomRepository roomRepository;
    
    public List<Room> getAll(){
        return roomRepository.findAll();
    }
    
    public void save(Room room){
        roomRepository.save(room);
    }
    
    public Room get(long id){
        return roomRepository.findById(id).get();
    }
    
    public void delete(long id){
        roomRepository.deleteById(id);
    }
}
