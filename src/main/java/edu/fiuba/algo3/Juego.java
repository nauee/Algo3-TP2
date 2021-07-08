package edu.fiuba.algo3;

public class Juego{
    
    static final int MAX_JUGADORES = 6;
    private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
    private int cantidadJugadores = 0;

    public void agregarJugador(Jugador nuevoJugador){
        this.jugadores[cantidadJugadores] = nuevoJugador;
        cantidadJugadores += 1;
    }

    public Jugador getJugador(int posicion){
        return this.jugadores[posicion];
    }

    public int getCantidadJugadores(){
        return this.cantidadJugadores;
    }
}