package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://rocklifter.herokuapp.com" )
@RestController
@RequestMapping("/api")
public class IssueController {


    @Autowired
    IssueService issueService;

    @PostMapping("/project/{projectId}/issue")
    public Issue createNewIssue(@RequestBody Issue issue,
                                @PathVariable(value = "projectId") Long projectId){
        System.out.println("Create new issue is gettting called.");
       return issueService.createNewIssue(projectId, issue);
    }

    @GetMapping("/issues")
    public List<Issue> getAllIssues(){
        System.out.println("Get all the issues is being called. ");
        // All issues in the db.
        return issueService.getAllIssues();

    }

    @GetMapping("/project/{projectId}/issue")
    public List<Issue> getProjectIssues(@PathVariable(value = "projectId") Long projectId){
        return issueService.getProjectIssues(projectId);
    }
}
