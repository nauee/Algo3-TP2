package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.IOException;

//import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorDeArchivosTest {

    @Test
    public void seLeeUnArchivoDePaisesCorrectamente() throws ParseException, IOException {
        LectorDeArchivos lector = new LectorDeArchivos("src\\main\\test\\edu\\fiuba\\algo3\\archivos\\FronterasPrueba.json");
        ArrayList<Pais> paises = lector.getPaises();

        assertEquals("Francia",paises.get(0).getNombre());
        assertEquals("Europa", paises.get(0).getContinente());
        assertEquals("Gran Bretaña",paises.get(1).getNombre());
        assertEquals("Europa", paises.get(1).getContinente());

    }
}