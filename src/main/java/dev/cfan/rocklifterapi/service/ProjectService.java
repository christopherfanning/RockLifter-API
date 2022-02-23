package dev.cfan.rocklifterapi.service;

import dev.cfan.rocklifterapi.model.Project;
import dev.cfan.rocklifterapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

     final
    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
