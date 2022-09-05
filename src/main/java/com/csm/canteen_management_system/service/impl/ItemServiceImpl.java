package com.csm.canteen_management_system.service.impl;

import com.csm.canteen_management_system.dto.ItemDto;
import com.csm.canteen_management_system.exceptions.ResourceNotFoundException;
import com.csm.canteen_management_system.model.Items;
import com.csm.canteen_management_system.repo.ItemRepository;
import com.csm.canteen_management_system.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(ItemDto itemDto) {
        Items item = Items.builder()
                .itemName(itemDto.getItemName())
                .itemPrice(itemDto.getItemPrice())
                .itemImage(itemDto.getItemImage())
                .build();
        itemRepository.save(item);
    }

    @Override
    public List<Items> getItem() {
        List<Items> itemList = itemRepository.findAll();
        return itemList;
    }

    @Override
    public void updateItem(Integer id, ItemDto itemDto) {
//        Optional<Items> item = itemRepository.findById(id);
//        if(!item.isPresent()){
//            throw new RuntimeException("Item not found.");
//        }
//        Items item1 = item.get();
//        item1.setItemName(itemDto.getItemName());
//        item1.setItemPrice(itemDto.getItemPrice());
//        item1.setItemImage(itemDto.getItemImage());
//        itemRepository.save(item1);

        Items item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "item Id", id));
        item.setItemName(itemDto.getItemName());
        item.setItemPrice(itemDto.getItemPrice());
        item.setItemImage(itemDto.getItemImage());
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        Items item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "item Id", id));
        itemRepository.delete(item);
    }

    @Override
    public Items getItemById(Integer id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "item Id", id));
    }

}
