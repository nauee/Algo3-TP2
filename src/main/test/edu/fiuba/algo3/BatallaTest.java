package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatallaTest {

    @Test
    public void crearUnaBatallaConPaisesValidos() throws NoTePerteneceException, AtaqueAPaisPropioException, AtaqueConCantidadInvalidaException {

        Pais paisAtacante = new Pais("Argentina");
        Pais paisAtacado = new Pais("Brasil");
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(new Jugador("Richarlison",2));
        paisAtacante.agregarEjercitos(4);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante,3, paisAtacante.getDuenio());
        assertTrue(batalla instanceof Batalla);
    }

    @Test
    public void crearUnaBatallaConUnPaisQueNoLePerteneceAlJugadorLevantaUnaExcepcion() {
        Pais paisAtacante = new Pais("Portugal");
        Pais paisAtacado = new Pais("España");
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(new Jugador("Richarlison",2));
        assertThrows(NoTePerteneceException.class, () -> {
            Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacado.getDuenio());
        });
    }

    @Test
    public void crearUnaBatallaParaAtacarAUnPaisPropioLevantaUnaExcepcion() {
        Pais paisAtacante = new Pais("España");
        Pais paisAtacado = new Pais("Italia");
        paisAtacante.agregarEjercitos(4);
        Jugador jugadorAtacante = new Jugador("Angel Di Maria",1);
        paisAtacante.asignarJugador(jugadorAtacante);
        paisAtacado.asignarJugador(jugadorAtacante);
        assertThrows(AtaqueAPaisPropioException.class, () -> {
            Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio());
        });
    }

    @Test
    public void batallaEntreDosPaisesTerminaConConquista() throws AtaqueConCantidadInvalidaException, NoTePerteneceException, AtaqueAPaisPropioException {
        Pais paisAtacante = new Pais("Argentina");
        Pais paisAtacado = new Pais("Brasil");
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(new Jugador("Richarlison",2));
        paisAtacante.agregarEjercitos(4);
        paisAtacado.agregarEjercitos(1);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<Integer>(Arrays.asList(6, 5, 4));
        ArrayList<Integer> dadosAtacado = new ArrayList<Integer>(Arrays.asList(5));
        batalla.batallar(dadosAtacado, dadosAtacante);
        assertEquals(paisAtacante.getDuenio(), paisAtacado.getDuenio());
    }

    @Test
    public void batallaEntreDosPaisesNoTerminaConConquista() throws AtaqueConCantidadInvalidaException, NoTePerteneceException, AtaqueAPaisPropioException {
        Pais paisAtacante= new Pais("Estados Unidos");
        Pais paisAtacado= new Pais("China");
        Jugador jugadorAtacado = new Jugador("Richarlison",2);
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(jugadorAtacado);
        paisAtacante.agregarEjercitos(10);
        paisAtacado.agregarEjercitos(4);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<>(Arrays.asList(3, 2, 1));
        ArrayList<Integer> dadosAtacado = new ArrayList<>(Arrays.asList(6, 5, 4));
        assertEquals(jugadorAtacado, paisAtacado.getDuenio());
    }

    @Test
    public void AtacarUnPaisConMasEjercitosDeLosQueTieneElPaisLevantaUnaExcepcion() {
        Pais paisAtacante = new Pais("Argentina");
        Pais paisAtacado = new Pais("Brasil");
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(new Jugador("Richarlison",2));
        paisAtacado.agregarEjercitos(3);
        paisAtacante.agregarEjercitos(4);
        assertThrows(AtaqueConCantidadInvalidaException.class, () -> {
            Batalla batalla = new Batalla(paisAtacado, paisAtacante, 5, paisAtacante.getDuenio());
        });
    }

    @Test
    public void batallaEntreDosPaisesPierdeLaCantidadDeEjercitosCorrecta() throws AtaqueConCantidadInvalidaException, NoTePerteneceException, AtaqueAPaisPropioException {
        Pais paisAtacante = new Pais("Argentina");
        Pais paisAtacado = new Pais("Brasil");
        paisAtacante.asignarJugador(new Jugador("Angel Di Maria",1));
        paisAtacado.asignarJugador(new Jugador("Richarlison",2));
        paisAtacante.agregarEjercitos(10);
        paisAtacado.agregarEjercitos(5);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 5, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<Integer>(Arrays.asList(6, 6, 1));
        ArrayList<Integer> dadosAtacado = new ArrayList<Integer>(Arrays.asList(4,4,2));
        batalla.batallar(dadosAtacado, dadosAtacante);
        assertEquals(3, paisAtacado.getCantidadEjercitos());
    }

}