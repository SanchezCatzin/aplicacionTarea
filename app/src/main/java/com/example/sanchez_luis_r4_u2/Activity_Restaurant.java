package com.example.sanchez_luis_r4_u2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_Restaurant extends AppCompatActivity {
    private ListView listaItemsRest;
    private SearchView searchView;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        searchView = findViewById(R.id.buscarItem);

        TextView textView = findViewById(R.id.restaurant);
        textView.setText(message);

        listaItemsRest = (ListView)findViewById(R.id.listView_restaurant);
        ArrayList<Producto> productoArrayList = new ArrayList<>();
        AdaptadorProducto adaptadorProducto = new AdaptadorProducto(this,productoArrayList);

        adaptadorProducto.add(new Producto("Comida A", "$1"));
        adaptadorProducto.add(new Producto("Comida B", "$2"));
        adaptadorProducto.add(new Producto("Comida C", "$3"));
        adaptadorProducto.add(new Producto("Comida D", "$4"));
        /*Comida[] comidas = new Comida[3];
        String[] mostrarCom = new String[comidas.length];

        String muchoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas pretium auctor quam eget maximus. Fusce sollicitudin erat et tristique consequat. Duis lobortis vitae nibh vel auctor. Pellentesque sagittis purus vel tortor aliquet malesuada. Aliquam congue felis in augue pulvinar, eget posuere elit blandit.";

        switch (message){
            case "item1":
                comidas[0] = new Comida("R1_Comida A", "$2.9", muchoTexto);
                comidas[1] = new Comida("R1_Comida B", "$3.9", muchoTexto);
                comidas[2] = new Comida("R1_Comida C", "$2.4", muchoTexto);

                break;
            case "item2":
                comidas[0] = new Comida("R2_Comida A", "$1.9", muchoTexto);
                comidas[1] = new Comida("R2_Comida B", "$6.9", muchoTexto);
                comidas[2] = new Comida("R2_Comida C", "$4.4", muchoTexto);
                break;
            case "item3":
                comidas[0] = new Comida("R3_Comida A", "$2.9", muchoTexto);
                comidas[1] = new Comida("R3_Comida B", "$3.7", muchoTexto);
                comidas[2] = new Comida("R3_Comida C", "$1.2", muchoTexto);
                break;
            default:
                Log.e(MainActivity.class.getSimpleName(),"Erorr");
                break;
        }*/

        /*for (int i = 0 ; i < comidas.length; i++){
            mostrarCom[i] = comidas[i].getComida();
        }*/

        /*adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mostrarCom);
        listaItemsRest.setAdapter(adapter);*/

        listaItemsRest.setAdapter(adaptadorProducto);


        Toolbar toolbar = findViewById(R.id.toolbar_restaurant);
        toolbar.setTitle(message);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Activity_Restaurant.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptadorProducto.getFilter().filter(newText);
                return true;
            }
        });

    }
}