package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logica.Juego;
import org.json.simple.parser.ParseException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void ActivarUnaCartaDeUnPaisQueTePerteneceFuncionaCorrectamente() throws CartaYaActivadaException, PaisNoTePerteneceException{
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
    public void intentarActivarUnaCartaYaActivadaLanzaUnaExcepcion() throws CartaYaActivadaException, PaisNoTePerteneceException{
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
    public void intentarActivarUnaCartaEnEtapaBatallaLanzaUnaExcepcion() throws NoSePudoLeerExcepcion, PaisNoTePerteneceException, PaisNoExisteException, ParseException, IOException, QuedanFichasPorColocarException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
        Jugador fernando = new Jugador("Fernando");
        Jugador nicolas = new Jugador("Nicolas");
        Juego juego = new Juego(new ArrayList<>(List.of(fernando, nicolas)));
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Carta carta = new Carta(argentina, "Mate");

        fernando.darleCarta(carta);
        argentina.asignarDuenio(fernando);
        brasil.asignarDuenio(nicolas);
        juego.jugar(5, argentina);
        juego.pasarDeFase();
        juego.jugar(5, brasil);
        juego.pasarDeFase();
        juego.jugar(3, argentina);
        juego.pasarDeFase();
        juego.jugar(3, brasil);
        juego.pasarDeFase();

        assertThrows(NoSePuedeActivarCartaEnLaBatallaException.class, ()->juego.activarCarta(carta));
    }

    @Test
    public void intentarActivarUnaCartaDeUnPaisQueNoLePerteneceLanzaUnaExcepcion(){
        Jugador jugador1 = new Jugador("Nicolas");
        Jugador jugador2 = new Jugador("Nahuel");
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil", "Uruguay")));
        Pais brasil = new Pais("Brasil", new ArrayList<>(List.of("Argentina", "Uruguay")));
        Carta carta = new Carta(argentina, "Mate");

        jugador1.agregarPais(brasil);
        jugador1.darleCarta(carta);
        jugador2.agregarPais(argentina);

        assertThrows(PaisNoTePerteneceException.class, () -> jugador1.activarCarta(carta));
    }
}