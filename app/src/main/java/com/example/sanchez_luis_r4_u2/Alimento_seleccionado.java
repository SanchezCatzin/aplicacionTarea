package com.example.sanchez_luis_r4_u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Alimento_seleccionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento_seleccionado);
        Intent intentAlimentoSeleccionado = getIntent();
        String alimento = intentAlimentoSeleccionado.getStringExtra("alimento");
        String costo = intentAlimentoSeleccionado.getStringExtra("costo");

        TextView textViewCosto = findViewById(R.id.textoCosto);
        String texto = alimento+" "+costo;
        textViewCosto.setText(costo);
    }
}