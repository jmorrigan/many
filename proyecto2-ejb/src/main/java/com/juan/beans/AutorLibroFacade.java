/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.beans;

import com.juan.interfaz.AbstractFacade;
import com.juan.interfaz.AutorLibroFacadeLocal;
import com.juan.entity.AutorLibro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan
 */
@Stateless
public class AutorLibroFacade extends AbstractFacade<AutorLibro> implements AutorLibroFacadeLocal {
    @PersistenceContext(unitName = "manyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorLibroFacade() {
        super(AutorLibro.class);
    }
    
}
