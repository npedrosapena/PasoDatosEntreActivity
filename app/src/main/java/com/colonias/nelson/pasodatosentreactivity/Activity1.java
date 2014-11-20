package com.colonias.nelson.pasodatosentreactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Activity1 extends Activity implements Serializable
{
   public Agenda a= new Agenda();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        //controlamos si pulsa el boton añadir para crear un objeto nuevo

        Button btnAdd= (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText nombre=(EditText)findViewById(R.id.txtNombre);
                EditText tlf= (EditText)findViewById(R.id.txtTelefono);

                try
                {

                    Contacto contacto = new Contacto(nombre.getText().toString(), Integer.parseInt(tlf.getText().toString()));


                    if(a.guardarContacto(contacto))
                    {
                        mensajeError("Contacto guardado correctamente");

                        nombre.setText(null);
                        tlf.setText(null);
                    }else
                    {
                        mensajeError("Se produjo un fallo al guardar");
                    }

                }catch (Exception ex)
                {
                    mensajeError(ex.toString());
                }

            }
        });

        //botón para buscar un elemento del arrayList y mostrarlo en el segundo activity

        Button btnList= (Button) findViewById(R.id.btnListar);
        //final EditText txtBuscar= (EditText)findViewById(R.id.txtNomBusc);

        btnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //
                Bundle bundle= new Bundle();
                Intent intento= new Intent(Activity1.this,Activity3.class);//del activity que estamos hasta el que queremos ir

                ArrayList<Contacto> arrayContactos=a.arrayContactos();


                bundle.putSerializable("agenda",a);
                bundle.putSerializable("contactos", arrayContactos);
                intento.putExtras(bundle);

                startActivityForResult(intento,1);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        this.a=(Agenda)data.getExtras().getSerializable("agenda");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*Metodos propios*/

    public void mensajeError(String m)
    {
        Toast t= Toast.makeText(getApplicationContext(),m.toString(),Toast.LENGTH_LONG);
        t.show();

    }


}
