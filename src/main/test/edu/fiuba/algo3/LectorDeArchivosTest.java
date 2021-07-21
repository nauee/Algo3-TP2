package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorDeArchivosTest {

    @Test
    public void seLeenCorrectamenteLosNombresDeLosPaises() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDePaises("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = (ArrayList<Continente>) lector.obtener();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        assertEquals("Tartaria", (paises.get(0)).getNombre());
        assertEquals("Francia", (paises.get(1)).getNombre());
        assertEquals("Gran Bretaña", (paises.get(2)).getNombre());
    }

    @Test
    public void seLeenLasFronterasDeTresPaisesCorrectamente() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDePaises("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = (ArrayList<Continente>) lector.obtener();
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
    public void seLeenCorrectamenteLaCantidadDePaises() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDePaises("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = (ArrayList<Continente>) lector.obtener();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });
        assertEquals(3, paises.size());
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDeFronterasDeUnPais() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDePaises("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = (ArrayList<Continente>) lector.obtener();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        assertEquals(3, ((paises.get(0)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(1)).getLimitrofes()).size());
        assertEquals(3, ((paises.get(2)).getLimitrofes()).size());
    }

    @Test
    public void seLeenCorrectamenteLosPaisesDeLasCartas() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeCartas("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = (ArrayList<Carta>) lector.obtener();

        assertEquals("Francia", (cartas.get(0)).getPais());
        assertEquals("Gran Bretaña", (cartas.get(1)).getPais());
        assertEquals("Tartaria", (cartas.get(2)).getPais());
    }

    @Test
    public void seLeeLaCantidadCorrectaDeCartas() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeCartas("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = (ArrayList<Carta>) lector.obtener();

        assertEquals(3, cartas.size());
    }

    @Test
    public void seLeenCorrectamenteElSimboloDeUnaCarta() throws ParseException, IOException{
        LectorDeArchivos lector = new LectorDeCartas("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = (ArrayList<Carta>) lector.obtener();

        assertEquals("Globo", (cartas.get(0)).getSimbolo());
        assertEquals("Barco", (cartas.get(1)).getSimbolo());
        assertEquals("Cañon", (cartas.get(2)).getSimbolo());
    }
}