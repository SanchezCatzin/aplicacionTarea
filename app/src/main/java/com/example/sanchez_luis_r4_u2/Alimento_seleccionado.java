package com.example.sanchez_luis_r4_u2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class Alimento_seleccionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento_seleccionado);
        Intent intentAlimentoSeleccionado = getIntent();
        String alimento = intentAlimentoSeleccionado.getStringExtra("alimento");
        String costo = intentAlimentoSeleccionado.getStringExtra("costo");

        TextView textViewCosto = findViewById(R.id.textoCosto);
        TextView textViewAlimento = findViewById(R.id.textAlimento);

        textViewAlimento.setText(alimento);
        textViewCosto.setText(costo);

        Toolbar toolbar = findViewById(R.id.toolbar_Alimento_Seleccionado);
        toolbar.setTitle(alimento);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}