package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;

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
        jugadorDeTurno = 0;
    }

    public static Jugador siguienteJugador(){
        jugadorDeTurno++;
        if(jugadorDeTurno >= jugadores.size()) return jugadores.get(0);

        return (jugadores.get(jugadorDeTurno));
    }

    public abstract void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;

    public abstract Etapa siguienteFase();

    public abstract void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException, CartaYaActivadaException;

    public abstract void canjearCartas(Carta carta1, Carta carta2, Carta carta3) throws NoSePuedeCanjearEnEtapaBatallaException;

    public int getJugadorDeTurno() {
        return jugadorDeTurno;
    }
}