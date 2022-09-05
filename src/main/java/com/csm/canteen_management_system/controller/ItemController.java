package com.csm.canteen_management_system.controller;

import com.csm.canteen_management_system.dto.ApiResponse;
import com.csm.canteen_management_system.dto.ItemDto;
import com.csm.canteen_management_system.model.Items;
import com.csm.canteen_management_system.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemservice;

    public ItemController(ItemService itemservice) {
        this.itemservice = itemservice;
    }

    @PostMapping
    private ResponseEntity<ApiResponse> saveItem(@RequestBody ItemDto itemsDto) {
        itemservice.saveItem(itemsDto);
        ApiResponse apiResponse = new ApiResponse("Item save successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    private ResponseEntity<ApiResponse> getItem() {
        List<Items> itemList = itemservice.getItem();
        ApiResponse apiResponse = new ApiResponse("Item list get successfully", true, itemList);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    private ResponseEntity<ApiResponse> updateItem(@PathVariable Integer id, @RequestBody ItemDto itemDto) {
        itemservice.updateItem(id, itemDto);
        ApiResponse apiResponse = new ApiResponse("Item update successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<ApiResponse> deleteItem(@PathVariable Integer id) {
        itemservice.deleteItem(id);
        ApiResponse apiResponse = new ApiResponse("Item delete successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("{id}")
    private ResponseEntity<ApiResponse> getItemById(@PathVariable Integer id) {
        Items item = itemservice.getItemById(id);
        ApiResponse apiResponse = new ApiResponse("Item get successfully", true , item);
        return ResponseEntity.ok(apiResponse);
    }
}
