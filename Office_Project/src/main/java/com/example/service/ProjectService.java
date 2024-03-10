package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.respository.ProjectRespository;
import com.example.table.Project;

public class ProjectService {

	@Autowired
	ProjectRespository projectRespository;

	public Project createProject(Project p) {
		return projectRespository.save(p);
	}

	public List<Project> getAllProjectDetails() {
		return projectRespository.findAll();
	}

	public Optional<Project> getProjectDetailsById(Long id) {
		return projectRespository.findById(id);
	}

	public Project updateProject(Long id, Project updatedProject) {

		Optional<Project> optionalProject = projectRespository.findById(id);
		if (optionalProject.isPresent()) {
			Project existingProject = optionalProject.get();
			
			existingProject.setName(updatedProject.getName());
			existingProject.setDescription(updatedProject.getDescription());
			existingProject.setStartDate(updatedProject.getStartDate());
			existingProject.setEndDate(updatedProject.getEndDate());

			return projectRespository.save(existingProject);
		} else {
			throw new IllegalArgumentException("Project not found with id: " + id);
		}
	}

	
	 public void deleteProject(Long id) {
        Project project = projectRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + id));

        projectRespository.delete(project);
    }
}
