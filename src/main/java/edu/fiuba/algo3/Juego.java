package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.util.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.min;

public class Juego {

    static private final int JUGADORES_MAX = 6;

    private final int jugadorDeTurno;
    private Etapa etapa;
    private final Hashtable<String, Continente> continentes;
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final ArrayList<Carta> cartas;

    public Juego(ArrayList<String> nombres) throws SeAlcanzoLaCantidadMaximaException, ParseException, IOException, PaisNoTePerteneceException{

        for (int i = 0; i < nombres.size(); i++) {
            this.agregarJugador(new Jugador(nombres.get(i), i + 1));
        }

        LectorDeArchivos lectorDeArchivos = new LectorDePaises("src/main/java/edu/fiuba/algo3/archivos/Teg - Fronteras.json");
        continentes = (Hashtable<String, Continente>) lectorDeArchivos.obtener();

        LectorDeArchivos lector = new LectorDeCartas("src/main/java/edu/fiuba/algo3/archivos/Teg - Cartas.json");
        cartas = (ArrayList<Carta>) lector.obtener();

        jugadorDeTurno = 1;
        etapa = new EtapaReagrupacion(jugadores);

        distribuirPaises();
    }

    private void distribuirPaises() throws PaisNoTePerteneceException{

        ArrayList<Pais> paises = new ArrayList<>();
        continentes.forEach((nombreContinente, continente) -> {
            paises.addAll(continente.getPaises().values());
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

        Enumeration<Continente> continentes = this.continentes.elements();
        while (continentes.hasMoreElements() && paisBuscado == null) {
            paisBuscado = continentes.nextElement().getPais(unPais);
        }

        if (paisBuscado == null) throw new PaisNoExisteException();

        return paisBuscado;
    }

    public void jugar(int cantidadEjercitos, String... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, PaisNoExisteException {
        Pais pais1 = buscarPais(paises[0]);
        Pais pais2 = (paises.length > 1) ? buscarPais(paises[1]) : null;
        etapa.jugar(cantidadEjercitos, pais1, pais2);
    }

    public void pasarDeFase(){
        etapa = etapa.siguienteFase();
    }

    public int getCantidadPaises(){

        int cantidadPaises = 0;
        for (Map.Entry<String, Continente> entry : continentes.entrySet()) {
            cantidadPaises += entry.getValue().getCantidadPaises();
        }
        return cantidadPaises;
    }

    public int getCantidadFichas() {
        Jugador jugadorDeTurno = jugadores.get(this.jugadorDeTurno - 1);
        int fichas = jugadorDeTurno.getCantidadFichas();
        for (Map.Entry<String, Continente> entry : continentes.entrySet()) {
            fichas += entry.getValue().getRecompensa(jugadorDeTurno);
        }
        return fichas;
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    /*
    public void atacarPais(String continente, String paisAtacante, String paisAtacado, int cantidadEjercitos)
            throws PaisNoTePerteneceException, AtaqueAPaisPropioException, PaisNoExisteException,
            AtaqueConCantidadInvalidaException, PaisNoLimitrofeException, AtaqueEnFaseErroneaException{

        Pais atacante = buscarPais(paisAtacante);
        Pais atacado = buscarPais(paisAtacado);
        Batalla batalla = new Batalla (atacado, atacante, cantidadEjercitos, jugadores.get(jugadorDeTurno-1));

        ArrayList<Integer> resultadosDadosAtacante = batalla.lanzarDados(min(cantidadEjercitos,3));
        ArrayList<Integer> resultadosDadosAtacado = batalla.lanzarDados(min(atacado.getCantidadEjercitos(), 3));
        batalla.batallar(resultadosDadosAtacado, resultadosDadosAtacante);
    }
    */
    /*
    public void agregarEjercitos(String unPais, int cantidad) throws PaisNoExisteException, PaisNoTePerteneceException, ColocacionEnFaseErroneaException {
        if (fase != COLOCACION) {
            throw new ColocacionEnFaseErroneaException();
        }
        Pais pais = buscarPais(unPais);
        pais.agregarEjercitos(cantidad, jugadores.get(jugadorDeTurno - 1));
    }

    public int getCantidadCartas() {
        return cartas.size();
    }
    */
    /*
    public void reagruparEjercitos(String origen, String destino, int cantidad) throws PaisNoExisteException, PaisNoTePerteneceException, ReagruparEnFaseErroneaException, PaisNoLimitrofeException{
        Pais paisOrigen = buscarPais(origen);
        Pais paisDestino = buscarPais(destino);
        paisOrigen.moverEjercitos(cantidad, paisDestino);
    }
    */
}