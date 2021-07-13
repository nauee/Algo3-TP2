package edu.fiuba.algo3;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Juego{

    private int jugadorDeTurno;
    static private final int JUGADORES_MAX = 6;
    private final ArrayList<Pais> paises = new ArrayList<>();
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final ArrayList<Pais> mapa = new ArrayList<>();

    public void agregarJugador(Jugador nuevoJugador) throws SeAlcanzoLaCantidadMaximaException {

        if(jugadores.size() >= JUGADORES_MAX)
            throw new SeAlcanzoLaCantidadMaximaException();

        this.jugadores.add(nuevoJugador);
    }

    public Jugador getJugador(int posicion){
        return this.jugadores.get(posicion);
    }

    public int getCantidadJugadores(){
        return this.jugadores.size();
    }

    private Pais buscarPais(String unPais) throws PaisNoExisteException{
        int pos = -1;
        for (Pais pais : paises) {
            if (pais.getNombre().equals(unPais)) {
                pos = paises.indexOf(pais);
            }
        }
        if (pos == -1)
            throw new PaisNoExisteException();
        return paises.get(pos);
    }

    public void atacarPais(String paisAtacante, String paisAtacado, int cantidadEjercitos) throws NoTePerteneceException, AtaqueAPaisPropioException, PaisNoExisteException, AtaqueConCantidadInvalidaException {
        Pais atacante = this.buscarPais(paisAtacante);
        Pais atacado = this.buscarPais(paisAtacado);
        Batalla batalla = new Batalla (atacado, atacante, cantidadEjercitos, jugadores.get(jugadorDeTurno-1));

        ArrayList<Integer> resultadosDadosAtacante = batalla.lanzarDados(min(cantidadEjercitos,3));
        ArrayList<Integer> resultadosDadosAtacado = batalla.lanzarDados(min(atacado.getCantidadEjercitos(), 3));
        batalla.batallar(resultadosDadosAtacado, resultadosDadosAtacante);
    }
}