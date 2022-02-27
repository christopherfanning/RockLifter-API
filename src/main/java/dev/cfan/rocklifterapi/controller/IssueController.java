package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IssueController {


    IssueService issueService;

    @PostMapping("/project/{projectId}/issue")
    public Issue createNewIssue(@RequestBody Issue issue,
                                @PathVariable(value = "projectId") Long projectId){

       return issueService.createNewIssue(projectId, issue);
    }

    @GetMapping
    public List<Issue> getAllIssues(){
        // All issues in the db.
        return issueService.getAllIssues();

    }

}
