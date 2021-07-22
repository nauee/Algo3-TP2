package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.util.*;
import java.io.IOException;

public class Juego {

    static private final int JUGADORES_MAX = 6;

    private final int jugadorDeTurno;
    private Etapa etapa;
    private final ArrayList<Continente> continentes;
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final ArrayList<Carta> cartas;

    public Juego(ArrayList<String> nombres) throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{
        for(String nombre: nombres){
            agregarJugador(new Jugador(nombre));
        }
        
        FachadaLector lector = new FachadaLector("json", "src/main/java/edu/fiuba/algo3/archivos/Teg - Fronteras.json");
        continentes = (ArrayList<Continente>) lector.obtenerPaises();

        lector.setTipoYRuta("json", "src/main/java/edu/fiuba/algo3/archivos/Teg - Cartas.json");
        cartas = (ArrayList<Carta>) lector.obtenerCartas();

        jugadorDeTurno = 1;
        Etapa.asignarValores(continentes, jugadores, cartas);
        etapa = new EtapaColocacion();

        distribuirPaises();
    }

    private void distribuirPaises() throws PaisNoTePerteneceException{
        ArrayList<Pais> paises = new ArrayList<>();
        continentes.forEach((continente) -> {
            paises.addAll(continente.getPaises());
        });

        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < paises.size(); i++){
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        for (int i = 0; i < numeros.size(); i++){
            int numeroJugador = i % jugadores.size();
            Pais pais = paises.get(i);
            Jugador jugador = jugadores.get(numeroJugador);
            jugador.agregarPais(pais);
            pais.agregarEjercitos(1, jugador);
        }
    }

    private void agregarJugador(Jugador nuevoJugador) throws SeAlcanzoLaCantidadMaximaException {
        if(jugadores.size() >= JUGADORES_MAX)
            throw new SeAlcanzoLaCantidadMaximaException();

        jugadores.add(nuevoJugador);
    }

    public Jugador getJugador(int posicion){
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

    public void jugar(int cantidadEjercitos, String... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, PaisNoExisteException, MovimientoConCantidadInvalidaException {
        Pais pais1 = buscarPais(paises[0]);
        Pais pais2 = (paises.length > 1) ? buscarPais(paises[1]) : null;
        etapa.jugar(cantidadEjercitos, pais1, pais2);
    }

    public void pasarDeFase(){
        etapa = etapa.siguienteFase();
    }

    public int getCantidadPaises(){
        int cantidadPaises = 0;
        for (Continente continente : continentes) {
            cantidadPaises += continente.getCantidadPaises();
        }
        return cantidadPaises;
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException, PaisNoTePerteneceException {
        etapa.activarCarta(unaCarta);
    }


}