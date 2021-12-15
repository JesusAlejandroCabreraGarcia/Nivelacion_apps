package com.proyecto.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class EventosActivity extends AppCompatActivity {
    Categoria categoria;
    public static ArrayList<Evento> lista = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        lista = new ArrayList<>();

        String titulo = getIntent().getStringExtra("titulo");

        setTitle(titulo);

        for ( int i = 0; i < MainActivity.getCategorias().size(); i++ ){
            if ( MainActivity.getCategorias().get(i).titulo.equals( titulo ) ){
                this.categoria = MainActivity.getCategorias().get(i);
            }
        }

        for ( int i = 0; i < MainActivity.getEventos().size(); i++ ){
            if( MainActivity.getEventos().get(i).categoria.titulo.equals(titulo) ){
                Evento e = MainActivity.getEventos().get(i);
                Log.i("aa", e.toString());
                Log.i( "EVENTO", MainActivity.getEventos().get(i).nombre );
                this.lista.add( e );
            }
        }

        recyclerView = findViewById(R.id.recicler);

        recyclerView.setLayoutManager( new LinearLayoutManager( this ));
        EventoAdapter adapter = new EventoAdapter(this, getEventos());
        recyclerView.setAdapter( adapter );
    }

    public static ArrayList<Evento> getEventos(){
        return lista;
    }
}