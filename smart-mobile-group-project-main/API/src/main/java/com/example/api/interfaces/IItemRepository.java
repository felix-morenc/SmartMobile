package com.example.api.interfaces;

import com.example.api.entity.Item;

import java.util.List;

public interface IItemRepository {

    Item getItem(int id);

    List<Item> getItems();

    Item saveItem(Item item);

    String deleteItemById(int id);
}
