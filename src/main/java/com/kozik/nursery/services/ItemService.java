package com.kozik.nursery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozik.nursery.repositories.ItemRepository;
import com.kozik.nursery.entities.Item;
import java.util.List;

@Service
public class ItemService {
    
    @Autowired private ItemRepository itemRepository;
    
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
    
    public void save(Item item){
        itemRepository.save(item);
    }
    
    public Item get(long id){
        return itemRepository.findById(id).get();
    }
    
    public void delete(long id){
        itemRepository.deleteById(id);
    }
}
