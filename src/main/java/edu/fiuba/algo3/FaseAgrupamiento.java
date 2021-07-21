package edu.fiuba.algo3;

import java.util.ArrayList;

class FaseAgrupamiento implements Fase{

    private Jugador jugadorDeTurno;

    public FaseAgrupamiento(Jugador jugadorDeTurno){
        this.jugadorDeTurno = jugadorDeTurno;
    }
    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {
        Pais paisOrigen = paises[0];
        Pais paisDestino = paises[1];
        paisOrigen.moverEjercitos(cantidadEjercitos, paisDestino);
    }
    @Override
    public Fase siguienteFase(Jugador siguienteJugador, ArrayList<Carta> cartas){
        Etapa.siguienteJugador();
        return new FaseAtaque(siguienteJugador, cartas);
    }
}

