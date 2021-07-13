package edu.fiuba.algo3;

import java.util.ArrayList;

public class Pais{

    private final String nombre;
    private Jugador duenio;
    private int cantidadEjercitos;
    private final ArrayList<String> limitrofes;
    private final String continente;

    public Pais(String nombre, String continente, ArrayList<String> limitrofes){
        this.nombre = nombre;
        this.continente= continente;
        this.limitrofes= limitrofes;
        cantidadEjercitos = 0;
    }

    public void asignarDuenio(Jugador nuevoDuenio) {
        duenio = nuevoDuenio;
    }

    public void serConquistadoPor(Jugador conquistador) {
        duenio.perderPais(this);
        conquistador.agregarPais(this);
    }

    public void agregarEjercitos(int cantidadEjercitos) {
        this.cantidadEjercitos += cantidadEjercitos;
    }

    public String getNombre(){
        return (nombre);
    }

    public String getContinente(){
        return continente;
    }

    public Jugador getDuenio(){
        return duenio;
    }

    public ArrayList<String> getLimitrofes(){
        return limitrofes;
    }

    public boolean lePerteneceA(Jugador unJugador) {
        return (duenio.equals(unJugador));
    }

    public int getCantidadEjercitos(){
        return cantidadEjercitos;
    }

    public void serAtacado(){
        cantidadEjercitos--;
    }

    public void moverEjercitos(int cantidadEjercitos, Pais destino){
        destino.agregarEjercitos(cantidadEjercitos);
        this.cantidadEjercitos -= cantidadEjercitos;
    }
}