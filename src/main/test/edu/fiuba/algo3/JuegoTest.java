package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.CartaNoActivada;
import edu.fiuba.algo3.elementos.Dado;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;
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
    public void seCreaUnJuegoConUnJugadorCorrecto() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Rosario")));
        assertEquals("Rosario", juego.getJugador(0).getNombre());
    }

    @Test
    public void seCreaUnJuegoConDosJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Fernando", "Nicolas")));
        assertEquals(2, juego.getCantidadJugadores());
    }

    @Test
    public void seCreaUnJuegoCon50Paises() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadPaises());
    }

    @Test
    public void seCreaUnJuegoCon50Cartas() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Agustina", "Rosario")));
        assertEquals(50, juego.getCantidadCartas());
    }


    @Test
    public void seDistribuyenCorrectamenteLosPaisesEntreJugadores() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException {

        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Rosario", "Agustina", "Nahuel", "Fernando")));
        boolean funciona = true;
        int i = 0;

        while(funciona && i < juego.getCantidadJugadores()) {

            funciona = juego.getJugador(i).getCantidadPaises() == 10;
            i++;
        }

        assertTrue(funciona);
    }

    @Test
    public void agregarEjercitosAUnPaisInexistenteLanzaUnaExcepcion() throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nahuel", "Fernando")));
        assertThrows(PaisNoExisteException.class, () -> {
           juego.jugar(1, "Chipre");
        });
    }


    @Test
    public void rondaDosJugadoresColocarEjercitosNuevos() throws PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe")));
        Pais argentina=juego.buscarPais("Argentina");
        Pais brasil=juego.buscarPais("Brasil");

        argentina.asignarDuenio(juego.getJugador(0));
        brasil.asignarDuenio(juego.getJugador(1));

        juego.jugar(3, "Argentina");
        juego.pasarDeFase();
        juego.jugar(3, "Brasil");
        juego.pasarDeFase();

        //Pasa de fase sin atacar ni reagrupar y vuelve a la fase colocacion

        //ataca y reagrupa jugador 1
        juego.pasarDeFase();
        juego.pasarDeFase();

        //ataca y reagrupa jugador 2
        juego.pasarDeFase();
        juego.pasarDeFase();

        juego.jugar(1, "Argentina");
        juego.pasarDeFase();
        juego.jugar(2, "Brasil");

        assertEquals(argentina.getCantidadEjercitos(), 5);
        assertEquals(brasil.getCantidadEjercitos(), 6);
    }

   @Test
    public void juegoDeUnaRonda3JugadoresUnoControlaAsiaSeAgreganNuevosEjercitos() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
       Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe", "Agustina")));

       //El segundo jugador posee toda Asia
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

       tartaria.asignarDuenio(juego.getJugador(1));
       mongolia.asignarDuenio(juego.getJugador(1));
       kamtchatka.asignarDuenio(juego.getJugador(1));
       turquia.asignarDuenio(juego.getJugador(1));
       iran.asignarDuenio(juego.getJugador(1));
       israel.asignarDuenio(juego.getJugador(1));
       taymir.asignarDuenio(juego.getJugador(1));
       aral.asignarDuenio(juego.getJugador(1));
       siberia.asignarDuenio(juego.getJugador(1));
       japon.asignarDuenio(juego.getJugador(1));
       gobi.asignarDuenio(juego.getJugador(1));
       arabia.asignarDuenio(juego.getJugador(1));
       india.asignarDuenio(juego.getJugador(1));
       china.asignarDuenio(juego.getJugador(1));
       malasia.asignarDuenio(juego.getJugador(1));

       Pais brasil = juego.buscarPais("Brasil");
       Pais argentina = juego.buscarPais("Argentina");
       Pais islandia = juego.buscarPais("Islandia");
       Pais alemania = juego.buscarPais("Alemania");

       brasil.asignarDuenio(juego.getJugador(0));
       argentina.asignarDuenio(juego.getJugador(0));
       islandia.asignarDuenio(juego.getJugador(2));
       alemania.asignarDuenio(juego.getJugador(2));

       juego.jugar(3, "Brasil");
       juego.pasarDeFase();
       juego.jugar(2, "China");
       juego.pasarDeFase();
       juego.jugar(1, "Alemania");
       juego.pasarDeFase();

       //No se ataca ni reagrupa
       juego.pasarDeFase();
       juego.pasarDeFase();

       juego.pasarDeFase();
       juego.pasarDeFase();

       juego.pasarDeFase();
       juego.pasarDeFase();

       //

       juego.pasarDeFase();

       //jugador 2 puede agregar mas ejercitos debido a la recompensa por tener Asia
       juego.jugar((juego.getJugador(1).getCantidadFichasPorPais())+7, "China");
       assertEquals(juego.getJugador(1).getCantidadFichasPorPais()+10 ,china.getCantidadEjercitos());

   }

   @Test
   public void juegoDeUnaRondaDe2JugadoresJugador1Conquista2PaisesDeJugador2() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, PaisNoExisteException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException, AtaqueConCantidadInvalidaException, FichasInsuficientesException, AtaqueAPaisPropioException {
       PowerMockito.mockStatic(Dado.class);
       PowerMockito.when(Dado.lanzar(anyInt())).thenReturn(new ArrayList<>(Arrays.asList(6,6,6)),new ArrayList<>(Arrays.asList(1,1,1)),new ArrayList<>(Arrays.asList(6,6,6)),new ArrayList<>(Arrays.asList(1,1,1)));

        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe")));
        Pais argentina = juego.buscarPais("Argentina");
        Pais brasil = juego.buscarPais("Brasil");
        Pais chile = juego.buscarPais("Chile");
        argentina.asignarDuenio(juego.getJugador(0));
        int cantidadPaisesPrevioAtacar = juego.getJugador(0).getCantidadPaises();
        brasil.asignarDuenio(juego.getJugador(1));
        chile.asignarDuenio(juego.getJugador(1));
        //fase colocacion primer jguador
        juego.jugar(11, "Argentina");
        juego.pasarDeFase();
        //colocacion segundo
        juego.pasarDeFase();
        //ataque primero
        juego.jugar(10,"Argentina","Brasil");
        juego.jugar(8,"Argentina","Chile");
        assertEquals(cantidadPaisesPrevioAtacar+2, juego.getJugador(0).getCantidadPaises());
    }

    @Test
    public void realizarUnCanjeConDosCartasIgualesYUnaDistintaLevantaUnaExcepcion() throws PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe")));
        Carta carta1 = new CartaNoActivada("Argentina", "Fiat Palio");
        Carta carta2 = new CartaNoActivada("Brasil", "Globo");
        Carta carta3 = new CartaNoActivada("Ecuador", "Globo");
        juego.getJugador(0).darleCarta(carta1);
        juego.getJugador(0).darleCarta(carta2);
        juego.getJugador(0).darleCarta(carta3);

        assertThrows(SimbolosInvalidosException.class, () -> juego.canjearCartas(carta1, carta2, carta3) );
   }

    @Test
    public void intentarActivarUnaCartaYaActivadaLanzaUnaExcepcion() throws CartaYaActivadaException, PaisNoTePerteneceException, ParseException, IOException, SeAlcanzoLaCantidadMaximaException, NoSePuedeActivarCartaEnLaBatallaException, PaisNoExisteException {
        Juego juego = new Juego(new ArrayList<>(Arrays.asList("Nicolas", "Felipe")));
        Carta carta = new CartaNoActivada("Argentina", "Fiat Palio");
        Pais argentina = juego.buscarPais("Argentina");
        argentina.asignarDuenio(juego.getJugador(0));
        juego.getJugador(0).darleCarta(carta);
        juego.activarCarta(carta);
        assertThrows(CartaYaActivadaException.class, ()->{
            juego.activarCarta(carta);
        });
    }
}