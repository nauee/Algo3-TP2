package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void creoUnJugadorYElNombreEsElCorrecto(){
        Jugador jugador = new Jugador("Nahuel", 1);

        assertEquals("Nahuel", jugador.getNombre());
    }

    @Test
    public void creoUnJugadorYElColorEsElCorrecto(){
        Jugador jugador = new Jugador("Nahuel", 1);

        assertEquals(1, jugador.getID());
    }
}
