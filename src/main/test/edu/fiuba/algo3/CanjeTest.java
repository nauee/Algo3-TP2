package edu.fiuba.algo3;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

// cantidad correcta de fichas con un canje y con 2, que son los estaticos
// cantidad correcta de fichas con n canjes
// dos iguales y una distinta levanta una excepcion
// cantidad correcta de fichas con n canjes y un continente


public class CanjeTest {

    @Test
    public void PuedoCanjearTresCartasConDistintoSimbolo(){
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Barco");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearTresCartasConMismoSimbolo(){
        Carta carta1 = new CartaNoActivada("Argentina", "Buenarda moto");
        Carta carta2 = new CartaNoActivada("Brasil", "Buenarda moto");
        Carta carta3 = new CartaNoActivada("Ecuador", "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void NoPuedoCanjearDosCartasIgualesYUnaDistinta(){
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Buenarda moto");
        Carta carta3 = new CartaNoActivada("Ecuador", "Buenarda moto");
        assertFalse(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearDosCartasIgualesYUnComodin(){
        Carta carta1 = new CartaNoActivada("Argentina", "Comodin");
        Carta carta2 = new CartaNoActivada("Brasil", "Buenarda moto");
        Carta carta3 = new CartaNoActivada("Ecuador", "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PuedoCanjearDosCartasDistintasYUnComodin(){
        Carta carta1 = new CartaNoActivada("Argentina", "Comodin");
        Carta carta2 = new CartaNoActivada("Brasil", "Fiat Palio");
        Carta carta3 = new CartaNoActivada("Ecuador", "Buenarda moto");
        assertTrue(Carta.canjeables(carta1, carta2,carta3));
    }

    @Test
    public void PrimerCanjeDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoTePerteneceException, FichasInsuficientesException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Etapa etapa;
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Barco");
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
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
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Barco");
        Carta carta4 = new CartaNoActivada("Peru", "Fiat Palio");
        Carta carta5 = new CartaNoActivada("Uruguay", "Globo");
        Carta carta6 = new CartaNoActivada("Colombia", "Barco");
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Jugador jugador1 = new Jugador("Nicolas");
        jugador1.darleCarta(carta1);
        jugador1.darleCarta(carta2);
        jugador1.darleCarta(carta3);
        jugador1.darleCarta(carta4);
        jugador1.darleCarta(carta5);
        jugador1.darleCarta(carta6);
        jugador1.agregarPais(argentina);
        jugador1.agregarPais(brasil);
        Etapa.asignarValores(new ArrayList<>(), new ArrayList<>(Arrays.asList(jugador1)), new ArrayList<>(Arrays.asList(carta1,carta2,carta3,carta4,carta5,carta6)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.canjearCartas(carta4, carta5, carta6);
        etapa.jugar(12, argentina);
        assertEquals(12, argentina.getCantidadEjercitos());
    }

    @Test
    public void NCanjesDevuelveCantidadCorrectaDeFichas() throws NoSePuedeCanjearEnEtapaBatallaException, PaisNoTePerteneceException, FichasInsuficientesException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Etapa etapa;
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Barco");
        Carta carta4 = new CartaNoActivada("Peru", "Fiat Palio");
        Carta carta5 = new CartaNoActivada("Uruguay", "Globo");
        Carta carta6 = new CartaNoActivada("Colombia", "Barco");
        Carta carta7 = new CartaNoActivada("Italia", "Fiat Palio");
        Carta carta8 = new CartaNoActivada("Francia", "Globo");
        Carta carta9 = new CartaNoActivada("Canada", "Barco");
        Carta carta10 = new CartaNoActivada("EEUU", "Fiat Palio");
        Carta carta11 = new CartaNoActivada("Mexico", "Globo");
        Carta carta12 = new CartaNoActivada("Alemania", "Barco");
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
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
        Etapa.asignarValores(new ArrayList<>(), new ArrayList<>(Arrays.asList(jugador1)), new ArrayList<>(Arrays.asList(carta1,carta2,carta3,carta4,carta5,carta6)));
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
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Barco");
        Pais argentina = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
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
        Etapa.asignarValores(new ArrayList<>(Arrays.asList(america)), new ArrayList<>(Arrays.asList(jugador1, jugador2)), new ArrayList<>(Arrays.asList(carta1,carta2,carta3)));
        etapa = new EtapaColocacion();
        etapa.canjearCartas(carta1, carta2, carta3);
        etapa.jugar(10, argentina);
        assertEquals(10, argentina.getCantidadEjercitos());
    }
}
