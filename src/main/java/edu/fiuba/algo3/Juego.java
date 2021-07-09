package edu.fiuba.algo3;

import java.util.ArrayList;

public class Juego{

    static private final JUGADORES_MAX = 6;
    private ArrayList<Pais> paises = new ArrayList<Pais>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public void agregarJugador(Jugador nuevoJugador){

        if(jugadores.length >= JUGADORES_MAX)
            throw new SeAlcanzoLaCantidadMaximaException;

        this.jugadores.add(nuevoJugador);
    }

    public Jugador getJugador(int posicion){
        return this.jugadores[posicion];
    }

    public int getCantidadJugadores(){
        return this.cantidadJugadores;
    }
}