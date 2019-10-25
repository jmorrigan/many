/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.beans;

import com.juan.interfaz.AbstractFacade;
import com.juan.interfaz.AutorFacadeLocal;
import com.juan.entity.Autor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> implements AutorFacadeLocal {
    @PersistenceContext(unitName = "manyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorFacade() {
        super(Autor.class);
    }
    
}
