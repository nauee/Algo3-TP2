package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.etapa.Etapa;
import edu.fiuba.algo3.modelo.etapa.FaseColocacion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FaseColocacionTest {

    @Test
    public void EsPosibleColocarUnaCantidadValidaDeEjercitosEnUnPaisPropio() throws PaisNoTePerteneceException, FichasInsuficientesException {
        Pais pais1 = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais pais2 = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Pais pais3 = new Pais("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Bolivia")));
        Pais pais4 = new Pais("Bolivia", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Brasil")));
        Continente america = new Continente("America", 5);
        Jugador jugador1 = new Jugador("Pepe");
        Jugador jugador2 = new Jugador("Roberto");

        america.agregarPais(pais1);
        america.agregarPais(pais2);
        america.agregarPais(pais3);
        america.agregarPais(pais4);
        jugador1.agregarPais(pais1);
        jugador1.agregarPais(pais2);
        jugador1.agregarPais(pais3);
        jugador2.agregarPais(pais4);
        Etapa.asignarValores(new ArrayList<>(Arrays.asList(america)), new ArrayList<>(Arrays.asList(jugador1, jugador2)), new ArrayList<>());
        FaseColocacion fase = new FaseColocacion(jugador1);
        fase.jugar(1, pais1);

        assertEquals(1, pais1.getCantidadEjercitos());
    }

    @Test
    public void EsPosibleColocarUnaCantidadValidaConContinenteConquistadoDeEjercitosEnUnPaisPropio() throws PaisNoTePerteneceException, FichasInsuficientesException {
        Pais pais1 = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais pais2 = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Pais pais3 = new Pais("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Bolivia")));
        Pais pais4 = new Pais("Bolivia", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Brasil")));
        Continente america = new Continente("America", 5);
        Jugador jugador = new Jugador("Pepe");

        america.agregarPais(pais1);
        america.agregarPais(pais2);
        america.agregarPais(pais3);
        america.agregarPais(pais4);
        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);
        jugador.agregarPais(pais3);
        jugador.agregarPais(pais4);
        Etapa.asignarValores(new ArrayList<>(Arrays.asList(america)), new ArrayList<>(Arrays.asList(jugador)), new ArrayList<>());
        FaseColocacion fase = new FaseColocacion(jugador);
        fase.jugar(7, pais1);

        assertEquals(7, pais1.getCantidadEjercitos());
    }

    @Test
    public void NoEsPosibleColocarMasFichasDeLasDisponibles(){
        Pais pais1 = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais pais2 = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Pais pais3 = new Pais("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Bolivia")));
        Pais pais4 = new Pais("Bolivia", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Brasil")));
        Continente america = new Continente("America", 5);
        Jugador jugador = new Jugador("Pepe");

        america.agregarPais(pais1);
        america.agregarPais(pais2);
        america.agregarPais(pais3);
        america.agregarPais(pais4);
        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);
        jugador.agregarPais(pais3);
        jugador.agregarPais(pais4);
        Etapa.asignarValores(new ArrayList<>(Arrays.asList(america)), new ArrayList<>(Arrays.asList(jugador)), new ArrayList<>());
        FaseColocacion fase = new FaseColocacion(jugador);
        assertThrows(FichasInsuficientesException.class, () -> {
           fase.jugar(8, pais1);
        });
    }

    @Test
    public void NoEsPosibleColocarFichasEnUnPaisQueNoLePertenece(){
        Pais pais1 = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais pais2 = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Pais pais3 = new Pais("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Bolivia")));
        Pais pais4 = new Pais("Bolivia", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Brasil")));
        Continente america = new Continente("America", 5);
        Jugador jugador1 = new Jugador("Pepe");
        Jugador jugador2 = new Jugador("Roberto");

        america.agregarPais(pais1);
        america.agregarPais(pais2);
        america.agregarPais(pais3);
        america.agregarPais(pais4);
        jugador1.agregarPais(pais1);
        jugador1.agregarPais(pais2);
        jugador1.agregarPais(pais3);
        jugador2.agregarPais(pais4);
        Etapa.asignarValores(new ArrayList<>(Arrays.asList(america)), new ArrayList<>(Arrays.asList(jugador1, jugador2)), new ArrayList<>());
        FaseColocacion fase = new FaseColocacion(jugador1);
        assertThrows(PaisNoTePerteneceException.class, () -> {
            fase.jugar(1, pais4);
        });
    }

}
