package com.iyihua.itimes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.itimes.model.Project;
import com.iyihua.itimes.repository.ProjectRepository;
import com.iyihua.model.base.ProjectDTO;
import com.iyihua.remote.base.ProjectRemote;

@Service
public class ProjectService implements ProjectRemote {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<ProjectDTO> findProjectByUserId(Long userId) {
		List<ProjectDTO> result = new ArrayList<ProjectDTO>();
		List<Project> projects = projectRepository.findByUserId(userId);
		if (projects != null && projects.size() > 0) {
			for (Project project : projects) {
				ProjectDTO dto = new ProjectDTO();
				BeanUtils.copyProperties(project, dto);
				result.add(dto);
			}
		}
		return result;
	}

	@Override
	public ProjectDTO saveProject(ProjectDTO project) {
		
		Project save = new Project();
		BeanUtils.copyProperties(project, save);
		save = projectRepository.save(save);
		BeanUtils.copyProperties(save, project);
		return project;
	}

	@Override
	public void deleteProject(Long projectId) {
		projectRepository.delete(projectId);
	}

}
