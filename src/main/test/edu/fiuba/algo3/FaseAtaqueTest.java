package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.etapa.FaseAtaque;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoConquista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FaseAtaqueTest {

    @Test
    public void SiUnJugadorConquistaUnPaisSeLeDaUnaCarta() throws PaisNoTePerteneceException, PaisNoLimitrofeException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {

        Jugador jugadorAtacante = new Jugador("Pepe");
        Jugador jugadorAtacado = new Jugador("Mefishto");
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of()), new ArrayList<>(List.of(1)));
        jugadorAtacante.agregarObjetivo(objetivo);
        jugadorAtacado.agregarObjetivo(objetivo);
        Carta carta = new Carta(new Pais("Mongolia", new ArrayList<>(List.of("China"))), "Barco");
        ArrayList<Carta> cartas= new ArrayList<>();
        cartas.add(carta);
        FaseAtaque fase = new FaseAtaque(jugadorAtacante, new ArrayList<>(List.of(carta)));
        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(List.of("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(List.of("Argentina")));

        jugadorAtacante.agregarPais(paisAtacante);
        jugadorAtacado.agregarPais(paisAtacado);
        paisAtacante.agregarEjercitos(2, jugadorAtacante);
        fase.jugar(1, paisAtacante, paisAtacado);
        fase.siguienteFase(cartas);
        assertEquals(1, jugadorAtacante.getCantidadCartas());
    }

    @Test
    public void SiUnJugadorNoConquistaUnPaisNoSeLeDaUnaCarta() throws PaisNoTePerteneceException, PaisNoLimitrofeException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {

        Jugador jugadorAtacante = new Jugador("Pepe");
        Jugador jugadorAtacado = new Jugador("Mefishto");
        Objetivo objetivo = new ObjetivoConquista(new ArrayList<>(List.of()), new ArrayList<>(List.of(1)));
        jugadorAtacante.agregarObjetivo(objetivo);
        jugadorAtacado.agregarObjetivo(objetivo);
        Carta carta = new Carta(new Pais("Mongolia", new ArrayList<>(List.of("China"))), "Barco");
        FaseAtaque fase = new FaseAtaque(jugadorAtacante, new ArrayList<>(List.of(carta)));
        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(List.of("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(List.of("Argentina")));

        jugadorAtacante.agregarPais(paisAtacante);
        jugadorAtacado.agregarPais(paisAtacado);
        paisAtacante.agregarEjercitos(2, jugadorAtacante);
        paisAtacado.agregarEjercitos(50, jugadorAtacado);
        fase.jugar(1, paisAtacante, paisAtacado);

        assertNotEquals(1, jugadorAtacante.getCantidadCartas());
    }

}
