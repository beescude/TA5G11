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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        etusuario = (EditText) findViewById(R.id.usuario);
        etcontraseña = (EditText) findViewById(R.id.contraseña);
    }

    public void registrarse(View view) {
        Intent i = new Intent(this, vent_registro.class);
        startActivity(i);
    }

    public void iniciarsesion(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usuarioText = etusuario.getText().toString();
        String contraseñaText = etcontraseña.getText().toString();
        if (!usuarioText.isEmpty() || !contraseñaText.isEmpty()) {
            Cursor fila = bd.rawQuery("select usuario, contraseña from estudiantes where " + "usuario=" + usuarioText, null);
            if (fila.moveToFirst()) {
                    Intent i = new Intent(this, principal.class);
                    startActivity(i);
                }
            } else {
                Toast.makeText(this, "No ha ingresado datos correctamente", Toast.LENGTH_SHORT).show();
            }
        }
    }
