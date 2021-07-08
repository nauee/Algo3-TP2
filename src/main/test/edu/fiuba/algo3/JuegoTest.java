package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest{

    @Test
    public void seAgregaSatisfactoriamenteUnJugadorAlJuego(){
        Juego juego = new Juego();
        Jugador jugador = new Jugador("Rosario", "Negro");

        juego.agregarJugador(jugador);

        assertEquals(jugador, juego.getJugador(0));
    }

    @Test
    public void seAgreganCorrectamenteDosJugadores(){
        Juego juego = new Juego();

        juego.agregarJugador(new Jugador("Nicolas", "Azul"));
        juego.agregarJugador(new Jugador("Fernando", "Verde"));

        assertEquals(2, juego.getCantidadJugadores());
    }

    @Test
    public void seAgreganCorrectamenteDosJugadoresYSonLosEsperados(){
        Juego juego = new Juego();

        Jugador jugador1 = new Jugador("Nicolas", "Azul");
        Jugador jugador2 = new Jugador("Fernando", "Verde");

        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);

        assertEquals(jugador1, juego.getJugador(0));
        assertEquals(jugador2, juego.getJugador(1));
    }
}