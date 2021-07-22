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
           juego.jugar(1, "Chipre");
        });
    }


    @Test
    public void rondaDosJugadoresColocarEjercitosNuevos() throws PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe")));
        Pais argentina=juego.buscarPais("Argentina");
        Pais brasil=juego.buscarPais("Brasil");

        argentina.asignarDuenio(juego.getJugador(0));
        brasil.asignarDuenio(juego.getJugador(1));

        juego.jugar(3, "Argentina");
        juego.pasarDeFase();
        juego.jugar(3, "Brasil");
        juego.pasarDeFase();

        //Pasa de fase sin atacar ni reagrupar y vuelve a la fase colocacion

        //ataca y reagrupa jugador 1
        juego.pasarDeFase();
        juego.pasarDeFase();

        //ataca y reagrupa jugador 2
        juego.pasarDeFase();
        juego.pasarDeFase();


        juego.jugar(1, "Brasil");
        juego.pasarDeFase();
        juego.jugar(2, "Brasil");

        assertEquals(argentina.getCantidadEjercitos(), 5);
        assertEquals(brasil.getCantidadEjercitos(), 6);
    }
}