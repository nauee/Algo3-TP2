package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void ActivarUnaCartaDeUnPaisQueTePerteneceFuncionaCorrectamente() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Carta carta = new CartaNoActivada("Argentina", "Comodin");
        jugador.agregarPais(pais);
        jugador.darleCarta(carta);
        carta.activarse(new ArrayList<Pais>(Arrays.asList(pais)), jugador);
        assertEquals(2, pais.getCantidadEjercitos());
    }

    @Test
    public void NoSePuedeActivarUnaCartaDeUnPaisQueNoTePertenece() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Carta carta = new CartaNoActivada("Argentina", "Comodin");
        jugador.agregarPais(pais);
        jugador.darleCarta(carta);
        assertNotEquals(2, pais.getCantidadEjercitos());
    }

    @Test
    public void intentarActivarUnaCartaYaActivadaLanzaUnaExcepcion() throws CartaYaActivadaException {
        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Carta carta = new CartaNoActivada("Argentina", "Comodin");
        jugador.agregarPais(pais);
        jugador.darleCarta(carta);
        Carta cartaActualizada = carta.activarse(new ArrayList<Pais>(Arrays.asList(pais)), jugador);
        assertThrows(CartaYaActivadaException.class, ()->{
            cartaActualizada.activarse(new ArrayList<Pais>(Arrays.asList(pais)), jugador);
        });
    }
}