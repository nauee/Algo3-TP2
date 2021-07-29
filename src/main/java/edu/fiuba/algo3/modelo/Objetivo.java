package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Jugador;

public abstract class Objetivo {

    protected boolean objetivoComunCumplido (Jugador jugador) {
        return (jugador.conquistoMundo());
    }

    public abstract boolean cumplido(Jugador jugador);
}
