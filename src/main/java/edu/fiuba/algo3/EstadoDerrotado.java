package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Jugador;

public class EstadoDerrotado implements EstadoJugador {
    private Jugador conquistador;

    public EstadoDerrotado(Jugador conquistador) {
        this.conquistador = conquistador;
    }

    @Override
    public boolean derrotadoPor(Jugador unJugador) {
        return unJugador == conquistador;
    }

    @Override
    public boolean gano() {
        return false;
    }

    @Override
    public boolean perdio() {
        return true;
    }
}
