package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.table.Project;

public interface ProjectRespository extends JpaRepository<Project, Long> {

}
