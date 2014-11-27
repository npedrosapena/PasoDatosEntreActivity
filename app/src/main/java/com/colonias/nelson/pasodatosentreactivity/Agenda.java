package com.colonias.nelson.pasodatosentreactivity;

import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nelson on 7/11/14.
 */
public class Agenda implements Serializable
{

    static ArrayList<Contacto> lista= new ArrayList<Contacto>();

    public Agenda(){}

    public Boolean guardarContacto(Contacto contacto)
    {
        if(lista.add(contacto)==true)
        {
            return true;
        }else
        {
            return false;
        }

    }

    public Contacto buscarContacto(String contacto)
    {
        int indiceElemento=0;

        for (Contacto con :lista)
        {
            if(con.getNombre().equals(contacto)==true)
            {
                return lista.get(indiceElemento);
            }
                indiceElemento += 1;
        }
        return null;

    }

    public void actualizarContacto(Integer posicion,Contacto c)
    {
        //int indiceElemento=0;

        //for (Contacto con :lista)
        //{
           // if(con.getId().equals(id)==true)
            //{
             lista.set(posicion,c);
            //}
            //indiceElemento += 1;
       // }

    }

    public ArrayList arrayContactos()
    {
        return this.lista;
    }
    public String longitud()
    {
        return String.valueOf(lista.size());
    }

}
