package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JuegoTest {

    @Test
    public void seCreaUnJuegoConUnJugadorCorrecto() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Rosario")));
        assertEquals("Rosario", juego.getJugador(0).getNombre());
    }

    @Test
    public void seCreaUnJuegoConDosJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Fernando", "Nicolas")));
        assertEquals(2, juego.getCantidadJugadores());
    }

    @Test
    public void seCreaUnJuegoCon50Paises() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadPaises());
    }

    @Test
    public void seCreaUnJuegoCon50Cartas() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadCartas());
    }

    @Test
    public void seDistribuyenCorrectamenteLosPaisesEntreJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {

        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Rosario", "Agustina", "Nahuel", "Fernando")));
        boolean funciona = true;
        int i = 0;

        while(funciona && i < juego.getCantidadJugadores()) {

            funciona = juego.getJugador(i).getCantidadPaises() == 10;
            i++;
        }

        assertTrue(funciona);
    }

    @Test
    public void agregarEjercitosAUnPaisInexistenteLanzaUnaExcepcion() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nahuel", "Fernando")));
        assertThrows(PaisNoExisteException.class, () -> {
           juego.agregarEjercitos("Chipre", 1);
        });
    }

    @Test
    public void seAgreganEjercitosAUnPaisCorrectamente() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoExisteException, PaisNoTePerteneceException, ColocacionEnFaseErroneaException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nahuel", "Fernando")));
        juego.agregarEjercitos("Argentina",  1);
        Pais unPais = juego.buscarPais("Argentina");
        assertEquals(2, unPais.getCantidadEjercitos());
    }
}