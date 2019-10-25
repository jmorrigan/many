/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juan
 */

@Entity
@Table(name="autor")
public class Autor implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id_autor;
   
   @Column
   private String nombre;
   
   @Column
   @Temporal(TemporalType.DATE)
   private Date fecha;
   
   @OneToMany(mappedBy = "autor")
   private List<AutorLibro> autorLibro;

    public Autor() {
    }

   
   
    public Autor(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<AutorLibro> getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(List<AutorLibro> autorLibro) {
        this.autorLibro = autorLibro;
    }
   
   
   
   
}
