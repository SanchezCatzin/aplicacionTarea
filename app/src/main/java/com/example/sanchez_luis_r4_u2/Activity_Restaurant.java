package com.example.sanchez_luis_r4_u2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_Restaurant extends AppCompatActivity implements IntCategoria{
    private ListView listaItemsRest;
    private SearchView searchView;
    ArrayAdapter <String> adapter;
    private AdaptadorProducto adaptadorProducto;
    private ArrayList<Producto> productoArrayList;

    public static final int OPCION_COMIDA = R.id.opcion_comida;
    public static final int OPCION_BEBIDA = R.id.opcion_comida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String comida = intent.getStringExtra(MainActivity.EXTRA_COMIDA);

        searchView = findViewById(R.id.buscarItem);

        TextView textView = findViewById(R.id.restaurant);
        textView.setText(message);

        listaItemsRest = (ListView)findViewById(R.id.listView_restaurant);
        productoArrayList = new ArrayList<>();
        adaptadorProducto = new AdaptadorProducto(this,productoArrayList);

        Toast.makeText(this,comida,Toast.LENGTH_SHORT).show();

        if (comida.equals("comida")){
            adaptadorProducto.add(new Producto("Comida A", "$1"));
            adaptadorProducto.add(new Producto("Comida B", "$2"));
            adaptadorProducto.add(new Producto("Comida C", "$3"));
            adaptadorProducto.add(new Producto("Comida D", "$4"));
        } else if (comida.equals("bebida")) {
            adaptadorProducto.add(new Producto("Bebida A", "$11"));
            adaptadorProducto.add(new Producto("Bebida B", "$21"));
            adaptadorProducto.add(new Producto("Bebida C", "$31"));
            adaptadorProducto.add(new Producto("Bebida D", "$41"));
        } else if (comida.equals("complemento")) {
            adaptadorProducto.add(new Producto("Complemento A", "$12"));
            adaptadorProducto.add(new Producto("Complemento B", "$22"));
            adaptadorProducto.add(new Producto("Complemento C", "$32"));
            adaptadorProducto.add(new Producto("Complemento D", "$42"));
        }


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
    @Override
    public void getCategoriaSelected(int categorySelected) {
        Toast.makeText(this,"Seleccionando"+categorySelected,Toast.LENGTH_SHORT).show();
        adaptadorProducto.clear();
        if (categorySelected == 0){
            adaptadorProducto.add(new Producto("Comida A", "$1"));
            adaptadorProducto.add(new Producto("Comida B", "$2"));
            adaptadorProducto.add(new Producto("Comida C", "$3"));
            adaptadorProducto.add(new Producto("Comida D", "$4"));
        } else if (categorySelected == 1) {
            adaptadorProducto.add(new Producto("Bebida A", "$11"));
            adaptadorProducto.add(new Producto("Bebida B", "$21"));
            adaptadorProducto.add(new Producto("Bebida C", "$31"));
            adaptadorProducto.add(new Producto("Bebida D", "$41"));
        } else if (categorySelected == 2) {
            adaptadorProducto.add(new Producto("Complemento A", "$12"));
            adaptadorProducto.add(new Producto("Complemento B", "$22"));
            adaptadorProducto.add(new Producto("Complemento C", "$32"));
            adaptadorProducto.add(new Producto("Complemento D", "$42"));
        }

        listaItemsRest.setAdapter(adaptadorProducto);
    }

}