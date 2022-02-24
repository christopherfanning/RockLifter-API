package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Project;
import dev.cfan.rocklifterapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200" )
//@CrossOrigin(origins = "https://rocklifter.cfan.dev" )
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping("/hello")
    public String getHello(){
        return "Hello!";
    }

    @GetMapping("/project")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();

    }


    @PostMapping("/project")
    public Project createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @DeleteMapping("/project/{projectId}")
    public Project deleteProject(@PathVariable(value = "projectId") Long projectId){
        return projectService.deleteProject(projectId);

    }

    @PutMapping("/project/{projectId}")
    public Project updateProject(@PathVariable(value = "projectId") Long projectId) {
        return projectService.updateProject(projectId);
    }


}
