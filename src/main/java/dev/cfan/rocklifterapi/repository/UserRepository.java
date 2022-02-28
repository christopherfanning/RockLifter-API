package dev.cfan.rocklifterapi.repository;

import dev.cfan.rocklifterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Stolen from the https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring/blob/master/README.md
//    boolean existsByEmail(String emailAddress);

    User findByEmail(String email);

    User findByName(String name);
}
