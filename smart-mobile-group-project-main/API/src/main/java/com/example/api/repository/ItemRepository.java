package com.example.api.repository;

import com.example.api.entity.EType;
import com.example.api.entity.Item;
import com.example.api.interfaces.IItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository implements IItemRepository {
    
    List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
        buildItems();
    }

    private void buildItems(){
        Item lights1 = new Item(0, EType.TYPE_LIGHTS, "Red, Yellow, Blue", "Lights 1", null);
        Item lights2 = new Item(1, EType.TYPE_LIGHTS, "Red, Green, Orange", "Lights 2", null);
        Item lights3 = new Item(2, EType.TYPE_LIGHTS, "Green, Purple, Pink", "Lights 3", null);
        items.add(lights1);
        items.add(lights2);
        items.add(lights3);
        Item song1 = new Item(3, EType.TYPE_SONG, "Cool Song", "Dope Song ", null);
        Item song2 = new Item(4, EType.TYPE_SONG, "Sad Song", "Song that makes you sad", null);
        Item song3 = new Item(5, EType.TYPE_SONG, "Happy Song", "Song that makes you happy", null);
        items.add(song1);
        items.add(song2);
        items.add(song3);
        Item theme1 = new Item(6, EType.TYPE_THEME, "Happy Theme", "Smiling Faces", null);
        Item theme2 = new Item(7, EType.TYPE_THEME, "Sad Theme", "Tears and Sadness", null);
        Item theme3 = new Item(8, EType.TYPE_THEME, "Love Theme", "Hearts and Pink Colours", null);
        items.add(theme1);
        items.add(theme2);
        items.add(theme3);
        
    }


    @Override
    public Item getItem(int id) {
        for (Item item: items) {
            if(item.getId() == id)
            {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public Item saveItem(Item item){
        items.add(item);
        return item;
    }

    @Override
    public String deleteItemById(int id)
    {
        for (Item item: items) {
            if(item.getId() == id)
            {
                items.remove(item);
                return "Item Removed!";
            }
            else
            {
                return "Item not found!";
            }
        }
        return "Item not found!";
    }


}
