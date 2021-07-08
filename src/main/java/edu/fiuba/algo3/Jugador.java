package edu.fiuba.algo3;

public class Jugador{

    private String nombre;
    private String color;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getColor(){
        return this.color;
    }
}