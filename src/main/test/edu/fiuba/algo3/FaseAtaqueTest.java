package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FaseAtaqueTest {

    @Test
    public void SiUnJugadorConquistaUnPaisSeLeDaUnaCarta() throws PaisNoTePerteneceException, PaisNoLimitrofeException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {

        Jugador jugadorAtacante = new Jugador("Pepe");
        Jugador jugadorAtacado = new Jugador("Mefishto");
        Carta carta = new CartaNoActivada("Mongolia", "Barco");
        ArrayList<Carta> cartas= new ArrayList<>();
        cartas.add(carta);
        FaseAtaque fase = new FaseAtaque(jugadorAtacante, new ArrayList<>(Arrays.asList(carta)));
        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));

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
        Carta carta = new CartaNoActivada("Mongolia", "Barco");
        FaseAtaque fase = new FaseAtaque(jugadorAtacante, new ArrayList<>(Arrays.asList(carta)));
        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));

        jugadorAtacante.agregarPais(paisAtacante);
        jugadorAtacado.agregarPais(paisAtacado);
        paisAtacante.agregarEjercitos(2, jugadorAtacante);
        paisAtacado.agregarEjercitos(50, jugadorAtacado);
        fase.jugar(1, paisAtacante, paisAtacado);

        assertNotEquals(1, jugadorAtacante.getCantidadCartas());
    }

}
