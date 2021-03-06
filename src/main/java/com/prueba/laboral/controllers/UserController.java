package com.prueba.laboral.controllers;

import java.util.List;
import java.util.Optional;

import com.prueba.laboral.models.UsersModel;
import com.prueba.laboral.repositorios.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UsersRepo usersRepo;

    @GetMapping("/all")
    public ResponseEntity<List<UsersModel>> getAllUser() {

        try {
            return new ResponseEntity<>(usersRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/user")
    public UsersModel getUser(@RequestBody UsersModel user) {

        UsersModel loginUse = usersRepo.findByNombre(user.getNombre());

        return loginUse;

    }

    @GetMapping("/userid/{id}")
    public Optional<UsersModel> getUserId(@PathVariable String id) {

        Optional<UsersModel> loginUse = usersRepo.findById(id);

        return loginUse;

    }

    @PostMapping("/crear")
    public ResponseEntity<String> createUser(@RequestBody UsersModel user) {

        try {

            usersRepo.insert(user);

            return new ResponseEntity<>("Usuario creado " + user.getNombre(), HttpStatus.OK);
        } catch (

        Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UsersModel user) {

        Optional<UsersModel> usersOptional = usersRepo.findById(id);
        if (usersOptional.isPresent()) {
            UsersModel _Model = usersOptional.get();
            _Model.setNombre(user.getNombre());
            _Model.setApellido(user.getApellido());
            _Model.setContrase??a(user.getContrase??a());
            _Model.setReservas(user.getReservas());
            usersRepo.save(_Model);
            return new ResponseEntity<>("Actualizado con exito " + user.getNombre(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {

        try {
            usersRepo.deleteById(id);
            return new ResponseEntity<>("Usuario Eliminado" + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
