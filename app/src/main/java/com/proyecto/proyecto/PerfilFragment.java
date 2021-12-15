package com.proyecto.proyecto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    public static ArrayList<Evento> lista = new ArrayList<>();
    RecyclerView recyclerView;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recicler);
    }

    @Override
    public void onResume() {
        super.onResume();
        lista = new ArrayList<>();
        for ( int i = 0; i < MainActivity.getEventos().size(); i++ ){
            if( MainActivity.getEventos().get(i).asistire ){
                Evento e = MainActivity.getEventos().get(i);
                this.lista.add( e );
            }
        }

        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ));
        EventoAdapter adapter = new EventoAdapter(getContext(), lista);
        recyclerView.setAdapter( adapter );
    }
}