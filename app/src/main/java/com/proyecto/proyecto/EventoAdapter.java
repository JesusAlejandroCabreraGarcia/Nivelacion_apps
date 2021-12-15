package com.proyecto.proyecto;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.viewHolder> {
    ArrayList<Evento> lista;
    Context context;

    public EventoAdapter( Context context, ArrayList<Evento> lista ){
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Evento e = lista.get(position);
        holder.fecha.setText( e.fecha );
        holder.titulo.setText(e.nombre);
        holder.lugar.setText(e.ubicacion);
        holder.asistire.setChecked(e.asistire);
        holder.asistire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.asistire = holder.asistire.isChecked() ;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verEvento(e);
            }
        });
        holder.informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verEvento(e);
            }
        });
    }

    private void verEvento(Evento e){
        Intent intent = new Intent(context, InformacionEventoActivity.class );
        intent.putExtra("titulo", e.nombre);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView fecha, titulo, lugar;
        ToggleButton asistire;
        Button informacion;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha);
            titulo = itemView.findViewById(R.id.titulo);
            lugar = itemView.findViewById(R.id.ubicacion);
            asistire = itemView.findViewById(R.id.botonasistire);
            informacion = itemView.findViewById(R.id.botoninformacion);
        }
    }
}
