package com.prueba.laboral.controllers;

import com.prueba.laboral.models.UsersModel;
import com.prueba.laboral.repositorios.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/login")
public class Login {

    @Autowired
    public UsersRepo usersRepo;

    @GetMapping("/user")
    public boolean getUser(@RequestBody UsersModel user) {

        UsersModel loginUse = usersRepo.findByNombre(user.getNombre());
        if (loginUse.getContraseña().equals(user.getContraseña())) {

            return true;

        } else {
            return false;
        }

    }

}
