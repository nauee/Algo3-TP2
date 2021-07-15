package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Hashtable;
//import java.util.Arrays;
//import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorDeArchivosTest {

    @Test
    public void seLeenCorrectamenteLosNombresDeLosPaises() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        Hashtable<String, Continente> continentes = lector.getContinentes();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((nombreContinente, continente) -> {
            paises.addAll(continente.getPaises().values());
        });

        assertEquals("Tartaria", (paises.get(0)).getNombre());
        assertEquals("Gran Bretaña", (paises.get(1)).getNombre());
        assertEquals("Francia", (paises.get(2)).getNombre());
    }

    @Test
    public void seLeenLasFronterasDeTresPaisesCorrectamente() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        Hashtable<String, Continente> continentes = lector.getContinentes();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((nombreContinente, continente) -> {
            paises.addAll(continente.getPaises().values());
        });

        String[] fronterasFrancia = {"Alemania","España","Italia"};
        String[] fronterasGB = {"Islandia","Alemania","España"};
        String[] fronterasTartaria = {"Aral","Taymir","Siberia"};

        assertArrayEquals((paises.get(0).getLimitrofes()).toArray(), fronterasTartaria);
        assertArrayEquals((paises.get(1).getLimitrofes()).toArray(), fronterasGB);
        assertArrayEquals((paises.get(2).getLimitrofes()).toArray(), fronterasFrancia);
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDePaises() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        Hashtable<String, Continente> continentes = lector.getContinentes();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((nombreContinente, continente) -> {
            paises.addAll(continente.getPaises().values());
        });
        assertEquals(3, paises.size());
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDeFronterasDeUnPais() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        Hashtable<String, Continente> continentes = lector.getContinentes();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((nombreContinente, continente) -> {
            paises.addAll(continente.getPaises().values());
        });

        assertEquals(3, ((paises.get(0)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(1)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(2)).getLimitrofes()).size());
    }

    @Test
    public void seLeenCorrectamenteLosPaisesDeLasCartas() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.getCartas();

        assertEquals("Francia", (cartas.get(0)).getPais());
        assertEquals("Gran Bretaña", (cartas.get(1)).getPais());
        assertEquals("Tartaria", (cartas.get(2)).getPais());
    }

    @Test
    public void seLeeLaCantidadCorrectaDeCartas() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.getCartas();

        assertEquals(3, cartas.size());
    }


    @Test
    public void seLeenCorrectamenteElSimboloDeUnaCarta() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeArchivos("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.getCartas();

        assertEquals("Globo", (cartas.get(0)).getSimbolo());
        assertEquals("Barco", (cartas.get(1)).getSimbolo());
        assertEquals("Cañon", (cartas.get(2)).getSimbolo());
    }
}