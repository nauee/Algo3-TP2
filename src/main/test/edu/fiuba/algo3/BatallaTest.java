package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BatallaTest {

    @Test
    public void crearUnaBatallaConPaisesValidos() throws NoTePerteneceException, AtaqueAPaisPropioException {

        Pais paisAtacante = new Pais("Uruguay");
        Pais paisAtacado = new Pais("Brasil");
        paisAtacante.asignarJugador(1);
        paisAtacado.asignarJugador(2);
        Batalla batalla = new Batalla(paisAtacado, paisAtacante, 1);
        assertTrue(batalla instanceof Batalla);
    }

    @Test
    public void crearUnaBatallaConUnPaisQueNoLePerteneceAlJugadorLevantaUnaExcepcion() {
        Pais paisAtacante = new Pais("Portugal");
        Pais paisAtacado = new Pais("España");
        paisAtacante.asignarJugador(1);
        paisAtacado.asignarJugador(2);
        assertThrows(NoTePerteneceException.class, () -> {
            Batalla batalla = new Batalla(paisAtacado, paisAtacante, 4);
        });
    }

    @Test
    public void crearUnaBatallaParaAtacarAUnPaisPropioLevantaUnaExcepcion() {
        Pais paisAtacante = new Pais("España");
        Pais paisAtacado = new Pais("Italia");
        paisAtacante.asignarJugador(1);
        paisAtacado.asignarJugador(1);
        assertThrows(AtaqueAPaisPropioException.class, () -> {
            Batalla batalla = new Batalla(paisAtacado, paisAtacante, 1);
        });
    }
}