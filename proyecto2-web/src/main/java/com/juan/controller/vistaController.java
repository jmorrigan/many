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
import com.juan.entity.Vista;
import com.juan.interfaz.AutorFacadeLocal;
import com.juan.interfaz.AutorLibroFacadeLocal;
import com.juan.interfaz.LibroFacadeLocal;
import com.juan.interfaz.VistaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    @EJB
    private VistaFacadeLocal vistaEJB;
    
    private LibroDTO libro;
    
    private AutorDTO autor;
    
    private RelDTO autorLibro;
    
    
    private int lista, lista2;
    
    private List<Vista> reporte;
    
    /**
     * Creates a new instance of vistaController
     */
    
    
    @PostConstruct
    public void init(){
        libro = new LibroDTO();
        autor = new AutorDTO();
        autorLibro = new RelDTO();
        reporte = new ArrayList<>();
    }
    public vistaController() {
    }

    public void crear(AutorDTO aut, LibroDTO lib, RelDTO autlib){
        
         if (aut.getNombre().equals("") || aut.getFecha() == null || lib.getEditorial().equals("") || lib.getNombre().equals("") || autlib.getCiudad().equals("") || autlib.getFecha() == null){
            FacesMessage msg = new FacesMessage("INCORRECTO", "Credenciales incorrectas");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        
        }else{
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
          
           FacesMessage msg = new FacesMessage("CORRECTO", "Agregado correctamente");
           FacesContext.getCurrentInstance().addMessage(null, msg);
         }
    }
    
    public void agregarAutorLibro(AutorDTO a, RelDTO al){
        if (lista == 0 || a.getNombre().equals("") || a.getFecha() == null || al.getCiudad().equals("") || al.getFecha() == null){
            FacesMessage msg = new FacesMessage("INCORRECTO", "Credenciales incorrectas");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        
        }else{
        
        Libro lib = libroEJB.find(lista);
        Autor aut = new Autor(a.getNombre(), a.getFecha());
        
        AutorLibro autlib = new AutorLibro(aut, lib, al.getCiudad(), al.getFecha());
        autlib.setAutor(aut);
        autlib.setLibro(lib);
        
        lib.getAutorLibro().add(autlib);
        autorEJB.create(aut);
        autorLibroEJB.create(autlib);
           
        FacesMessage msg = new FacesMessage("CORRECTO", "Agregado correctamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        
    }
    
    public void editarAutorLibroDesdeLibro( RelDTO al){
        List<Libro> listast = libroEJB.listarPorId(lista);
        
        for(Libro l : listast){
            for(AutorLibro a: l.getAutorLibro()){
                a.setCiudad(al.getCiudad());
            }
            libroEJB.edit(l);
        }
    }
   
    public void eliminarAutor(){
         List<Autor> listaAut = autorEJB.encontarPorId(lista2);
         
         for(Autor aut : listaAut){
             for(AutorLibro a : aut.getAutorLibro()){
                 autorLibroEJB.remove(a);
                 //Libro l = libroEJB.find(a.getLibro().getId_libro());
                 //libroEJB.remove(l);
             }
                autorEJB.remove(aut);
         }
    }
    
    
    public List<Vista> datos(){
        return this.vistaEJB.reporte();
    }
    
    public void eliminarLibro(){
         List<Libro> listaAut = libroEJB.listarPorId(lista);
         
         for(Libro l : listaAut){
             for(AutorLibro a : l.getAutorLibro()){
                 autorLibroEJB.remove(a);
             }
             libroEJB.remove(l);
         }
    }
    
    public void relacionarAutorExistenteLibroExistente(RelDTO r){
        Libro l = libroEJB.find(lista);
        Autor a = autorEJB.find(lista2);
        
        AutorLibro autlib = new AutorLibro(a, l, r.getCiudad(), r.getFecha());
        autlib.setAutor(a);
        autlib.setLibro(l);
        autorLibroEJB.create(autlib);
    }
    
    
    public void crearLibroExistente(){
        
    }
    
    public List<Libro> libro(){
        return this.libroEJB.findAll();
    }
    
    public List<Autor> autor(){
        return this.autorEJB.findAll();
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
    
    public int getLista2() {
        return lista2;
    }

    public void setLista2(int lista2) {
        this.lista2 = lista2;
    }

    public List<Vista> getReporte() {
        return this.vistaEJB.reporte();
    }

    public void setReporte(List<Vista> reporte) {
        this.reporte = reporte;
    }
    
    
    
}
