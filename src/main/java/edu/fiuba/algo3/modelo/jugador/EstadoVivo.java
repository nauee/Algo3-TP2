package edu.fiuba.algo3.modelo.jugador;

public class EstadoVivo implements EstadoJugador {
    @Override
    public boolean derrotadoPor(Jugador unJugador) {
        return false;
    }

    @Override
    public boolean gano() {
        return false;
    }

    @Override
    public boolean perdio() {
        return false;
    }
}
