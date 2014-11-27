package com.colonias.nelson.pasodatosentreactivity;

import java.io.Serializable;

/**
 * Created by nelson on 12/11/14.
 */
public class Contacto implements Serializable {
    private String nombre;
    private static Integer id=0;
    private Integer telefono;

    public Contacto(String n, Integer t, Integer id)
    {
        this.setNombre(n);
        this.setTelefono(t);
        this.setId(id);
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Integer getTelefono()
    {
        return telefono;
    }

    public void setTelefono(Integer telefono)
    {
        this.telefono = telefono;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString()
    {
        return getNombre()+" "+getTelefono();
    }
}
