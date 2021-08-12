package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void unJugadorTieneEstadoVivoPorDefault(){
        Jugador jugador = new Jugador("Fernando");

        assertFalse(jugador.gano());
        assertFalse(jugador.perdio());
    }

    @Test
    public void unJugadorQueGanaTieneEstadoGanador(){
        Jugador jugador = new Jugador("Fernando");
        jugador.ganar();

        assertTrue(jugador.gano());
        assertFalse(jugador.perdio());
    }

    @Test
    public void unJugadorQuePierdeTieneEstadoDerrotado(){
        Jugador nicolas = new Jugador("Nicolas");
        Jugador fernando = new Jugador("Fernando");
        nicolas.serDerrotadoPor(fernando);

        assertTrue(nicolas.perdio());
        assertTrue(nicolas.derrotadoPor(fernando));
    }

    @Test
    public void unJugadorNoEsDerrotadoPorOtro(){
        Jugador fernando = new Jugador("Fernando");
        Jugador nicolas = new Jugador("Nicolas");

        assertFalse(fernando.derrotadoPor(nicolas));
    }
}