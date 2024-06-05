package com.example.api.controller;


import com.example.api.entity.Item;
import com.example.api.interfaces.IItemRepository;
import com.example.api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> getItems() {return service.getItems();}

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable int id) {return service.getItemById(id);}

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item)
    {
        return service.saveItem(item);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id)
    {
        return service.deleteItemById(id);
    }





}
