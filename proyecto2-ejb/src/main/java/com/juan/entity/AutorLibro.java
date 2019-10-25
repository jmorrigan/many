/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juan
 */
@Entity
@Table(name="autor_libro")
public class AutorLibro implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;
    
    
    @Id
    @ManyToOne
    @JoinColumn(name="libro_id")
    private Libro libro;
  
    @Column 
    private String ciudad;

    @Column 
    @Temporal(TemporalType.DATE)
    private Date fecha_publicacion;
    
    

    public AutorLibro() {
    }

    public AutorLibro(Autor autor, Libro libro, String ciudad, Date fecha_publicacion) {
        this.autor = autor;
        this.libro = libro;
        this.ciudad = ciudad;
        this.fecha_publicacion = fecha_publicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
  
}
