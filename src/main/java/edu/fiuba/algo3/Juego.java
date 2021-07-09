package edu.fiuba.algo3;

import java.util.ArrayList;

public class Juego{

    private int jugadorDeTurno;
    static private final int JUGADORES_MAX = 6;
    private ArrayList<Pais> paises = new ArrayList<Pais>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

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

    private Pais buscarPais(String pais) throws PaisNoExisteException{
        int pos = -1;
        for (Pais p : paises) {
            if (p.getNombre().equals(pais)) {
                pos = paises.indexOf(p);
            }
        }
        if (pos == -1)
            throw new PaisNoExisteException();
        return paises.get(pos);
    }

    public void atacarPais(String paisAtacante, String paisAtacado, int cantidadEjercitos) throws NoTePerteneceException, AtaqueAPaisPropioException, PaisNoExisteException {
        Pais atacante = this.buscarPais(paisAtacante);
        Pais atacado = this.buscarPais(paisAtacado);
        Batalla batalla = new Batalla (atacado, atacante, cantidadEjercitos, this.jugadorDeTurno);
    }
}