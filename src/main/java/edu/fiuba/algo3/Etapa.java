package edu.fiuba.algo3;

import java.util.ArrayList;

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
    public static Jugador siguienteJugador(){
        jugadorDeTurno ++;
        if(jugadorDeTurno>jugadores.size())
            return null;
        return(jugadores.get(jugadorDeTurno-1));
    }
    public abstract void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;
    public abstract Etapa siguienteFase();
    public abstract void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException;
}
