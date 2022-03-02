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
        if (project.isPresent()) {
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

    public Issue getSingeIssue(Long issueId) throws Exception {
        Optional<Issue> issue = issueRepository.findById(issueId);
        if (issue.get() == null) {
            throw new Exception("Issue not found");
        }

        return issue.get();
    }

    public Issue updateSingeIssue(Long issueId, Issue issue) throws Exception {
        Optional<Issue> oldIssue = issueRepository.findById(issueId);
        if (oldIssue.get() == null) {
            throw new Exception("Issue not found");
        }

        // update the contents of the old post with the new stuff.
        oldIssue.get().setTitle(issue.getTitle());
        oldIssue.get().setDescription(issue.getDescription());
        oldIssue.get().setStatus(issue.getStatus());
        oldIssue.get().setType(issue.getType());
        return issueRepository.save(oldIssue.get());



    }
}
