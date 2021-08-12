package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.MovimientoConCantidadInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLimitrofeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.etapa.FaseAgrupamiento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FaseAgrupamientoTest {

    @Test
    public void EsPosibleMoverEjercitosEntrePaisesValidos() throws PaisNoTePerteneceException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException {
        Pais paisOrigen = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisDestino = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugador = new Jugador("Pepe");
        jugador.agregarPais(paisOrigen);
        jugador.agregarPais(paisDestino);
        paisOrigen.agregarEjercitos(4, jugador);
        FaseAgrupamiento fase = new FaseAgrupamiento(jugador);
        fase.jugar(3, paisOrigen, paisDestino);
        assertEquals(3, paisDestino.getCantidadEjercitos());
    }

    @Test
    public void NoEsPosibleMoverMasEjercitosDeLosDisponibles() throws PaisNoTePerteneceException{
        Pais paisOrigen = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisDestino = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugador = new Jugador("Pepe");
        jugador.agregarPais(paisOrigen);
        jugador.agregarPais(paisDestino);
        paisOrigen.agregarEjercitos(4, jugador);
        FaseAgrupamiento fase = new FaseAgrupamiento(jugador);
        assertThrows(MovimientoConCantidadInvalidaException.class, () -> {
            fase.jugar(5, paisOrigen, paisDestino);
        });
    }

    @Test
    public void NoEsPosibleMoverLaMismaCantidadDeEjercitosQueLosDisponibles() throws PaisNoTePerteneceException{
        Pais paisOrigen = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisDestino = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugador = new Jugador("Pepe");
        jugador.agregarPais(paisOrigen);
        jugador.agregarPais(paisDestino);
        paisOrigen.agregarEjercitos(4, jugador);
        FaseAgrupamiento fase = new FaseAgrupamiento(jugador);
        assertThrows(MovimientoConCantidadInvalidaException.class, () -> {
            fase.jugar(4, paisOrigen, paisDestino);
        });
    }

    @Test
    public void NoEsPosibleMoverEjercitosEntrePaisesNoLimitrofes() throws PaisNoTePerteneceException{
        Pais paisOrigen = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisDestino = new Pais("Mongolia", new ArrayList<>(Arrays.asList("China")));
        Jugador jugador = new Jugador("Pepe");
        jugador.agregarPais(paisOrigen);
        jugador.agregarPais(paisDestino);
        paisOrigen.agregarEjercitos(4, jugador);
        FaseAgrupamiento fase = new FaseAgrupamiento(jugador);
        assertThrows(PaisNoLimitrofeException.class, () -> {
            fase.jugar(3, paisOrigen, paisDestino);
        });
    }

    @Test
    public void NoEsPosibleMoverEjercitosAUnPaisQueNoTePertenece() throws PaisNoTePerteneceException{
        Pais paisOrigen = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Pais paisDestino = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Jugador jugador = new Jugador("Pepe");
        Jugador jugador2 = new Jugador("Rodolfo");
        jugador.agregarPais(paisOrigen);
        jugador2.agregarPais(paisDestino);
        paisOrigen.agregarEjercitos(4, jugador);
        FaseAgrupamiento fase = new FaseAgrupamiento(jugador);
        assertThrows(PaisNoTePerteneceException.class, () -> {
            fase.jugar(3, paisOrigen, paisDestino);
        });
    }

}
