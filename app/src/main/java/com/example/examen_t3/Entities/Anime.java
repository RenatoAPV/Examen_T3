package com.example.examen_t3.Entities;

public class Anime {
    public int id;
    public String nombre;
    public String desripcion;
    public String link;

    public Anime() {
    }

    public Anime(int id, String nombre, String desripcion) {
        this.id = id;
        this.nombre = nombre;
        this.desripcion = desripcion;
    }

    public Anime(int id, String nombre, String desripcion, String link) {
        this.id = id;
        this.nombre = nombre;
        this.desripcion = desripcion;
        this.link = link;
    }
}

