package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatallaTest {

    @Test
    public void crearUnaBatallaValidaNoTiraExcepciones() throws PaisNoTePerteneceException, AtaqueAPaisPropioException, AtaqueConCantidadInvalidaException, PaisNoLimitrofeException {

        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugador = new Jugador("Angel Di Maria");
        paisAtacante.asignarDuenio(jugador);
        paisAtacado.asignarDuenio(new Jugador("Richarlison"));
        paisAtacante.agregarEjercitos(4, jugador);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante,3, paisAtacante.getDuenio());

        assertTrue(batalla instanceof Batalla);
    }

    @Test
    public void crearUnaBatallaConUnPaisQueNoLePerteneceAlJugadorLevantaUnaExcepcion() {

        Pais paisAtacante = new Pais("Portugal", new ArrayList<String>(Arrays.asList("España")));
        Pais paisAtacado = new Pais("España", new ArrayList<String>(Arrays.asList("Portugal")));
        paisAtacante.asignarDuenio(new Jugador("Angel Di Maria"));
        paisAtacado.asignarDuenio(new Jugador("Richarlison"));

        assertThrows(PaisNoTePerteneceException.class, () ->
            new Batalla(paisAtacado, paisAtacante, 3, paisAtacado.getDuenio()));
    }

    @Test
    public void crearUnaBatallaParaAtacarAUnPaisPropioLevantaUnaExcepcion() throws AtaqueAPaisPropioException, PaisNoTePerteneceException {

        Pais paisAtacante = new Pais("España", new ArrayList<String>(Arrays.asList("Italia")));
        Pais paisAtacado = new Pais("Italia", new ArrayList<String>(Arrays.asList("España")));
        Jugador jugadorAtacante = new Jugador("Angel Di Maria");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacante);
        paisAtacante.agregarEjercitos(4, jugadorAtacante);

        assertThrows(AtaqueAPaisPropioException.class, () ->
            new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio()));
    }

    @Test
    public void batallaEntreDosPaisesTerminaConConquista() throws AtaqueConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueAPaisPropioException, PaisNoLimitrofeException {

        Pais paisAtacante = new Pais("Argentina", new ArrayList<String>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<String>(Arrays.asList("Argentina")));
        Jugador jugadorAtacante = new Jugador("Angel Di Maria");
        Jugador jugadorAtacado = new Jugador("Richarlison");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(4, jugadorAtacante);
        paisAtacado.agregarEjercitos(1, jugadorAtacado);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<>(Arrays.asList(6, 5, 4));
        ArrayList<Integer> dadosAtacado = new ArrayList<>(Arrays.asList(5));
        batalla.ataqueEntrePaises(dadosAtacado, dadosAtacante);
        assertEquals(paisAtacante.getDuenio(), paisAtacado.getDuenio());
    }

    @Test
    public void batallaEntreDosPaisesNoTerminaConConquista() throws AtaqueConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueAPaisPropioException, PaisNoLimitrofeException {

        Pais paisAtacante= new Pais("Estados Unidos", new ArrayList<String>(Arrays.asList("Canada")));
        Pais paisAtacado= new Pais("Canada", new ArrayList<String>(Arrays.asList("Estados Unidos")));

        Jugador jugadorAtacante = new Jugador("Angel Di Maria");
        Jugador jugadorAtacado = new Jugador("Richarlison");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(10, jugadorAtacante);
        paisAtacado.agregarEjercitos(4, jugadorAtacado);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 3, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<>(Arrays.asList(3, 2, 1));
        ArrayList<Integer> dadosAtacado = new ArrayList<>(Arrays.asList(6, 5, 4));
        batalla.ataqueEntrePaises(dadosAtacado, dadosAtacante);
        assertEquals(jugadorAtacado, paisAtacado.getDuenio());
    }

    @Test
    public void AtacarUnPaisConMasEjercitosDeLosQueTieneElPaisLevantaUnaExcepcion() throws AtaqueConCantidadInvalidaException, PaisNoTePerteneceException {

        Pais paisAtacante = new Pais("Argentina", new ArrayList<String>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<String>(Arrays.asList("Argentina")));
        Jugador jugadorAtacante = new Jugador("Angel Di Maria");
        Jugador jugadorAtacado = new Jugador("Richarlison");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(4,jugadorAtacante);
        paisAtacado.agregarEjercitos(3, jugadorAtacado);

        assertThrows(AtaqueConCantidadInvalidaException.class, () ->
                new Batalla(paisAtacado, paisAtacante, 5, paisAtacante.getDuenio()));
    }

    @Test
    public void batallaEntreDosPaisesPierdeLaCantidadDeEjercitosCorrecta() throws AtaqueConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueAPaisPropioException, PaisNoLimitrofeException {

        Pais paisAtacante = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugadorAtacante = new Jugador("Angel Di Maria");
        Jugador jugadorAtacado = new Jugador("Richarlison");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(10, jugadorAtacante);
        paisAtacado.agregarEjercitos(5, jugadorAtacado);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 5, paisAtacante.getDuenio());
        ArrayList<Integer> dadosAtacante = new ArrayList<>(Arrays.asList(6, 6, 1));
        ArrayList<Integer> dadosAtacado = new ArrayList<>(Arrays.asList(4,4,2));
        batalla.ataqueEntrePaises(dadosAtacado, dadosAtacante);
        assertEquals(3, paisAtacado.getCantidadEjercitos());
    }

    @Test
    public void batallaEntrePaisesNoLimitrofesTiraExcepcion() throws PaisNoLimitrofeException, PaisNoTePerteneceException {

        ArrayList<String> limitrofesArgentina = new ArrayList<>(Arrays.asList("Bolivia", "Uruguay", "Brasil"));
        ArrayList<String> limitrofesEspania = new ArrayList<>(Arrays.asList("Sahara", "Francia", "Gran Bretaña"));

        Jugador jugadorAtacante = new Jugador("Fernando");
        Pais atacante = new Pais("Argentina", limitrofesArgentina);
        atacante.asignarDuenio(jugadorAtacante);
        atacante.agregarEjercitos(10, jugadorAtacante);

        Jugador jugadorAtacado = new Jugador("Rosario");
        Pais atacado = new Pais("España", limitrofesEspania);
        atacado.asignarDuenio(jugadorAtacado);
        atacado.agregarEjercitos(5, jugadorAtacado);

        assertThrows(PaisNoLimitrofeException.class, () -> {
            new Batalla(atacado, atacante, 5, atacante.getDuenio());
        });
    }
}