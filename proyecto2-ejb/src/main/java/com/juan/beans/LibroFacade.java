/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.beans;

import com.juan.interfaz.AbstractFacade;
import com.juan.interfaz.LibroFacadeLocal;
import com.juan.entity.Libro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> implements LibroFacadeLocal {
    @PersistenceContext(unitName = "manyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroFacade() {
        super(Libro.class);
    }
    
}
