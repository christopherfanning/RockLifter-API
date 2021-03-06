package dev.cfan.rocklifterapi.repository;

import dev.cfan.rocklifterapi.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
