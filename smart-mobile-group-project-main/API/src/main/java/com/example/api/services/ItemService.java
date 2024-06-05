package com.example.api.services;

import com.example.api.entity.Item;
import com.example.api.interfaces.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private IItemRepository repository;

    public Item getItemById(int id) {return repository.getItem(id);}

    public List<Item> getItems() {return repository.getItems();}

    public Item saveItem(Item item) {return repository.saveItem(item);}

    public String deleteItemById(int id) {return repository.deleteItemById(id);}



}
