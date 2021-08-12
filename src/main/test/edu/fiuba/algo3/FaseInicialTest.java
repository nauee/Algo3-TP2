package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.etapa.Etapa;
import edu.fiuba.algo3.modelo.etapa.FaseColocacion;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.excepciones.QuedanFichasPorColocarException;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FaseInicialTest {

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
    public void NoEsPosiblePasarDeFaseTeniendoFichasDisponibles() throws PaisNoTePerteneceException, FichasInsuficientesException {
        Pais pais1 = new Pais("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Uruguay", "Bolivia")));
        Pais pais2 = new Pais("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Bolivia")));
        Pais pais3 = new Pais("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Bolivia")));
        Pais pais4 = new Pais("Bolivia", new ArrayList<>(Arrays.asList("Argentina", "Uruguay", "Brasil")));
        Continente america = new Continente("America", 5);
        Jugador jugador = new Jugador("Pepe");
        ArrayList<Carta> cartas = new ArrayList<>();

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
        fase.jugar(2, pais1);
        assertThrows(QuedanFichasPorColocarException.class, () -> {
            fase.siguienteFase(cartas);
        });
    }
}
