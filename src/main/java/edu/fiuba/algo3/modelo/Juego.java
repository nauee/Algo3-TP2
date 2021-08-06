package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;
import edu.fiuba.algo3.lectura.LectorDeCartas;
import edu.fiuba.algo3.lectura.LectorDeObjetivos;
import edu.fiuba.algo3.lectura.LectorDePaises;
import org.json.simple.parser.ParseException;

import java.util.*;
import java.io.IOException;

public class Juego {

    static private final int JUGADORES_MAX = 6;

    private Etapa etapa;
    private final ArrayList<Continente> continentes;
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Carta> cartas;
    private final ArrayList<Objetivo> objetivos;

    public Juego(ArrayList<Jugador> jugadores) throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException, NoSePudoLeerExcepcion, PaisNoExisteException {

        if(jugadores.size() > JUGADORES_MAX)
            throw new SeAlcanzoLaCantidadMaximaException();

        this.jugadores = jugadores;

        LectorDePaises lectorPaises = new LectorDePaises();
        continentes = lectorPaises.leer("src/main/java/edu/fiuba/algo3/archivos/Teg - Fronteras.json");

        LectorDeCartas lectorCartas = new LectorDeCartas(continentes);
        cartas = lectorCartas.leer("src/main/java/edu/fiuba/algo3/archivos/Teg - Cartas.json");

        LectorDeObjetivos lectorObjetivos = new LectorDeObjetivos(continentes, jugadores);
        objetivos = lectorObjetivos.leer("src/main/java/edu/fiuba/algo3/archivos/Teg - Objetivos.json");

        distribuirPaises();
        distribuirObjetivos();
        Etapa.asignarValores(continentes, jugadores, cartas);
        etapa = new EtapaColocacion();
    }

    private void distribuirObjetivos(){
        Collections.shuffle(objetivos);
        for (int i = 0; i < jugadores.size(); i++)
            jugadores.get(i).agregarObjetivo(objetivos.get(i));
    }

    private void distribuirPaises() throws PaisNoTePerteneceException{
        ArrayList<Pais> paises = new ArrayList<>();
        continentes.forEach((continente) -> paises.addAll(continente.getPaises()));
        Collections.shuffle(paises);

        for(int i = 0; i < paises.size(); i++){
            Jugador jugador = jugadores.get(i % jugadores.size());
            Pais pais = paises.get(i);
            jugador.agregarPais(pais);
            pais.agregarEjercitos(1, jugadores.get(i % jugadores.size()));
        }
    }

    public Jugador get(int posicion){
        return jugadores.get(posicion);
    }

    public int getCantidadJugadores(){
        return jugadores.size();
    }

    public Pais buscarPais(String unPais) throws PaisNoExisteException{
        Pais paisBuscado = null;

        for (Continente continente : continentes){
            Pais posiblePais = continente.getPais(unPais);
            if (posiblePais != null)
                paisBuscado = posiblePais;
        }

        if (paisBuscado == null) throw new PaisNoExisteException();

        return paisBuscado;
    }

    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, PaisNoExisteException, MovimientoConCantidadInvalidaException {
        Pais pais1 = paises[0];
        Pais pais2 = (paises.length > 1) ? paises[1] : null;
        etapa.jugar(cantidadEjercitos, pais1, pais2);
    }

    public void pasarDeFase(){
        etapa = etapa.siguienteFase();
    }

    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3) throws NoSePuedeCanjearEnEtapaBatallaException, SimbolosInvalidosException {
        if(!Carta.canjeables(carta1, carta2, carta3))
            throw new SimbolosInvalidosException();
        etapa.canjearCartas(carta1, carta2, carta3);
    }

    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException, CartaYaActivadaException {
        etapa.activarCarta(unaCarta);
    }

    public int getJugadorDeTurno() {
        return etapa.getJugadorDeTurno();
    }

    public Jugador getJugador(int index) {
        return jugadores.get(index);
    }
}