package dev.cfan.rocklifterapi.service;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;

    public Issue createNewIssue(Issue issue) {
        return issueRepository.save(issue);
    }
}
