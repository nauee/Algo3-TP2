package edu.fiuba.algo3;

import java.util.ArrayList;

public class Pais{

    private final String nombre;
    private Jugador duenio;
    private int cantidadEjercitos;
    private final ArrayList<String> limitrofes;

    public Pais(String nombre, ArrayList<String> limitrofes) {

        this.nombre = nombre;
        this.limitrofes= limitrofes;
        cantidadEjercitos = 0;
    }

    public void asignarDuenio(Jugador nuevoDuenio) {
        duenio = nuevoDuenio;
    }

    public void agregarEjercitos(int cantidadEjercitos, Jugador jugador) throws PaisNoTePerteneceException {
        if (!duenio.equals(jugador)) {
            throw new PaisNoTePerteneceException();
        }
        this.cantidadEjercitos += cantidadEjercitos;
    }

    public String getNombre(){
        return nombre;
    }

    public Jugador getDuenio(){
        return duenio;
    }

    public ArrayList<String> getLimitrofes(){
        return limitrofes;
    }

    public boolean lePerteneceA(Jugador unJugador) {
        return duenio.equals(unJugador);
    }

    public int getCantidadEjercitos(){
        return cantidadEjercitos;
    }

    public void serAtacado(){
        cantidadEjercitos--;
    }

    public void moverEjercitos(int cantidadEjercitos, Pais destino) throws  PaisNoTePerteneceException{

        destino.agregarEjercitos(cantidadEjercitos, duenio);
        this.cantidadEjercitos -= cantidadEjercitos;
    }

    public Boolean esLimitrofeCon(String unPais){
        return limitrofes.contains(unPais);
    }

    public void serConquistadoPor(Jugador conquistador){

        duenio.perderPais(this);
        conquistador.agregarPais(this);
    }
}