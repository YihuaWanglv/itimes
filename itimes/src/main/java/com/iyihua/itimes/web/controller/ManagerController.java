package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.model.base.CategoryDTO;
import com.iyihua.model.base.LocationDTO;
import com.iyihua.model.base.ProjectDTO;
import com.iyihua.model.base.TagsDTO;
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
	public List<CategoryDTO> listCategorys() {
		Long userId = 1L;
		List<CategoryDTO> result = categoryService.findCategorysByUserId(userId);
		return result;
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
		category.setUserId(1L);
		return categoryService.saveCategory(category);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.PUT)
	public CategoryDTO updateCategory(@RequestBody CategoryDTO updated, @PathVariable Long categoryId) {
		updated.setCategoryId(categoryId);
		return categoryService.saveCategory(updated);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public List<ProjectDTO> listProjects() {
		Long userId = 1L;
		List<ProjectDTO> projects = projectService.findProjectByUserId(userId);
		return projects;
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ProjectDTO createProject(@RequestBody ProjectDTO project) {
		project.setUserId(1L);
		return projectService.saveProject(project);
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
	public ProjectDTO updateProject(ProjectDTO project, @PathVariable Long projectId) {
		project.setProjectId(projectId);
		return projectService.saveProject(project);
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable Long projectId) {
		projectService.deleteProject(projectId);
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public List<LocationDTO> listLocations() {
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
	
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public List<TagsDTO> listTags() {
		Long userId = 1L;
		return tagsService.findTagsByUserId(userId);
	}
	
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public TagsDTO createTag(@RequestBody TagsDTO tag) {
		tag.setUserId(1L);
		return tagsService.saveTags(tag);
	}
	
	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.PUT)
	public TagsDTO updateTag(@RequestBody TagsDTO tag, @PathVariable Long tagId) {
		tag.setTagId(tagId);
		return tagsService.saveTags(tag);
	}
	
	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.DELETE)
	public void deleteTag(@PathVariable Long tagId) {
		tagsService.deleteTags(tagId);
	}
	
}
