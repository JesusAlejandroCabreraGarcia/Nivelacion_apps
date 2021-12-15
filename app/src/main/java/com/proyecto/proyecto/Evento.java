package com.proyecto.proyecto;

public class Evento {
    String nombre;
    String fecha;
    String ubicacion;
    String descripcion;
    Boolean asistire = false;
    String link;
    Categoria categoria;

    public Evento(String nombre, String fecha, String ubicacion, String descripcion, Categoria categoria) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
}
