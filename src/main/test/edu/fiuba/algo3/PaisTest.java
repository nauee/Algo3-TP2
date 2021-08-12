package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.AtaqueConCantidadInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaisTest {

    @Test
    public void AtacarUnPaisConMasEjercitosDeLosQueTieneElPaisLevantaUnaExcepcion() throws AtaqueConCantidadInvalidaException, PaisNoTePerteneceException {

        Pais paisAtacante = new Pais("Argentina", new ArrayList<String>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<String>(Arrays.asList("Argentina")));
        Jugador jugadorAtacante = new Jugador("Valentina");
        Jugador jugadorAtacado = new Jugador("Maria");
        paisAtacante.asignarDuenio(jugadorAtacante);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(4,jugadorAtacante);
        paisAtacado.agregarEjercitos(3, jugadorAtacado);

        assertThrows(AtaqueConCantidadInvalidaException.class, () ->
                paisAtacante.atacarPais(paisAtacado, 5, jugadorAtacante));
    }

    @Test
    public void AtacarConPaisQueNoLePerteneceAlJugadorLevantaException() throws PaisNoTePerteneceException{
        Pais paisAtacante = new Pais("Argentina", new ArrayList<String>(Arrays.asList("Brasil")));
        Pais paisAtacado = new Pais("Brasil", new ArrayList<String>(Arrays.asList("Argentina")));
        Jugador jugadorAtacante = new Jugador("Angela");
        Jugador jugadorAtacado = new Jugador("Ricardo");
        paisAtacante.asignarDuenio(jugadorAtacado);
        paisAtacado.asignarDuenio(jugadorAtacado);
        paisAtacante.agregarEjercitos(4,jugadorAtacado);
        paisAtacado.agregarEjercitos(3, jugadorAtacado);

        assertThrows(PaisNoTePerteneceException.class, () ->
                paisAtacante.atacarPais(paisAtacado, 1, jugadorAtacante));
    }

}
