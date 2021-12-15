package com.proyecto.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class InformacionEventoActivity extends AppCompatActivity {
    Evento evento;
    TextView nombre1, nombre2, fecha, lugar, descripcion, categoria;
    ToggleButton asistire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_evento);

        nombre1 = findViewById(R.id.nombre);
        nombre2 = findViewById(R.id.nombre2);
        fecha = findViewById(R.id.fecha);
        lugar = findViewById(R.id.lugar);
        descripcion = findViewById(R.id.descripcion);
        asistire = findViewById(R.id.asistire);
        categoria = findViewById(R.id.categoria);

        String titulo = getIntent().getStringExtra("titulo");
        setTitle(titulo);

        for ( int i = 0; i < MainActivity.getEventos().size(); i++ ){
            if( MainActivity.getEventos().get(i).nombre.equals(titulo) ){
                this.evento = MainActivity.getEventos().get(i);
            }
        }

        nombre1.setText(this.evento.nombre);
        nombre2.setText(this.evento.nombre);
        fecha.setText(this.evento.fecha);
        lugar.setText(this.evento.ubicacion);
        descripcion.setText(this.evento.descripcion);
        asistire.setChecked(this.evento.asistire);
        categoria.setText(this.evento.categoria.titulo);

        asistire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evento.asistire = asistire.isChecked() ;
            }
        });
    }
}