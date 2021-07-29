package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.lectura.FachadaLector;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LectorDeArchivosTest {

    @Test
    public void seLeenCorrectamenteLosNombresDeLosPaises() throws ParseException, IOException{
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = lector.obtenerPaises();
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
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = lector.obtenerPaises();
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
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = lector.obtenerPaises();
        ArrayList<Pais> paises = new ArrayList<>();

        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });
        assertEquals(3, paises.size());
    }

    @Test
    public void seLeenCorrectamenteLaCantidadDeFronterasDeUnPais() throws ParseException, IOException{
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/FronterasPrueba.json");
        ArrayList<Continente> continentes = lector.obtenerPaises();
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
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.obtenerCartas();

        assertEquals("Francia", (cartas.get(0)).getPais());
        assertEquals("Gran Bretaña", (cartas.get(1)).getPais());
        assertEquals("Tartaria", (cartas.get(2)).getPais());
    }

    @Test
    public void seLeeLaCantidadCorrectaDeCartas() throws ParseException, IOException{
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.obtenerCartas();

        assertEquals(3, cartas.size());
    }

    @Test
    public void seLeenCorrectamenteElSimboloDeUnaCarta() throws ParseException, IOException{
        FachadaLector lector = new FachadaLector("src/main/test/edu/fiuba/algo3/archivos/CartasPrueba.json");
        ArrayList<Carta> cartas = lector.obtenerCartas();

        assertEquals("Globo", (cartas.get(0)).getSimbolo());
        assertEquals("Barco", (cartas.get(1)).getSimbolo());
        assertEquals("Cañon", (cartas.get(2)).getSimbolo());
    }
}