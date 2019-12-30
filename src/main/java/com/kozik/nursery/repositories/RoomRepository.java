package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>{
    
}
