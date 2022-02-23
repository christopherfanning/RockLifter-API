package dev.cfan.rocklifterapi.repository;

import dev.cfan.rocklifterapi.model.Project;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
