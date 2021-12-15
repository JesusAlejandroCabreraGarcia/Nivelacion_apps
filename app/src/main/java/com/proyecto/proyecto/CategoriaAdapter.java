package com.proyecto.proyecto;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.viewHolder> {
    ArrayList<Categoria> lista;
    Context context;

    public CategoriaAdapter(Context context){
        this.lista = MainActivity.getCategorias();
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria c = lista.get(position);
        holder.titulo.setText( c.titulo );
        holder.imagen.setBackgroundResource(c.imagen);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, EventosActivity.class );
            intent.putExtra("titulo", c.titulo);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imagen;
        CardView card;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.ttitulo);
            imagen = itemView.findViewById(R.id.imagen);
            card = itemView.findViewById(R.id.card);
        }
    }
}
