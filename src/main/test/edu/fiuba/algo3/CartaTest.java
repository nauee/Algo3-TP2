package edu.fiuba.algo3;

import edu.fiuba.algo3.excepciones.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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

    @Test
    public void intentarActivarUnaCartaEnEtapaBatallaLanzaUnaExcepcion() throws NoSePudoLeerExcepcion, PaisNoTePerteneceException, PaisNoExisteException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        Jugador fernando = new Jugador("Fernando");
        Jugador nicolas = new Jugador("Nicolas");
        Juego juego = new Juego(new ArrayList<>(List.of(fernando, nicolas)));
        Pais argentina = juego.buscarPais("Argentina");
        Carta carta = new Carta(argentina, "Mate");

        fernando.darleCarta(carta);
        juego.pasarDeFase();
        juego.pasarDeFase();

        assertThrows(NoSePuedeActivarCartaEnLaBatallaException.class, ()->juego.activarCarta(carta));
    }
}