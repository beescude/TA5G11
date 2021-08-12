package com.example.ta5g11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio_sesion extends AppCompatActivity {
    EditText etusuario, etcontraseña;
    public static final String EXTRA_MESSAGE = "com.example.ta5g11.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        etusuario = (EditText) findViewById(R.id.usuario1);
        etcontraseña = (EditText) findViewById(R.id.contraseña1);
    }

    public void registrarse(View view) {
        Intent i = new Intent(this, vent_registro.class);
        startActivity(i);
    }

    public  void iniciarsesion(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usuarioText = etusuario.getText().toString();
        String contraseñaText = etcontraseña.getText().toString();
        if (!usuarioText.isEmpty() || !contraseñaText.isEmpty()) {

           Cursor fila = bd.rawQuery("select usuario,nombres,apellidos,correo,contraseña from usuarios where usuario='" + usuarioText+"'",  null);

            if (fila.moveToFirst()) {
                String nombre = fila.getString(1);
                String usuario = fila.getString(0);
                String apellidos = fila.getString(2);
                String correo = fila.getString(3);
                String texto = "\nUsuario: " + usuario + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nCorreo: " + correo;
                Bundle parmetros = new Bundle();
                parmetros.putString("datos", texto);
                if (contraseñaText.equals(fila.getString(4))) {
                    Intent i = new Intent(this, principal.class);
                    i.putExtra("datos", texto);
                    startActivity(i);
                }
            } else {
                Toast.makeText(this, "No ha ingresado datos correctamente", Toast.LENGTH_SHORT).show();
            }
        }
        }
    }
