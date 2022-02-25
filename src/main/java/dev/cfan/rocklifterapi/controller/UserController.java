package dev.cfan.rocklifterapi.controller;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
