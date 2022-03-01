package dev.cfan.rocklifterapi.service;

import dev.cfan.rocklifterapi.model.Issue;
import dev.cfan.rocklifterapi.model.Project;
import dev.cfan.rocklifterapi.repository.IssueRepository;
import dev.cfan.rocklifterapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(project.isPresent()){
            issueObject.setProject(project.get());
            System.out.println("Issue getting saved!");
            return issueRepository.save(issueObject);
        }

        return issueRepository.save(issueObject);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }


    public List<Issue> getProjectIssues(Long projectId) {
        Project project = projectRepository.getById(projectId);
        return project.getIssueList();
    }

    public List<Issue> getClosedIssues(Long projectId) {
        Project project = projectRepository.getById(projectId);
        List<Issue> closedList = new ArrayList<>();
        for (Issue p : project.getIssueList()) {
            if (p.getStatus().equals("closed")) {
                closedList.add(p);
            }
        }
        return closedList;
    }

    public List<Issue> getOpenIssues(Long projectId) {
        Project project = projectRepository.getById(projectId);
        List<Issue> closedList = new ArrayList<>();
        for (Issue p : project.getIssueList()) {
            if (p.getStatus().equals("open")) {
                closedList.add(p);
            }
        }
        return closedList;
    }
}
