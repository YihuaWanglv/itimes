package com.iyihua.itimes.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iyihua.model.base.ItemDTO;
import com.iyihua.remote.base.ItemRemote;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemRemote itemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<ItemDTO> findItemsByUser() {
		
		Long userId = 1L;
		return itemService.findItemsByUserId(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ItemDTO addItem(@RequestBody ItemDTO item) {
		return itemService.saveItem(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ItemDTO updateItem(@RequestBody ItemDTO updatedItem, @PathVariable Long id) {
		updatedItem.setItemId(id);
		return itemService.saveItem(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
	}
}
