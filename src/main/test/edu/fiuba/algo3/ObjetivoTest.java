package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.excepciones.SeAlcanzoLaCantidadMaximaException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjetivoTest {

    @Test
    public void seTieneTodosLosPaisesYElObjetivoComunSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe")));
        Jugador jugador = juego.getJugador(0);
        Pais argentina = juego.buscarPais("Argentina");
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(Arrays.asList(argentina)));
        assertTrue(objetivo.cumplido(jugador));
    }

    @Test
    public void noSeTieneTodosLosPaisesYElObjetivoComunNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe", "Carlos")));
        Jugador jugador1 = juego.getJugador(0);
        Jugador jugador2 = juego.getJugador(1);
        Pais argentina = juego.buscarPais("Argentina");
        if (jugador1.tienePais(argentina)){
            jugador1.perderPais(argentina);
            jugador2.agregarPais(argentina);
        }
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(Arrays.asList(argentina)));
        assertFalse(objetivo.cumplido(jugador1));
    }

    @Test
    public void seTieneTodosLosPaisesAConquistarYElObjetivoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe", "Carlos")));
        Jugador jugador1 = juego.getJugador(0);
        Jugador jugador2 = juego.getJugador(1);
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Pais chile = juego.buscarPais("Chile");
        if (jugador2.tienePais(argentina)){
            jugador2.perderPais(argentina);
            jugador1.agregarPais(argentina);
        }
        if (jugador2.tienePais(brasil)){
            jugador2.perderPais(brasil);
            jugador1.agregarPais(brasil);
        }
        if (jugador2.tienePais(chile)){
            jugador2.perderPais(chile);
            jugador1.agregarPais(chile);
        }
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(Arrays.asList(argentina, brasil, chile)));
        assertTrue(objetivo.cumplido(jugador1));
    }

    @Test
    public void noSeTieneTodosLosPaisesAConquistarYElObjetivoNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe", "Carlos")));
        Jugador jugador1 = juego.getJugador(0);
        Jugador jugador2 = juego.getJugador(1);
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Pais chile = juego.buscarPais("Chile");
        if (jugador2.tienePais(argentina)){
            jugador2.perderPais(argentina);
            jugador1.agregarPais(argentina);
        }
        if (jugador2.tienePais(brasil)){
            jugador2.perderPais(brasil);
            jugador1.agregarPais(brasil);
        }
        if (jugador1.tienePais(chile)){
            jugador1.perderPais(chile);
            jugador2.agregarPais(chile);
        }
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(Arrays.asList(argentina, brasil, chile)));
        assertFalse(objetivo.cumplido(jugador1));
    }

    @Test
    public void seVencioAlJugadorADestruirYElObjetivoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe", "Carlos")));
        Jugador jugador1 = juego.getJugador(0);
        Jugador jugador2 = juego.getJugador(1);
        Objetivo objetivo = new ObjetivoDestruccion(jugador2);
        jugador2.serDerrotadoPor(jugador1);
        assertTrue(objetivo.cumplido(jugador1));
    }

    @Test
    public void noSeVencioAlJugadorADestruirYElObjetivoNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Pepe", "Carlos")));
        Jugador jugador1 = juego.getJugador(0);
        Jugador jugador2 = juego.getJugador(1);
        Objetivo objetivo = new ObjetivoDestruccion(jugador2);
        assertFalse(objetivo.cumplido(jugador1));
    }

}
