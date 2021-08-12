package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.lectura.lector.LectorDeObjetivos;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.lectura.lector.LectorDeCartas;
import edu.fiuba.algo3.modelo.lectura.lector.LectorDePaises;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruccion;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LectorDeArchivosTest {

    @Test
    public void seLeenCorrectamenteLosNombresDeLosPaises() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lector = new LectorDePaises();
        ArrayList<Continente> continentes = lector.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        assertEquals("Tartaria", (paises.get(0)).getNombre());
        assertEquals("Francia", (paises.get(1)).getNombre());
        assertEquals("Gran Bretaña", (paises.get(2)).getNombre());
    }

    @Test
    public void seLeenLasFronterasDeTresPaisesCorrectamente() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lector = new LectorDePaises();
        ArrayList<Continente> continentes = lector.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        String[] fronterasGB = {"Islandia","Alemania","España"};
        String[] fronterasFrancia = {"Alemania","España","Italia"};
        String[] fronterasTartaria = {"Aral","Taymir","Siberia"};

        assertArrayEquals((paises.get(0).getLimitrofes()).toArray(), fronterasTartaria);
        assertArrayEquals((paises.get(1).getLimitrofes()).toArray(), fronterasFrancia);
        assertArrayEquals((paises.get(2).getLimitrofes()).toArray(), fronterasGB);
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDePaises() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lector = new LectorDePaises();
        ArrayList<Continente> continentes = lector.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });
        assertEquals(3, paises.size());
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDeFronterasDeUnPais() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lector = new LectorDePaises();
        ArrayList<Continente> continentes = lector.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        assertEquals(3, ((paises.get(0)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(1)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(2)).getLimitrofes()).size());
    }

    @Test
    public void seLeenCorrectamenteLosPaisesDeLasCartas() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lectorPaises = new LectorDePaises();
        ArrayList<Continente> continentes = lectorPaises.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");

        ArrayList<Pais> paises = new ArrayList<>();
        continentes.forEach((continente)->{
            paises.addAll(continente.getPaises());
        });

        Pais francia = paises.get(0);
        Pais granBretania = paises.get(1);
        Pais tartaria = paises.get(2);

        LectorDeCartas lectorCartas = new LectorDeCartas(continentes);
        ArrayList<Carta> cartas = lectorCartas.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/CartasPrueba.json");

        assertEquals(granBretania, (cartas.get(0)).getPais());
        assertEquals(tartaria, (cartas.get(1)).getPais());
        assertEquals(francia, (cartas.get(2)).getPais());
    }

    @Test
    public void seLeeLaCantidadCorrectaDeCartas() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lectorPaises = new LectorDePaises();
        ArrayList<Continente> continentes = lectorPaises.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        LectorDeCartas lectorCartas = new LectorDeCartas(continentes);
        ArrayList<Carta> cartas = lectorCartas.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/CartasPrueba.json");

        assertEquals(3, cartas.size());
    }

    @Test
    public void seLeenCorrectamenteElSimboloDeUnaCarta() throws ParseException, IOException, NoSePudoLeerExcepcion, PaisNoExisteException {
        LectorDePaises lectorPaises = new LectorDePaises();
        ArrayList<Continente> continentes = lectorPaises.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/FronterasPrueba.json");
        LectorDeCartas lectorCartas = new LectorDeCartas(continentes);
        ArrayList<Carta> cartas = lectorCartas.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/CartasPrueba.json");

        assertEquals("Globo", (cartas.get(0)).getSimbolo());
        assertEquals("Barco", (cartas.get(1)).getSimbolo());
        assertEquals("Cañon", (cartas.get(2)).getSimbolo());
    }

    @Test
    public void seLeenCorrectamenteLosObjetivos() throws NoSePudoLeerExcepcion, PaisNoExisteException, IOException, ParseException {
        LectorDePaises lectorPaises = new LectorDePaises();
        ArrayList<Continente> continentes = lectorPaises.leer("src/main/java/edu/fiuba/algo3/recursos/archivos/Teg - Fronteras.json");
        Jugador fernando = new Jugador("Fernando");
        Jugador nahuel = new Jugador("Nahuel");
        Jugador nicolas = new Jugador("Nicolas");
        Jugador agustina = new Jugador("Agustina");
        Jugador rosario = new Jugador("Rosario");
        ArrayList<Jugador> jugadores = new ArrayList<>(List.of(fernando, nahuel, nicolas, agustina, rosario));
        LectorDeObjetivos lectorObjetivos = new LectorDeObjetivos(continentes, jugadores);
        ArrayList<Objetivo> objetivos = lectorObjetivos.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/ObjetivosPrueba.json");

        assertTrue(objetivos.get(0) instanceof ObjetivoConquista);
        assertTrue(objetivos.get(1) instanceof ObjetivoConquista);
        assertTrue(objetivos.get(2) instanceof ObjetivoConquista);
        assertTrue(objetivos.get(3) instanceof ObjetivoDestruccion);
        assertTrue(objetivos.get(4) instanceof ObjetivoDestruccion);
        assertTrue(objetivos.get(5) instanceof ObjetivoDestruccion);
        assertEquals(6, objetivos.size());
    }

    @Test
    public void enviarUnArchivoDeUnTipoNoImplementadoAlLectorDePaisesLanzaUnaExcepcion(){
        LectorDePaises lectorPaises = new LectorDePaises();
        assertThrows(NoSePudoLeerExcepcion.class, ()->{
            lectorPaises.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/Paises.csv");
        });
    }

    @Test
    public void enviarUnArchivoDeUnTipoNoImplementadoAlLectorDeCartasLanzaUnaExcepcion(){
        LectorDeCartas lectorCartas = new LectorDeCartas(new ArrayList<>(List.of(new Continente("America", 0))));

        assertThrows(NoSePudoLeerExcepcion.class, ()->{
            lectorCartas.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/Paises.csv");
        });
    }

    @Test
    public void enviarUnArchivoDeUnTipoNoImplementadoAlLectorDeObjetivosLanzaUnaExcepcion(){
        LectorDeObjetivos lectorObjetivos = new LectorDeObjetivos(
                new ArrayList<>(List.of(new Continente("America", 0))),
                new ArrayList<>(List.of(new Jugador("Nicolas")))
        );

        assertThrows(NoSePudoLeerExcepcion.class, ()->{
            lectorObjetivos.leer("src/main/test/edu/fiuba/algo3/recursos/archivos/Paises.csv");
        });
    }
}