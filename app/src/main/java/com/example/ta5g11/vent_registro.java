package com.example.ta5g11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class vent_registro extends AppCompatActivity  {
    EditText etusuario, etnombres, etapellidos, etcorreo, etcontraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vent_registro);

        /*comandos que permiten tener una selección por scroll de la categoría favorita del usuario
        Spinner spinner=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/

        //se registran información de los plain text que ingresa el usuario
        etusuario = (EditText) findViewById(R.id.usuario);
        etnombres = (EditText) findViewById(R.id.nombres);
        etapellidos = (EditText) findViewById(R.id.apellidos);
        etcorreo = (EditText) findViewById(R.id.correo);
        etcontraseña= (EditText) findViewById(R.id.contraseña);
    }
    //boolean registro=false;
    public void registrar(View view) {
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper (this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //se crean variables string a partir de los text
        String usuarioText = etusuario.getText().toString();
        String nombresText = etnombres.getText().toString();
        String apellidosText = etapellidos.getText().toString();
        String correoText = etcorreo.getText().toString();
        String contraseñaText = etcontraseña.getText().toString();

        //primero se verifica que los campos no esten vacíos
        if (!usuarioText.isEmpty() || !nombresText.isEmpty() || !apellidosText.isEmpty() || !correoText.isEmpty() || !contraseñaText.isEmpty()) {
            //Cursor fila = bd.rawQuery("select* from estudiantes where " + "usuario=" + usuarioText,  null);
                // se insertan el usuario con sus datos a la tabla
                bd.execSQL("Insert into usuarios (usuario, nombres, apellidos, correo, contraseña) "
                        + "values ('" + usuarioText + "','" + nombresText + "','" + apellidosText + "'," +
                        "'" + correoText + "','" + contraseñaText + "')");
                bd.close();
                Toast.makeText(this, "Se registró el usuario correctamente", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Inicio_sesion.class );
                startActivity(i);
                finish();
        }else{
            Toast.makeText(this, "Por favor, llene todos los campos.", Toast.LENGTH_SHORT).show();
        }

    }
/*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(registro){
        String favText = parent.getItemAtPosition(position).toString(); //guarda el item seleccionado como string
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper (this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.execSQL("UPDATE usuarios SET favorito='"+favText+"'WHERE usuario="+etusuario.getText().toString());
        Toast.makeText(parent.getContext(),favText, Toast.LENGTH_SHORT).show();}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
*/
}