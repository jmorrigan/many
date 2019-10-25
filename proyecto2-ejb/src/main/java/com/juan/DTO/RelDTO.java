/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author juan
 */
public class RelDTO implements Serializable{
    private String ciudad;
    private Date fecha;

    public RelDTO() {
    }

    public RelDTO(String ciudad, Date fecha) {
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
