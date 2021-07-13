package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class JuegoTest {

    @Test
    public void seAgregaSatisfactoriamenteUnJugadorAlJuego() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException {
        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Rosario")));
        assertEquals("Rosario", juego.getJugador(0).getNombre());
    }

    @Test
    public void seAgreganCorrectamenteDosJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException {
        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Fernando", "Nicolas")));
        assertEquals(2, juego.getCantidadJugadores());
    }

    @Test
    public void seAgreganCorrectamenteDosJugadoresYSonLosEsperados() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException {
        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Fernando", "Nicolas")));
        assertEquals("Nicolas", juego.getJugador(1).getNombre());
    }

    @Test
    public void seCreaUnJuegoCon50Paises() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException{
        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadPaises());
    }

    @Test
    public void seCreaUnJuegoCon50Cartas() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException{
        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadCartas());
    }
}