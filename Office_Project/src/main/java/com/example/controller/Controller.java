package com.example.controller;

import com.example.table.Project;
import com.example.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class Controller {
	

  @Autowired
	    ProjectService projectService;

	    @PostMapping
	    public ResponseEntity<Project> createProject(@RequestBody Project p) {
	        Project createdProject = projectService.createProject(p);
	        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = projectService.getAllProjectDetails();
	        return new ResponseEntity<>(projects, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
	        Optional<Project> project = projectService.getProjectDetailsById(id);
	        return project.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
	        try {
	            Project project = projectService.updateProject(id, updatedProject);
	            return new ResponseEntity<>(project, HttpStatus.OK);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	        try {
	            projectService.deleteProject(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}



