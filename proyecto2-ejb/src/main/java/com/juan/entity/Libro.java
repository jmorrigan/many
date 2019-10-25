/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "libro")
public class Libro implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id_libro;
   
   @Column
   private String nombre;
   
   @Column
   private String editorial;
   
   
   @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
   private List<AutorLibro> autorLibro;

    public Libro() {
    }

    public Libro(String nombre, String editorial){
        this.nombre = nombre;
        this.editorial = editorial;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
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

    public List<AutorLibro> getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(List<AutorLibro> autorLibro) {
        this.autorLibro = autorLibro;
    }
   
   
   
}
