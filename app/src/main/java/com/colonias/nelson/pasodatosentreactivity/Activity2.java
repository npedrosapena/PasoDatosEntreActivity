package com.colonias.nelson.pasodatosentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Activity2 extends Activity implements Serializable
{

     EditText txtNombreEd;
     EditText txtTelefonoEd;

     Intent i;
     Agenda a;

     ArrayList<Contacto> ContactoArray;
     Integer posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        txtNombreEd = (EditText)findViewById(R.id.txtEditNombre);
        txtTelefonoEd = (EditText)findViewById(R.id.txtTelefonoEdit);

        i= getIntent();
        a = (Agenda)i.getSerializableExtra("agenda");

        ContactoArray = a.arrayContactos();
        posicion=Integer.parseInt(i.getExtras().get("posicion").toString());
        txtNombreEd.setText(ContactoArray.get(posicion).getNombre().toString());
        txtTelefonoEd.setText(ContactoArray.get(posicion).getTelefono().toString());

        Button btnVolver=(Button)findViewById(R.id.btnEditCancel);
        Button btnGuardar=(Button)findViewById(R.id.btnEditAdd);

        btnVolver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_OK,i);
                finish();

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {




                ContactoArray.get(posicion).setNombre(txtNombreEd.getText().toString());
                ContactoArray.get(posicion).setTelefono(Integer.parseInt(txtTelefonoEd.getText().toString()));


                a.actualizarContacto(posicion,ContactoArray.get(posicion));

                //sobreescribo la agenda

                Bundle b= new Bundle();
                b.putSerializable("agenda",a);
                i.putExtras(b);

                setResult(RESULT_OK, i);
                finish();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
}
