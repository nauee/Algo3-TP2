package edu.fiuba.algo3;

public class Jugador{

    private String nombre;
    private int id;

    public Jugador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getID(){
        return this.id;
    }
}