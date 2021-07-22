package edu.fiuba.algo3;

import java.util.ArrayList;

class FaseAgrupamiento implements Fase{

    private Jugador jugadorDeTurno;
    private final int origen = 0;
    private final int destino = 1;

    public FaseAgrupamiento(Jugador jugadorDeTurno){
        this.jugadorDeTurno = jugadorDeTurno;
    }
    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {
        Pais paisOrigen = paises[origen];
        Pais paisDestino = paises[destino];
        paisOrigen.moverEjercitos(cantidadEjercitos, paisDestino);
    }
    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas){
        Jugador siguienteJugador= Etapa.siguienteJugador();
        return new FaseAtaque(siguienteJugador, cartas);
    }
}

