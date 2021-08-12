package edu.fiuba.algo3.modelo.logica;

import edu.fiuba.algo3.interfaz.Observable;
import edu.fiuba.algo3.interfaz.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.etapa.Etapa;
import edu.fiuba.algo3.modelo.etapa.PrimeraEtapaInicial;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.lectura.lector.LectorDeCartas;
import edu.fiuba.algo3.modelo.lectura.lector.LectorDeObjetivos;
import edu.fiuba.algo3.modelo.lectura.lector.LectorDePaises;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruccion;
import org.json.simple.parser.ParseException;

import java.util.*;
import java.io.IOException;

public class Juego implements Observable {

    static private final int JUGADORES_MAX = 6;

    private final ArrayList<Observador> observadores=new ArrayList<>();
    private Etapa etapa;
    private final ArrayList<Continente> continentes;
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Carta> cartas;
    private final ArrayList<Objetivo> objetivos;

    public Juego(ArrayList<Jugador> jugadores) throws ParseException, IOException, PaisNoTePerteneceException, NoSePudoLeerExcepcion, PaisNoExisteException {

        Jugador.reiniciarID();
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
        etapa = new PrimeraEtapaInicial();
    }

    private void distribuirObjetivos(){
        Collections.shuffle(objetivos);
        boolean objetivosValidos = true;
        for (int i = 0; i < jugadores.size(); i++){

            if (objetivos.get(i) instanceof ObjetivoDestruccion)
                if (((ObjetivoDestruccion)objetivos.get(i)).destruirA(jugadores.get(i)))
                    objetivosValidos = false;

            jugadores.get(i).agregarObjetivo(objetivos.get(i));
        }
        if (!objetivosValidos) distribuirObjetivos();
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
        etapa.jugar(cantidadEjercitos, paises);
        this.notificar();
    }

    public void pasarDeFase() throws QuedanFichasPorColocarException {
        etapa = etapa.siguienteFase();
        this.notificar();
    }

    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3) throws NoSePuedeCanjearEnEtapaBatallaException, SimbolosInvalidosException {
        if(!Carta.canjeables(carta1, carta2, carta3))
            throw new SimbolosInvalidosException();
        etapa.canjearCartas(carta1, carta2, carta3);
        this.notificar();
    }

    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException, CartaYaActivadaException {
        etapa.activarCarta(unaCarta);
        this.notificar();
    }

    public int getIdJugadorDeTurno() {
        return etapa.getIdJugadorDeTurno();
    }

    public Jugador getJugador(int index) {
        return jugadores.get(index);
    }

    public Jugador getJugadorDeTurno(){
        return (etapa.getJugadorDeTurno());
    }

    public String nombreFase(){
        return (etapa.nombreFase());
    }

    public ArrayList<Pais> paisesDeJugadorDeTurno(){
        return(etapa.paisesDeJugadorDeTurno());
    }

    public String getNombreJugadorDeTurno(){
        return (etapa.getNombreJugadorDeTurno());
    }

    public int getCantidadPaisesNecesarios() {
        return etapa.getCantidadPaisesNecesarios();
    }

    @Override
    public void agregarObservador(Observador nuevoObservador) {
        observadores.add(nuevoObservador);
    }

    @Override
    public void notificar() {
        for(Observador observador: observadores){
            observador.actualizar();
        }
    }

    public int getCantidadFichasDisponibles() {
        return etapa.getCantidadFichasDisponibles();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public String getObjetivoJugadorDeTurno(){
        return(getJugadorDeTurno().getObjetivoDescripcion());
    }

    public String getNombreFase(){
        return etapa.nombreFase();
    }

    public boolean hayGanador() {
        boolean hayGanador = false;
        for (Jugador jugador : jugadores) {
            if (jugador.gano()) hayGanador = true;
        }
        return hayGanador;
    }

    public Jugador getGanador() {
        Jugador ganador = null;
        for (Jugador jugador : jugadores) {
            if (jugador.gano()) ganador = jugador;
        }
        return ganador;
    }

}