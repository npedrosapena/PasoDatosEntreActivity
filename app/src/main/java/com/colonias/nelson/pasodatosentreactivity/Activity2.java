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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        final EditText txtNombreEd= (EditText)findViewById(R.id.txtEditNombre);
        final EditText txtTelefonoEd= (EditText)findViewById(R.id.txtTelefonoEdit);

        final Intent i= getIntent();

        //final Agenda a = (Agenda)i.getExtras().getSerializable("agenda");
        //final Contacto c= (Contacto)i.getExtras().getSerializable("contacto");

       // txtNombreEd.setText(c.getNombre().toString());
        //txtTelefonoEd.setText(c.getTelefono().toString());


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

                ArrayList<Contacto> ContactoPasado = (ArrayList<Contacto>) i.getExtras().getSerializable("array");
                int posicion=Integer.parseInt(i.getExtras().get("posicion").toString());

                Toast t = Toast.makeText(getApplicationContext(),ContactoPasado.get(posicion).getNombre(),Toast.LENGTH_LONG);
                t.show();


               // c.setNombre(txtNombreEd.getText().toString());



              //  c.setTelefono(Integer.parseInt(String.valueOf(txtTelefonoEd.getText())));

              //  a.actualizarContacto(c.getId(),c);

                //sobreescribo la agenda

                Bundle b= new Bundle();
            //    b.putSerializable("agenda",a);
                i.putExtras(b);

                setResult(RESULT_OK, i);
                finish();

            }
        });

      //  Toast t= Toast.makeText(getApplicationContext(),c.getNombre(),Toast.LENGTH_LONG);
      //  t.show();
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
