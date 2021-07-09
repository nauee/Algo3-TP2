package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest{

    @Test
    public void seAgregaSatisfactoriamenteUnJugadorAlJuego() throws SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego();
        Jugador jugador = new Jugador("Rosario", 1);

        juego.agregarJugador(jugador);

        assertEquals(jugador, juego.getJugador(0));
    }

    @Test
    public void seAgreganCorrectamenteDosJugadores() throws SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego();

        juego.agregarJugador(new Jugador("Nicolas", 1));
        juego.agregarJugador(new Jugador("Fernando", 2));

        assertEquals(2, juego.getCantidadJugadores());
    }

    @Test
    public void seAgreganCorrectamenteDosJugadoresYSonLosEsperados() throws SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego();

        Jugador jugador1 = new Jugador("Nicolas", 1);
        Jugador jugador2 = new Jugador("Fernando", 2);

        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);

        assertEquals(jugador1, juego.getJugador(0));
        assertEquals(jugador2, juego.getJugador(1));
    }
}