package com.example.ta5g11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        Intent intent= getIntent();
        String message = intent.getStringExtra("datos");
        TextView textView = (TextView) findViewById(R.id.datos2);
        textView.setText(message);
    }
    public void salir(View v){
        finish();
    }
}