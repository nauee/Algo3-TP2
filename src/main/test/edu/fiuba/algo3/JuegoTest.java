package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.*;
import edu.fiuba.algo3.excepciones.*;
import edu.fiuba.algo3.modelo.Juego;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Dado.class)
public class JuegoTest {

    @Test
    public void seDistribuyenCorrectamenteLosPaisesEntreJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nicolas"), new Jugador("Rosario"), new Jugador("Agustina"), new Jugador("Nahuel"), new Jugador("Fernando")));
        Juego juego = new Juego(jugadores);
        boolean funciona = true;
        int i = 0;

        while(funciona && i < juego.getCantidadJugadores()) {
            funciona = jugadores.get(i).getCantidadPaises() == 10;
            i++;
        }

        assertTrue(funciona);
    }

    @Test
    public void agregarEjercitosAUnPaisInexistenteLanzaUnaExcepcion() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nahuel"), new Jugador("Fernando")));
        Juego juego = new Juego(jugadores);
        assertThrows(PaisNoExisteException.class, () -> juego.jugar(1, juego.buscarPais("Chipre")));
    }

    @Test
    public void rondaDosJugadoresColocarEjercitosNuevos() throws PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nahuel"), new Jugador("Fernando")));
        Juego juego = new Juego(jugadores);

        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");

        argentina.asignarDuenio(jugadores.get(0));
        brasil.asignarDuenio(jugadores.get(1));

        juego.jugar(3, argentina);
        juego.pasarDeFase();
        juego.jugar(3, brasil);
        juego.pasarDeFase();

        juego.pasarDeFase();
        juego.pasarDeFase();
        juego.pasarDeFase();
        juego.pasarDeFase();

        juego.jugar(1, argentina);
        juego.pasarDeFase();
        juego.jugar(2, brasil);

        assertEquals(argentina.getCantidadEjercitos(), 5);
        assertEquals(brasil.getCantidadEjercitos(), 6);
    }

   @Test
    public void juegoDeUnaRonda3JugadoresUnoControlaAsiaSeAgreganNuevosEjercitos() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nicolas"), new Jugador("Felipe"), new Jugador("Agustina")));
        Juego juego = new Juego(jugadores);

       Pais tartaria = juego.buscarPais("Tartaria");
       Pais mongolia = juego.buscarPais("Mongolia");
       Pais kamtchatka = juego.buscarPais("Kamtchatka");
       Pais turquia = juego.buscarPais("Turquia");
       Pais iran = juego.buscarPais("Iran");
       Pais israel = juego.buscarPais("Israel");
       Pais taymir = juego.buscarPais("Taymir");
       Pais aral = juego.buscarPais("Aral");
       Pais siberia = juego.buscarPais("Siberia");
       Pais japon = juego.buscarPais("Japon");
       Pais gobi = juego.buscarPais("Gobi");
       Pais arabia = juego.buscarPais("Arabia");
       Pais india = juego.buscarPais("India");
       Pais china = juego.buscarPais("China");
       Pais malasia = juego.buscarPais("Malasia");

       tartaria.asignarDuenio(jugadores.get(1));
       mongolia.asignarDuenio(jugadores.get(1));
       kamtchatka.asignarDuenio(jugadores.get(1));
       turquia.asignarDuenio(jugadores.get(1));
       iran.asignarDuenio(jugadores.get(1));
       israel.asignarDuenio(jugadores.get(1));
       taymir.asignarDuenio(jugadores.get(1));
       aral.asignarDuenio(jugadores.get(1));
       siberia.asignarDuenio(jugadores.get(1));
       japon.asignarDuenio(jugadores.get(1));
       gobi.asignarDuenio(jugadores.get(1));
       arabia.asignarDuenio(jugadores.get(1));
       india.asignarDuenio(jugadores.get(1));
       china.asignarDuenio(jugadores.get(1));
       malasia.asignarDuenio(jugadores.get(1));

       Pais brasil = juego.buscarPais("Brasil");
       Pais argentina = juego.buscarPais("Argentina");
       Pais islandia = juego.buscarPais("Islandia");
       Pais alemania = juego.buscarPais("Alemania");

       brasil.asignarDuenio(jugadores.get(0));
       argentina.asignarDuenio(jugadores.get(0));
       islandia.asignarDuenio(jugadores.get(2));
       alemania.asignarDuenio(jugadores.get(2));

       juego.jugar(3, brasil);
       juego.pasarDeFase();
       juego.jugar(2, china);
       juego.pasarDeFase();
       juego.jugar(1, alemania);
       juego.pasarDeFase();

       juego.pasarDeFase();
       juego.pasarDeFase();
       juego.pasarDeFase();
       juego.pasarDeFase();
       juego.pasarDeFase();
       juego.pasarDeFase();
       juego.pasarDeFase();

       juego.jugar((jugadores.get(1).getCantidadFichasPorPais()) + 7, china);
       assertEquals(jugadores.get(1).getCantidadFichasPorPais() + 10 , china.getCantidadEjercitos());
   }

   @SuppressWarnings("unchecked")
   @Test
   public void juegoDeUnaRondaDe2JugadoresJugador1Conquista2PaisesDeJugador2() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
       PowerMockito.mockStatic(Dado.class);
       PowerMockito.when(Dado.lanzar(anyInt())).thenReturn(new ArrayList<>(Arrays.asList(6,6,6)),new ArrayList<>(Arrays.asList(1,1,1)),new ArrayList<>(Arrays.asList(6,6,6)),new ArrayList<>(Arrays.asList(1,1,1)));

       ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nicolas"), new Jugador("Felipe")));
       Juego juego = new Juego(jugadores);

       Pais argentina = juego.buscarPais("Argentina");
       Pais brasil = juego.buscarPais("Brasil");
       Pais chile = juego.buscarPais("Chile");

       argentina.asignarDuenio(jugadores.get(0));
       int cantidadPaisesPrevioAtacar = jugadores.get(0).getCantidadPaises();
       brasil.asignarDuenio(jugadores.get(1));
       chile.asignarDuenio(jugadores.get(1));

       juego.jugar(11, argentina);
       juego.pasarDeFase();
       juego.pasarDeFase();

       juego.jugar(10,argentina, brasil);
       juego.jugar(8,argentina, chile);

       assertEquals(cantidadPaisesPrevioAtacar + 2, jugadores.get(0).getCantidadPaises());
    }

    @Test
    public void realizarUnCanjeConDosCartasIgualesYUnaDistintaLevantaUnaExcepcion() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nicolas"), new Jugador("Felipe")));
        Juego juego = new Juego(jugadores);

<<<<<<< HEAD
        Carta carta1 = new Carta("Argentina", "Fiat Palio");
        Carta carta2 = new Carta("Brasil", "Globo");
        Carta carta3 = new Carta("Ecuador", "Globo");
=======
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Globo");
>>>>>>> 8c5cb631fd76a10d09d91d1e83d42c3be4a73cdf

        jugadores.get(0).darleCarta(carta1);
        jugadores.get(0).darleCarta(carta2);
        jugadores.get(0).darleCarta(carta3);

        assertThrows(SimbolosInvalidosException.class, () -> juego.canjearCartas(carta1, carta2, carta3) );
   }

    @Test
    public void intentarActivarUnaCartaYaActivadaLanzaUnaExcepcion() throws CartaYaActivadaException, PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, NoSePuedeActivarCartaEnLaBatallaException, PaisNoExisteException {
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Nicolas"), new Jugador("Felipe")));
        Juego juego = new Juego(jugadores);

<<<<<<< HEAD
        Carta carta = new Carta("Argentina", "Fiat Palio");
=======
        Carta carta = new CartaNoActivada("Argentina", "Fiat Palio");
>>>>>>> 8c5cb631fd76a10d09d91d1e83d42c3be4a73cdf

        Pais argentina = juego.buscarPais("Argentina");
        argentina.asignarDuenio(jugadores.get(0));

        jugadores.get(0).darleCarta(carta);
        juego.activarCarta(carta);

        assertThrows(CartaYaActivadaException.class, ()-> juego.activarCarta(carta));
    }
}