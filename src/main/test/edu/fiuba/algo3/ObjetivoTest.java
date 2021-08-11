package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.excepciones.SeAlcanzoLaCantidadMaximaException;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruccion;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjetivoTest {

    @Test
    public void seTieneTodosLosPaisesYElObjetivoComunSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, NoSePudoLeerExcepcion {
        ArrayList<Jugador> jugadores = new ArrayList<>(List.of(new Jugador("Pepe")));
        Juego juego = new Juego(jugadores);
        Continente americaDelSur = new Continente("America del Sur", 0);
        Pais argentina = juego.buscarPais("Argentina");
        americaDelSur.agregarPais(argentina);
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of(americaDelSur)), new ArrayList<>(List.of(1)));

        assertTrue(objetivo.cumplido(jugadores.get(0)));
    }

    @Test
    public void noSeTieneTodosLosPaisesYElObjetivoComunNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, NoSePudoLeerExcepcion {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));
        Juego juego = new Juego(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Continente americaDelSur = new Continente("America del Sur", 0);
        Pais argentina = juego.buscarPais("Argentina");
        americaDelSur.agregarPais(argentina);

        if (jugador1.tienePais(argentina)){
            jugador1.perderPais(argentina);
            jugador2.agregarPais(argentina);
        }

        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of(americaDelSur)), new ArrayList<>(List.of(1)));

        assertFalse(objetivo.cumplido(jugador1));
    }

    @Test
    public void seTieneTodosLosPaisesAConquistarYElObjetivoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, NoSePudoLeerExcepcion {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));
        Juego juego = new Juego(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Continente americaDelSur = new Continente("America del Sur", 0);
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Pais chile = juego.buscarPais("Chile");
        americaDelSur.agregarPais(argentina);
        americaDelSur.agregarPais(chile);
        americaDelSur.agregarPais(brasil);

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

        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of(americaDelSur)), new ArrayList<>(List.of(3)));

        assertTrue(objetivo.cumplido(jugador1));
    }

    @Test
    public void noSeTieneTodosLosPaisesAConquistarYElObjetivoNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, NoSePudoLeerExcepcion {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));
        Juego juego = new Juego(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Continente americaDelSur = new Continente("America del Sur", 0);
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Pais chile = juego.buscarPais("Chile");
        americaDelSur.agregarPais(argentina);
        americaDelSur.agregarPais(brasil);
        americaDelSur.agregarPais(chile);

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

        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of(americaDelSur)), new ArrayList<>(List.of(3)));

        assertFalse(objetivo.cumplido(jugador1));
    }

    @Test
    public void seVencioAlJugadorADestruirYElObjetivoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, NoSePudoLeerExcepcion, PaisNoExisteException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));
        Juego juego = new Juego(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Objetivo objetivo = new ObjetivoDestruccion(jugador2);
        jugador2.serDerrotadoPor(jugador1);

        assertTrue(objetivo.cumplido(jugador1));
    }

    @Test
    public void noSeVencioAlJugadorADestruirYElObjetivoNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, NoSePudoLeerExcepcion, PaisNoExisteException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));
        Juego juego = new Juego(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Objetivo objetivo = new ObjetivoDestruccion(jugador2);

        assertFalse(objetivo.cumplido(jugador1));
    }

}
