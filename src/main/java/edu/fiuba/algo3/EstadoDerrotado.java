package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Jugador;

public class EstadoDerrotado implements EstadoJugador {
    private Jugador conquistador;
    @Override
    public boolean derrotadoPor(Jugador unJugador) {
        return unJugador == conquistador;
    }
}
