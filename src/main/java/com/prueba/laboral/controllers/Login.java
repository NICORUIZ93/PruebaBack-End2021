package com.prueba.laboral.controllers;

import java.util.List;

import com.prueba.laboral.models.UsersModel;
import com.prueba.laboral.repositorios.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/login")
public class Login {

    @Autowired
    public UsersRepo usersRepo;

    @PostMapping("/user")
    public ResponseEntity<List<UsersModel>> login() {

        try {

            return new ResponseEntity<>(usersRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
