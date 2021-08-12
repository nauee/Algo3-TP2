package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.lectura.creador.CreadorDeCartas;
import edu.fiuba.algo3.modelo.lectura.creador.CreadorDeObjetivos;
import edu.fiuba.algo3.modelo.lectura.creador.CreadorDePaises;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruccion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreadorTest {
    @Test
    public void intentoCrearUnPaisYMeDevuelveLaInstanciaCorrecta(){
        ArrayList<String> fronteras = new ArrayList<>(List.of("Brasil", "Uruguay"));
        Pais pais = CreadorDePaises.crear("Argentina", fronteras);

        assertEquals("Argentina", pais.getNombre());
        assertEquals(fronteras, pais.getLimitrofes());
    }

    @Test
    public void intentoCrearUnaCartaYMeDevuelveLaInstanciaCorrecta() throws PaisNoExisteException {
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil", "Uruguay")));
        Continente americaDelSur = new Continente("America del Sur", 0);
        americaDelSur.agregarPais(argentina);
        Carta carta = CreadorDeCartas.crear("Argentina", "Mate", new ArrayList<>(List.of(americaDelSur)));

        assertEquals(argentina, carta.getPais());
        assertEquals("Mate", carta.getSimbolo());
    }

    @Test
    public void intentoCrearUnObjetivoDeTipoConquistaYMeDevuelveLaInstanciaCorrecta(){
        String[] arrayContinentes = {"America del Sur"};
        String[] arrayCantidades = {"1"};
        Continente americaDelSur =new Continente("America del Sur", 0);
        Objetivo objetivo = CreadorDeObjetivos.crear(arrayContinentes, arrayCantidades, new ArrayList<>(List.of(americaDelSur)));

        assertTrue(objetivo instanceof ObjetivoConquista);
        assertEquals(new ArrayList<>(List.of(1)), ((ObjetivoConquista) objetivo).getCantidades());
        assertEquals(new ArrayList<>(List.of(americaDelSur)), ((ObjetivoConquista) objetivo).getContinentes());
    }

    @Test
    public void intentoCrearUnObjetivoDeTipoDestruccionYMeDevuelveLaInstanciaCorrecta(){
        Jugador jugador = new Jugador("Fernando");
        Objetivo objetivo = CreadorDeObjetivos.crear(2, new ArrayList<>(List.of(jugador)));

        assertTrue(objetivo instanceof ObjetivoDestruccion);
        assertEquals(jugador, ((ObjetivoDestruccion) objetivo).getJugador());
    }

    @Test
    public void siElCreadorDeCartasRecibeUnContinenteSinElPaisCorrespondienteLanzaUnaExcepcion() throws PaisNoExisteException {
        Pais argentina = new Pais("Argentina", new ArrayList<>(List.of("Brasil", "Uruguay")));
        Continente americaDelSur = new Continente("America del Sur", 0);
        americaDelSur.agregarPais(argentina);

        assertThrows(PaisNoExisteException.class, () -> {
            CreadorDeCartas.crear("Iran", "Bomba", new ArrayList<>(List.of(americaDelSur)));
        });
    }
}