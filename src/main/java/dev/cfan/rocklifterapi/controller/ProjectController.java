package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Project;
import dev.cfan.rocklifterapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200" )
//@CrossOrigin(origins = "*", exposedHeaders="Access-Control-Allow-Origin")
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://rocklifter.herokuapp.com" )
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping("/hello")
    public String getHello(){
        System.out.println("We are hitting the hello world route.");
        return "Hello!";
    }

    @GetMapping("/project")
    public List<Project> getAllProjects(){
        System.out.println("Get all projects hit.");
        return projectService.getAllProjects();

    }


    @PostMapping("/project")
    public Project createProject(@RequestBody Project project){
        System.out.println("Create project hit.");
        return projectService.createProject(project);
    }

    @DeleteMapping("/project/{projectId}")
    public Project deleteProject(@PathVariable(value = "projectId") Long projectId){
        System.out.println("Delete project hit.");
        return projectService.deleteProject(projectId);

    }

    @PutMapping("/project/{projectId}")
    public Project updateProject(@PathVariable(value = "projectId") Long projectId) {
        System.out.println("Update project hit");
        return projectService.updateProject(projectId);
    }

    @GetMapping("project/{projectId}")
    public Project getSingleProject(@PathVariable(value = "projectId") Long projectId) throws Exception {
        System.out.println("Getting a single project");
        return projectService.getSingleProject(projectId);
    }

}
