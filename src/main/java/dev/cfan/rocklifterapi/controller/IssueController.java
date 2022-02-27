package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.service.IssueService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IssueController {


    IssueService issueService;

    public Issue createNewIssue(@RequestBody Issue issue){
       return issueService.createNewIssue(issue);
    }
}
