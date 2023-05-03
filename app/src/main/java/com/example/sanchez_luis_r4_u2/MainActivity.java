package com.example.sanchez_luis_r4_u2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    private Intent cuadroSeleccionado;
    public static final String EXTRA_MESSAGE = "com.example.android.Sanchez_Luis_R4_U2.extra.MESSAGE";

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView)findViewById(R.id.buscarRestaurant);
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);
        cuadroSeleccionado = new Intent(this,Activity_Restaurant.class);


        String[] items = new String[50];
        for(int i= 0; i<items.length; i++){
            items[i]="item"+(i+1);

        }

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurantes");
        setSupportActionBar(toolbar);


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String texto = listView.getItemAtPosition(position).toString();
               textView.setText(texto);
               cuadroSeleccionado.putExtra(EXTRA_MESSAGE, texto);
               startActivity(cuadroSeleccionado);
           }
       });
    }
}