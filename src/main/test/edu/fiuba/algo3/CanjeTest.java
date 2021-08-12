package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.etapa.Etapa;
import edu.fiuba.algo3.modelo.etapa.EtapaColocacion;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logica.Juego;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanjeTest {

    @Test
    public void PuedoCanjearTresCartasConDistintoSimbolo(){
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Fiat Palio");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearTresCartasConMismoSimbolo(){
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Buenarda moto");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void NoPuedoCanjearDosCartasIgualesYUnaDistinta(){
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Fiat Palio");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Buenarda moto");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");
        assertFalse(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearDosCartasIgualesYUnComodin(){
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Comodin");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Buenarda moto");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearDosCartasDistintasYUnComodin(){
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Comodin");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Fiat Palio");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PrimerCanjeDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoTePerteneceException, FichasInsuficientesException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Etapa etapa;
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Carta carta1 = new Carta(argentina, "Fiat Palio");
        Carta carta2 = new Carta(brasil, "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");
        Jugador jugador1 = new Jugador("Nicolas");
        jugador1.darleCarta(carta1);
        jugador1.darleCarta(carta2);
        jugador1.darleCarta(carta3);
        jugador1.agregarPais(argentina);
        jugador1.agregarPais(brasil);
        Etapa.asignarValores(new ArrayList<>(), new ArrayList<>(Arrays.asList(jugador1)), new ArrayList<>(Arrays.asList(carta1,carta2,carta3)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.jugar(5, argentina);
        assertEquals(5, argentina.getCantidadEjercitos());
    }

    @Test
    public void SegundoCanjeDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoTePerteneceException, FichasInsuficientesException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Etapa etapa;
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Carta carta1 = new Carta(argentina, "Fiat Palio");
        Carta carta2 = new Carta(brasil, "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");
        Carta carta4 = new Carta(new Pais("Peru", new ArrayList<>(List.of("Ecuador"))), "Fiat Palio");
        Carta carta5 = new Carta(new Pais("Uruguay", new ArrayList<>(List.of("Argentina"))), "Globo");
        Carta carta6 = new Carta(new Pais("Colombia", new ArrayList<>(List.of("Ecuador"))), "Barco");
        Jugador jugador1 = new Jugador("Nicolas");
        jugador1.darleCarta(carta1);
        jugador1.darleCarta(carta2);
        jugador1.darleCarta(carta3);
        jugador1.darleCarta(carta4);
        jugador1.darleCarta(carta5);
        jugador1.darleCarta(carta6);
        jugador1.agregarPais(argentina);
        jugador1.agregarPais(brasil);
        Etapa.asignarValores(new ArrayList<>(), new ArrayList<>(List.of(jugador1)), new ArrayList<>(List.of(carta1,carta2,carta3,carta4,carta5,carta6)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.canjearCartas(carta4, carta5, carta6);
        etapa.jugar(12, argentina);
        assertEquals(12, argentina.getCantidadEjercitos());
    }

    @Test
    public void NCanjesDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoTePerteneceException, FichasInsuficientesException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Etapa etapa;
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(List.of("Argentina", "Uruguay", "Bolivia")));
        Carta carta1 = new Carta(argentina, "Fiat Palio");
        Carta carta2 = new Carta(brasil, "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");
        Carta carta4 = new Carta(new Pais("Peru", new ArrayList<>(List.of("Ecuador"))), "Fiat Palio");
        Carta carta5 = new Carta(new Pais("Uruguay", new ArrayList<>(List.of("Argentina"))), "Globo");
        Carta carta6 = new Carta(new Pais("Colombia", new ArrayList<>(List.of("´Peru"))), "Barco");
        Carta carta7 = new Carta(new Pais("Italia", new ArrayList<>(List.of("Francia"))), "Fiat Palio");
        Carta carta8 = new Carta(new Pais("Francia", new ArrayList<>(List.of("Italia"))), "Globo");
        Carta carta9 = new Carta(new Pais("Canada", new ArrayList<>(List.of("EEUU"))), "Barco");
        Carta carta10 = new Carta(new Pais("EEUU", new ArrayList<>(List.of("Canada"))), "Fiat Palio");
        Carta carta11 = new Carta(new Pais("Mexico", new ArrayList<>(List.of("EEUU"))), "Globo");
        Carta carta12 = new Carta(new Pais("Alemania", new ArrayList<>(List.of("Francia"))), "Barco");
        Jugador jugador1 = new Jugador("Nicolas");
        jugador1.darleCarta(carta1);
        jugador1.darleCarta(carta2);
        jugador1.darleCarta(carta3);
        jugador1.darleCarta(carta4);
        jugador1.darleCarta(carta5);
        jugador1.darleCarta(carta6);
        jugador1.darleCarta(carta7);
        jugador1.darleCarta(carta8);
        jugador1.darleCarta(carta9);
        jugador1.darleCarta(carta10);
        jugador1.darleCarta(carta11);
        jugador1.darleCarta(carta12);
        jugador1.agregarPais(argentina);
        jugador1.agregarPais(brasil);
        Etapa.asignarValores(new ArrayList<>(), new ArrayList<>(List.of(jugador1)), new ArrayList<>(List.of(carta1,carta2,carta3,carta4,carta5,carta6)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.canjearCartas(carta4, carta5, carta6);
        etapa.canjearCartas(carta7, carta8, carta9);
        etapa.canjearCartas(carta10, carta11, carta12);
        etapa.jugar(37, argentina);
        assertEquals(37, argentina.getCantidadEjercitos());
    }

    @Test
    public void CanjeConContinenteConquistadoDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
        Etapa etapa;
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Carta carta1 = new Carta(argentina, "Fiat Palio");
        Carta carta2 = new Carta(brasil, "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");
        Continente america = new Continente("America", 5);
        Jugador jugador1 = new Jugador("Nicolas");
        Jugador jugador2 = new Jugador("Random");
        jugador1.darleCarta(carta1);
        jugador1.darleCarta(carta2);
        jugador1.darleCarta(carta3);
        america.agregarPais(argentina);
        america.agregarPais(brasil);
        jugador1.agregarPais(argentina);
        jugador1.agregarPais(brasil);
        Etapa.asignarValores(new ArrayList<>(List.of(america)), new ArrayList<>(List.of(jugador1, jugador2)), new ArrayList<>(List.of(carta1,carta2,carta3)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.jugar(10, argentina);
        assertEquals(10, argentina.getCantidadEjercitos());
    }

    @Test
    public void intentarCanjearDosCartasIgualesYUnaDistintaLanzaUnaExcepcion() throws NoSePudoLeerExcepcion, PaisNoTePerteneceException, PaisNoExisteException, ParseException, IOException{
        Juego juego = new Juego(new ArrayList<>(List.of(new Jugador("Nicolas"), new Jugador("Fer"))));

        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Fiat Palio");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Buenarda moto");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Buenarda moto");

        assertThrows(SimbolosInvalidosException.class, ()-> juego.canjearCartas(carta1, carta2, carta3));
    }

    @Test
    public void intentarCanjearCartasEnEtapaBatallaLanzaUnaExcepcion() throws NoSePudoLeerExcepcion, PaisNoTePerteneceException, PaisNoExisteException, ParseException, IOException, QuedanFichasPorColocarException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
        Jugador nicolas = new Jugador("Nicolas");
        Jugador fernando = new Jugador("Fernando");
        Juego juego = new Juego(new ArrayList<>(List.of(nicolas, fernando)));
        Carta carta1 = new Carta(new Pais("Argentina", new ArrayList<>(List.of("Brasil"))), "Fiat Palio");
        Carta carta2 = new Carta(new Pais("Brasil", new ArrayList<>(List.of("Argentina"))), "Globo");
        Carta carta3 = new Carta(new Pais("Ecuador", new ArrayList<>(List.of("Brasil"))), "Barco");

        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        argentina.asignarDuenio(nicolas);
        brasil.asignarDuenio(fernando);
        juego.jugar(5, argentina);
        juego.pasarDeFase();
        juego.jugar(5, brasil);
        juego.pasarDeFase();
        juego.jugar(3, argentina);
        juego.pasarDeFase();
        juego.jugar(3, brasil);
        juego.pasarDeFase();

        assertThrows(NoSePuedeCanjearEnEtapaBatallaException.class, ()-> juego.canjearCartas(carta1, carta2, carta3));
    }
}