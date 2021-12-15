package com.proyecto.proyecto;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class BuscarFragment extends Fragment {
    ArrayList<Evento> eventos;
    RecyclerView recyclerView;
    public BuscarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recicler);
        String[] nombres = new String[MainActivity.getEventos().size()];
        for ( int i = 0; i < nombres.length; i++){
            nombres[i] = MainActivity.getEventos().get(i).nombre;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line,
                nombres);
        AutoCompleteTextView actv = view.findViewById(R.id.buscar);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.RED);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayList<Evento> lista = new ArrayList<>();
                for (Evento e :
                        MainActivity.getEventos()) {
                    if ( e.nombre.equals(actv.getText().toString()) ){
                        lista.add(e);
                    }
                }
                recyclerView.setLayoutManager( new GridLayoutManager( getContext(), 1 ));
                EventoAdapter adapter = new EventoAdapter( getContext(), lista );
                recyclerView.setAdapter( adapter );
            }
        });
    }
}