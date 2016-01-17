package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.itimes.model.Tags;
import com.iyihua.model.base.CategoryDTO;
import com.iyihua.model.base.LocationDTO;
import com.iyihua.model.base.ProjectDTO;
import com.iyihua.remote.base.CategoryRemote;
import com.iyihua.remote.base.LocationRemote;
import com.iyihua.remote.base.ProjectRemote;
import com.iyihua.remote.base.TagsRemote;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	CategoryRemote categoryService;
	@Autowired
	ProjectRemote projectService;
	@Autowired
	LocationRemote locationService;
	@Autowired
	TagsRemote tagsService;

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
	
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public List<ProjectDTO> listProject() {
		Long userId = 1L;
		List<ProjectDTO> result = projectService.findProjectByUserId(userId);
		return result;
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ProjectDTO createProject(@RequestBody ProjectDTO project) {
		project.setUserId(1L);
		return projectService.saveProject(project);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.PUT)
	public ProjectDTO updateProject(@RequestBody ProjectDTO updated, @PathVariable Long id) {
		updated.setProjectId(id);
		return projectService.saveProject(updated);
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable Long projectId) {
		projectService.deleteProject(projectId);
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public List<LocationDTO> listLocation() {
		Long userId = 1L;
		List<LocationDTO> result = locationService.findLoationByUserId(userId);
		return result;
	}

	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public LocationDTO createLocation(@RequestBody LocationDTO location) {
		location.setUserId(1L);
		return locationService.saveLocation(location);
	}

	@RequestMapping(value = "/location/{locationId}", method = RequestMethod.PUT)
	public LocationDTO updateLocation(@RequestBody LocationDTO updated, @PathVariable Long locationId) {
		updated.setLocationId(locationId);
		return locationService.saveLocation(updated);
	}

	@RequestMapping(value = "/location/{locationId}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable Long locationId) {
		locationService.deleteLoation(locationId);
	}
	
}
