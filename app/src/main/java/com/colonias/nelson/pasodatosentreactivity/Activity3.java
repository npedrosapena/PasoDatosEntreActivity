package com.colonias.nelson.pasodatosentreactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity3 extends ListActivity
{

    Intent i;
    Agenda a;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        i= getIntent();
        a = (Agenda)i.getExtras().getSerializable("agenda");

        // ArrayList<Contacto> ContactoArray = (ArrayList<Contacto>) i.getSerializableExtra("contactos");


        setListAdapter(new ArrayAdapter<Contacto>(this,android.R.layout.simple_list_item_1,a.arrayContactos()));

    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        Intent intento2= new Intent(Activity3.this,Activity2.class);


        Intent intentoContactosArray= getIntent();
        Agenda a = (Agenda)intentoContactosArray.getExtras().getSerializable("agenda");
        ArrayList<Contacto> ContactoArray = (ArrayList<Contacto>) intentoContactosArray.getExtras().getSerializable("contactos");



        intento2.putExtra("agenda",a);
        //intento2.putExtra("array",intentoContactosArray.getSerializableExtra("contactos"));
        intento2.putExtra("posicion",position);


        startActivityForResult(intento2, 2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        this.a=(Agenda)data.getSerializableExtra("agenda");

        ArrayList<Contacto> ContactoArray = (ArrayList<Contacto>) i.getSerializableExtra("contactos");


        setListAdapter(new ArrayAdapter<Contacto>(this,android.R.layout.simple_list_item_1,a.arrayContactos()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
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
