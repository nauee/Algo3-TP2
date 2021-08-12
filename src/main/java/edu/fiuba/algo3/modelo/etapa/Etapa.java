package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;

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
        while (jugadores.get(jugadorDeTurno).perdio())
            jugadorDeTurno = (jugadorDeTurno + 1) % jugadores.size();
        return (jugadores.get(jugadorDeTurno));
    }

    public abstract void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;

    public abstract Etapa siguienteFase() throws QuedanFichasPorColocarException;

    public abstract void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException, CartaYaActivadaException;

    public abstract void canjearCartas(Carta carta1, Carta carta2, Carta carta3) throws NoSePuedeCanjearEnEtapaBatallaException;

    public static int getIdJugadorDeTurno() {
        return jugadorDeTurno;
    }

    public static Jugador getJugadorDeTurno(){
        return jugadores.get(jugadorDeTurno);
    }

    public ArrayList<Pais> paisesDeJugadorDeTurno(){
        return (jugadores.get(jugadorDeTurno).getPaises());
    }

    public abstract String nombreFase();

    public String getNombreJugadorDeTurno(){
        return jugadores.get(jugadorDeTurno).getNombre();
    }

    public abstract int getCantidadPaisesNecesarios();

    public abstract int getCantidadFichasDisponibles();
}