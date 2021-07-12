package com.prueba.laboral.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class UsersModel {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String contraseña;
    private boolean role = false;
    private List<Object> reservas;

    public UsersModel(String id, String nombre, String apellido, String contraseña, boolean role,
            List<Object> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.role = role;
        this.reservas = reservas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public List<Object> getReservas() {
        return reservas;
    }

    public void setReservas(List<Object> reservas) {
        this.reservas = reservas;
    }

}
