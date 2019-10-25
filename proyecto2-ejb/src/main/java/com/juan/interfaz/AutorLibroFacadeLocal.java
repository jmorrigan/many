/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.interfaz;

import com.juan.entity.AutorLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface AutorLibroFacadeLocal {

    void create(AutorLibro autorLibro);

    void edit(AutorLibro autorLibro);

    void remove(AutorLibro autorLibro);

    AutorLibro find(Object id);

    List<AutorLibro> findAll();

    List<AutorLibro> findRange(int[] range);

    int count();
    
}
