package com.kozik.nursery;

import com.kozik.nursery.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer>{
    
}
