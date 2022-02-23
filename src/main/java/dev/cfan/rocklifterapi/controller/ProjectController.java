package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello!";
    }

    @GetMapping("/project/")
    public List<Project> getAllProjects(){
//        List<Project> = new ArrayList<>();
        return new ArrayList<Project>();

    }
}
