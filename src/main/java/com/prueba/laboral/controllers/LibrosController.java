package com.prueba.laboral.controllers;

import java.util.List;
import java.util.Optional;

import com.prueba.laboral.models.LibroModel;
import com.prueba.laboral.repositorios.LibroRepo;

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
@RequestMapping("/api/libros")
public class LibrosController {

    @Autowired
    public LibroRepo libroRepo;

    @GetMapping("/all")
    public ResponseEntity<List<LibroModel>> getAllLibros() {

        try {
            return new ResponseEntity<>(libroRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Object> getLibro(@PathVariable String id) {

        try {

            return new ResponseEntity<>(libroRepo.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/crear")
    public ResponseEntity<String> createLibro(@RequestBody LibroModel libro) {

        try {
            LibroModel LibroIn = libroRepo.insert(libro);

            return new ResponseEntity<>("Libro creado " + LibroIn.getNombre(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> updateLibro(@PathVariable String id, @RequestBody LibroModel libro) {

        Optional<LibroModel> libroOptional = libroRepo.findById(id);
        if (libroOptional.isPresent()) {
            LibroModel _Model = libroOptional.get();
            _Model.setNombre(libro.getNombre());
            _Model.setAutor(libro.getAutor());
            _Model.setCategoria(libro.getCategoria());
            _Model.setCantidadDisponible(libro.getCantidadDisponible());
            _Model.setCantidadReservada(libro.getCantidadReservada());
            libroRepo.save(_Model);
            return new ResponseEntity<>("Actualizado con exito " + libroOptional.get().getNombre(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/reservar/{id}")
    public ResponseEntity<String> reservaLibro(@PathVariable String id, @RequestBody LibroModel libro) {

        Optional<LibroModel> libroOptional = libroRepo.findById(id);
        if (libroOptional.isPresent()) {
            LibroModel _Model = libroOptional.get();
            _Model.setNombre(libro.getNombre());
            _Model.setAutor(libro.getAutor());
            _Model.setCategoria(libro.getCategoria());
            _Model.setCantidadDisponible(libro.getCantidadDisponible());
            _Model.setCantidadReservada(libro.getCantidadReservada());
            return new ResponseEntity<>("Reservado con exito" + libroRepo.save(_Model), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable String id) {

        try {
            libroRepo.deleteById(id);

            return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
