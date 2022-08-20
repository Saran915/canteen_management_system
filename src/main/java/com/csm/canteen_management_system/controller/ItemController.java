package com.csm.canteen_management_system.controller;

import com.csm.canteen_management_system.dto.ItemDto;
import com.csm.canteen_management_system.model.Items;
import com.csm.canteen_management_system.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemservice;

    public ItemController(ItemService itemservice) {
        this.itemservice = itemservice;
    }

    @PostMapping
    private ResponseEntity<?> saveItem(@RequestBody ItemDto itemsDto) {
        itemservice.saveItem(itemsDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Item save successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    private ResponseEntity<?> getItem() {
        List<Items> itemList = itemservice.getItem();
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Item List get successfully.");
        response.put("data", itemList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    private ResponseEntity<?> updateItem(@PathVariable Integer id, @RequestBody ItemDto itemDto) {
        itemservice.updateItem(id, itemDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Item updated successfully.");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        itemservice.deleteItem(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Item delete successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    private ResponseEntity<?> getItemById(@PathVariable Integer id) {
        Items item = itemservice.getItemById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Item get successfully.");
        response.put("data", item);
        return ResponseEntity.ok(response);
    }
}
