/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.DTO;

import java.io.Serializable;

/**
 *
 * @author juan
 */
public class LibroDTO implements Serializable {
    private String nombre;
    
    private String editorial;

    public LibroDTO() {
    }

    public LibroDTO(String nombre, String editorial) {
        this.nombre = nombre;
        this.editorial = editorial;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
}
