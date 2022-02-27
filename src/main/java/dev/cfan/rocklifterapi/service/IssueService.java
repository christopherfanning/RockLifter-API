package dev.cfan.rocklifterapi.service;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.model.Project;
import dev.cfan.rocklifterapi.repository.IssueRepository;
import dev.cfan.rocklifterapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    ProjectRepository projectRepository;

    public Issue createNewIssue(Long projectId, Issue issueObject) {
        Optional<Project> project = projectRepository.findById(projectId);
        if(project.get() != null){
            issueObject.setProject(project.get());
        }

        return issueRepository.save(issueObject);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }


}
