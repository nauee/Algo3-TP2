package edu.fiuba.algo3.modelo.jugador;

public class EstadoGanador implements EstadoJugador {
    @Override
    public boolean derrotadoPor(Jugador unJugador) {
        return false;
    }

    @Override
    public boolean gano() {
        return true;
    }

    @Override
    public boolean perdio() {
        return false;
    }
}
