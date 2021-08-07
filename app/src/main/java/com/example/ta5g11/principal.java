package com.example.ta5g11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void informacion(View view){
        Intent i = new Intent(this, Inicio_sesion.class );
        startActivity(i);
        finish();

    }
}