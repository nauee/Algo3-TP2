package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;

import static java.lang.Math.min;

public class Juego {

    private int jugadorDeTurno;
    private int fase;
    static private final int ATAQUE = 1;
    static private final int REAGRUPACION = 2;
    static private final int JUGADORES_MAX = 6;
    private final ArrayList<Pais> paises;
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final ArrayList<Carta> cartas;

    public Juego(ArrayList<String> nombres) throws SeAlcanzoLaCantidadMaximaException,
            ParseException, IOException{
        for (int i = 0; i < nombres.size(); i++) {
            this.agregarJugador(new Jugador(nombres.get(i), i + 1));
        }
        LectorDeArchivos lectorDeArchivos = new LectorDeArchivos("src\\main\\java\\edu\\fiuba\\algo3\\archivos\\Teg - Fronteras.json");
        paises = lectorDeArchivos.getPaises();

        LectorDeArchivos lector = new LectorDeArchivos("src\\main\\java\\edu\\fiuba\\algo3\\archivos\\Teg - Cartas.json");
        cartas = lector.getCartas();
        jugadorDeTurno = 1;
        fase = ATAQUE;
    }

    public void agregarJugador(Jugador nuevoJugador) throws SeAlcanzoLaCantidadMaximaException {

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

    private Pais buscarPais(String unPais) throws PaisNoExisteException{
        int pos = -1, i = 0;

        while(i < paises.size() && pos == -1){
            if (unPais.equals(paises.get(i).getNombre())) {
                pos = i;
            }
            i++;
        }

        if (pos == -1) throw new PaisNoExisteException();
        return paises.get(pos);
    }

    public void atacarPais(String paisAtacante, String paisAtacado, int cantidadEjercitos)
            throws NoTePerteneceException, AtaqueAPaisPropioException, PaisNoExisteException,
            AtaqueConCantidadInvalidaException {

        Pais atacante = buscarPais(paisAtacante);
        Pais atacado = buscarPais(paisAtacado);
        Batalla batalla = new Batalla (atacado, atacante, cantidadEjercitos, jugadores.get(jugadorDeTurno-1));

        ArrayList<Integer> resultadosDadosAtacante = batalla.lanzarDados(min(cantidadEjercitos,3));
        ArrayList<Integer> resultadosDadosAtacado = batalla.lanzarDados(min(atacado.getCantidadEjercitos(), 3));
        batalla.batallar(resultadosDadosAtacado, resultadosDadosAtacante);
    }

    public int getCantidadPaises(){
        return (paises.size());
    }
    
    public int getCantidadCartas(){
        return (cartas.size());
    }
}