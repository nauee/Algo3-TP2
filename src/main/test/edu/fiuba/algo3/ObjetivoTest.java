package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.logica.Juego;
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
    public void seTieneTodosLosPaisesYElObjetivoComunSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, PaisNoExisteException, NoSePudoLeerExcepcion {
        ArrayList<Jugador> jugadores = new ArrayList<>(List.of(new Jugador("Pepe"),new Jugador("Fer")));
        Juego juego = new Juego(jugadores);
        Continente americaDelSur = new Continente("America del Sur", 0);
        Pais argentina = juego.buscarPais("Argentina");
        americaDelSur.agregarPais(argentina);
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of(americaDelSur)), new ArrayList<>(List.of(1)));

        Jugador jugador = jugadores.get(0);
        jugador.agregarObjetivo(objetivo);

        assertTrue(jugador.objetivoCumplido());
    }

    @Test
    public void noSeTieneTodosLosPaisesYElObjetivoComunNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, PaisNoExisteException, NoSePudoLeerExcepcion {
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
        jugador1.agregarObjetivo(objetivo);

        assertFalse(jugador1.objetivoCumplido());
    }

    @Test
    public void seTieneTodosLosPaisesAConquistarYElObjetivoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, PaisNoExisteException, NoSePudoLeerExcepcion {
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
        jugador1.agregarObjetivo(objetivo);

        assertTrue(jugador1.objetivoCumplido());
    }

    @Test
    public void noSeTieneTodosLosPaisesAConquistarYElObjetivoNoSeCompleta() throws PaisNoTePerteneceException, ParseException, IOException, PaisNoExisteException, NoSePudoLeerExcepcion {
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
        jugador1.agregarObjetivo(objetivo);

        assertFalse(jugador1.objetivoCumplido());
    }

    @Test
    public void seVencioAlJugadorADestruirYElObjetivoSeCompleta() {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Objetivo objetivo = new ObjetivoDestruccion(jugador2);
        jugador1.agregarObjetivo(objetivo);
        jugador2.serDerrotadoPor(jugador1);

        assertTrue(jugador1.objetivoCumplido());
    }

    @Test
    public void noSeVencioAlJugadorADestruirYElObjetivoNoSeCompleta(){
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Pepe"), new Jugador("Carlos")));

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Objetivo objetivo = new ObjetivoDestruccion(jugador2);

        jugador1.agregarObjetivo(objetivo);

        assertFalse(jugador1.objetivoCumplido());
    }
}