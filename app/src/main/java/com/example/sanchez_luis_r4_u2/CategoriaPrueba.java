package com.example.sanchez_luis_r4_u2;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriaPrueba#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriaPrueba extends Fragment {
    public int[] buttons = {R.id.mostrarComidas,R.id.mostrarBebidas,R.id.mostrarComplementos};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoriaPrueba() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriaPrueba.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriaPrueba newInstance(String param1, String param2) {
        CategoriaPrueba fragment = new CategoriaPrueba();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentCategory = inflater.inflate(R.layout.fragment_categoria_prueba,container,false);
        TextView textoBoton;

        for (int i =0; i<buttons.length;i++){
            final int textoBotonSelected = i;
            textoBoton = (TextView) fragmentCategory.findViewById(buttons[i]);
            textoBoton.setOnClickListener((v) -> {
                Activity activity = getActivity();
                IntCategoria categoria = (IntCategoria) activity;
                //assert categoria != null;
                categoria.getCategoriaSelected(textoBotonSelected);

            });

        }

        return fragmentCategory;
    }
}