package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CartaTest {

    @Test
    public void ActivarUnaCartaDeUnPaisQueTePerteneceFuncionaCorrectamente() {
        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil")));
        Carta carta = new Carta("Argentina", "Comodin");
        jugador.agregarPais(pais);
        jugador.darleCarta(carta);
        carta.activarse(new ArrayList<Pais>(Arrays.asList(pais)), jugador);
        assertEquals(2, pais.getCantidadEjercitos());
    }

    @Test
    public void NoSePuedeActivarUnaCartaDeUnPaisQueNoTePertenece() {
        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina")));
        Carta carta = new Carta("Argentina", "Comodin");
        jugador.agregarPais(pais);
        jugador.darleCarta(carta);
        carta.activarse(new ArrayList<Pais>(Arrays.asList(pais)), jugador);
        assertNotEquals(2, pais.getCantidadEjercitos());
    }


}
