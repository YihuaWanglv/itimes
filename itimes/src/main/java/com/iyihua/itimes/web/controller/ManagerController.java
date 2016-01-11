package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.model.base.CategoryDTO;
import com.iyihua.remote.base.CategoryRemote;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	CategoryRemote categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<CategoryDTO> listCategory() {
		
		Long userId = 1L;
		List<CategoryDTO> result = categoryService.findCategorysByUserId(userId);
		
		return result;
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public CategoryDTO addCategory(@RequestBody CategoryDTO category) {
		category.setUserId(1L);
		return categoryService.saveCategory(category);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public CategoryDTO updateCategory(@RequestBody CategoryDTO updated, @PathVariable Long id) {
		updated.setCategoryId(id);
		return categoryService.saveCategory(updated);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
