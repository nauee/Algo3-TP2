package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjercitoTest {
    @Test
    public void asignoUnColorAlEjercitoYEsElCorrecto(){
        Ejercito ejercito = new Ejercito("Rojo");

        assertEquals("Rojo", ejercito.getColor());
    }
}
