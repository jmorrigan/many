/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.controller;

import com.juan.DTO.AutorDTO;
import com.juan.DTO.LibroDTO;
import com.juan.DTO.RelDTO;
import com.juan.entity.Autor;
import com.juan.entity.AutorLibro;
import com.juan.entity.Libro;
import com.juan.interfaz.AutorFacadeLocal;
import com.juan.interfaz.AutorLibroFacadeLocal;
import com.juan.interfaz.LibroFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/**
 *
 * @author juan
 */
@Named(value = "vistaController")
@SessionScoped
public class vistaController implements Serializable {

    @EJB
    private LibroFacadeLocal libroEJB;
    
    @EJB
    private AutorFacadeLocal autorEJB;
    
    @EJB
    private AutorLibroFacadeLocal autorLibroEJB;
    
    
    private LibroDTO libro;
    
    private AutorDTO autor;
    
    private RelDTO autorLibro;
    
    
    private int lista;
    
    /**
     * Creates a new instance of vistaController
     */
    
    
    @PostConstruct
    public void init(){
        libro = new LibroDTO();
        autor = new AutorDTO();
        autorLibro = new RelDTO();
    }
    public vistaController() {
    }

    public void crear(AutorDTO aut, LibroDTO lib, RelDTO autlib){
        
          
          Autor auto = new Autor (aut.getNombre(), aut.getFecha());
          Libro libr = new Libro(lib.getNombre(), lib.getEditorial());
          
          AutorLibro autolibr = new AutorLibro(auto, libr, autlib.getCiudad(), autlib.getFecha());
          autolibr.setAutor(auto);
          autolibr.setLibro(libr);
          
          List<AutorLibro> obtenido = new ArrayList<>();
          obtenido.add(autolibr);
          
          libr.setAutorLibro(obtenido);
          
          autorEJB.create(auto);
          libroEJB.create(libr);
          
    }
    
   
    
    public void crearLibroExistente(){
        
    }
    
    public List<Libro> libro(){
        return this.libroEJB.findAll();
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public RelDTO getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(RelDTO autorLibro) {
        this.autorLibro = autorLibro;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }
    
    
}
