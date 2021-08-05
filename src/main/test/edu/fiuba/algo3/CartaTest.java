package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.CartaYaActivadaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void ActivarUnaCartaDeUnPaisQueTePerteneceFuncionaCorrectamente() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil")));
        Carta carta = new Carta(argentina, "Comodin");
        jugador.agregarPais(argentina);
        jugador.darleCarta(carta);
        carta.activarse(jugador);
        assertEquals(2, argentina.getCantidadEjercitos());
    }

    @Test
    public void NoSePuedeActivarUnaCartaDeUnPaisQueNoTePertenece() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais brasil = new Pais("Brasil", new ArrayList<>(List.of("Argentina")));
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil")));
        Carta carta = new Carta(argentina, "Comodin");
        jugador.agregarPais(brasil);
        jugador.darleCarta(carta);
        assertNotEquals(2, brasil.getCantidadEjercitos());
    }

    @Test
    public void intentarActivarUnaCartaYaActivadaLanzaUnaExcepcion() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil")));
        Carta carta = new Carta(argentina, "Comodin");
        jugador.agregarPais(argentina);
        jugador.darleCarta(carta);
        carta.activarse(jugador);
        assertThrows(CartaYaActivadaException.class, ()->{
            carta.activarse(jugador);
        });
    }
}