package com.example.sanchez_luis_r4_u2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private TextView textView;
    private Intent cuadroSeleccionado;
    public static final String EXTRA_MESSAGE = "com.example.android.Sanchez_Luis_R4_U2.extra.MESSAGE";
    public static final String EXTRA_COMIDA = "com.example.android.Sanchez_Luis_R4_U2.extra.COMIDA";

    private String comidaSeleccionada;

    private SearchView searchView;

    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView)findViewById(R.id.buscarRestaurant);
        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);
        cuadroSeleccionado = new Intent(this,Activity_Restaurant.class);


        String[] items = new String[4];
        items[0]= "Restaurant A";
        items[1]= "Restaurant B";
        items[2]= "Restaurant C";
        items[3]= "Restaurant D";

        //for(int i= 0; i<items.length; i++){
        //    items[i]="item"+(i+1);
        //}

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = listView.getItemAtPosition(position).toString();
                textView.setText(texto);
                cuadroSeleccionado.putExtra(EXTRA_MESSAGE, texto);
                cuadroSeleccionado.putExtra(EXTRA_COMIDA, "comida");

                registerForContextMenu(listView);



                //startActivity(cuadroSeleccionado);
                return false;
            }
        });

        //listView.setOnItemLongClickListener(this);
        //registerForContextMenu(listView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurantes");
        setSupportActionBar(toolbar);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String texto = listView.getItemAtPosition(position).toString();
               textView.setText(texto);
               cuadroSeleccionado.putExtra(EXTRA_MESSAGE, texto);
               cuadroSeleccionado.putExtra(EXTRA_COMIDA, "comida");

               startActivity(cuadroSeleccionado);
           }
       });

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               MainActivity.this.adapter.getFilter().filter(query);
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               MainActivity.this.adapter.getFilter().filter(newText);
               return false;
           }
       });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    /*@Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return true;
    }*/

   @Override
    public boolean onContextItemSelected(MenuItem item) {
       String texto = textView.getText().toString();
       cuadroSeleccionado = new Intent(this,Activity_Restaurant.class);
       cuadroSeleccionado.putExtra(EXTRA_MESSAGE, texto);

        switch (item.getItemId()){
            case 2131231217:
                Toast.makeText(this,"comida",Toast.LENGTH_SHORT).show();
                cuadroSeleccionado.putExtra(EXTRA_COMIDA, "comida");
                startActivity(cuadroSeleccionado);
                return true;
            case 2131231216:
                Toast.makeText(this,"bebida",Toast.LENGTH_SHORT).show();
                cuadroSeleccionado.putExtra(EXTRA_COMIDA, "bebida");
                startActivity(cuadroSeleccionado);
                return true;
            case 2131231218:
                Toast.makeText(this,"complemento",Toast.LENGTH_SHORT).show();
                cuadroSeleccionado.putExtra(EXTRA_COMIDA, "complemento");
                startActivity(cuadroSeleccionado);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

}