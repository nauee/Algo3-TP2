package edu.fiuba.algo3.modelo.objetivo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Objetivo {

    protected boolean objetivoComunCumplido(Jugador jugador) {
        return jugador.conquistoMundo();
    }

    public abstract boolean cumplido(Jugador jugador);

    public abstract String getDescripcion();
}
