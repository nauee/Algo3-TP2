package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Etapa {

    protected static ArrayList<Jugador> jugadores;
    protected static ArrayList<Carta> cartas;
    protected static ArrayList<Continente> continentes;
    protected static int jugadorDeTurno;

    public static void asignarValores(ArrayList<Continente> unosContinentes, ArrayList<Jugador> unosJugadores, ArrayList<Carta> unasCartas){
        jugadores = unosJugadores;
        cartas = unasCartas;
        continentes = unosContinentes;
        jugadorDeTurno = 1;
    }
    public static void siguienteJugador(){
        jugadorDeTurno ++;
    }
    public abstract void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;
    public abstract Etapa siguienteFase();
    public abstract void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException;
}
