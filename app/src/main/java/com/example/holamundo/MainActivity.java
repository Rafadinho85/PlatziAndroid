package com.example.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.holamundo.model.Alumno;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//controlador vas a controlar esta vista
        //llamando a nuestro modelo
        final Alumno alumno = new Alumno();
        alumno.setNombre("Jery Ramirez");
        alumno.setFechaNacimiento(new Date());
        alumno.setNumero_cuenta(1234567);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nombre Alumno: "+ alumno.getNombre(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }
    //creamos un nuevo metodo que recibira nuestra boton
    //si queremos que funcione nuestro metodo tenemos que pasarle un objeto view
    public void enviarDatos(View view){

        EditText edtNombre = (EditText) findViewById(R.id.nombre);
        String nombre = edtNombre.getText().toString();

        Toast.makeText(getBaseContext(), "Felicidades tu nombre es: "+nombre,Toast.LENGTH_LONG).show();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
