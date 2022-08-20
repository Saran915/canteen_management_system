package com.csm.canteen_management_system.service;

import com.csm.canteen_management_system.dto.ItemDto;
import com.csm.canteen_management_system.model.Items;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDto itemDto);

    List<Items> getItem();

    void updateItem(Integer id, ItemDto itemDto);

    void deleteItem(Integer id);

    Items getItemById(Integer id);
}
