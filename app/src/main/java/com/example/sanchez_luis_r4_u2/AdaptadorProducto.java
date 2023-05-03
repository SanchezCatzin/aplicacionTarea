package com.example.sanchez_luis_r4_u2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorProducto extends ArrayAdapter<Producto> {
    private ArrayList<Producto> listaProductos;
    private Context contexto;
    AdaptadorProducto(Context context, ArrayList<Producto> productos){
        super(context,0,productos);
        this.listaProductos = productos;
        this.contexto = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto producto = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elemento_lista, parent,false);
        }
        TextView textViewConcepto = (TextView) convertView.findViewById(R.id.concepto);
        TextView textViewCosto = (TextView) convertView.findViewById(R.id.costo);

        textViewConcepto.setText(producto.consepto);
        textViewCosto.setText(producto.costo);

        textViewConcepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),producto.consepto +" "+producto.costo, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(contexto, Alimento_seleccionado.class);

                contexto.startActivity(intent);
            }
        });

        return convertView;
    }



    public Filter getFilter(){
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Producto> filteredList = new ArrayList<>();

                for (Producto producto:listaProductos){
                    if (producto.consepto.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(producto);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll((ArrayList<Producto>)results.values);
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
