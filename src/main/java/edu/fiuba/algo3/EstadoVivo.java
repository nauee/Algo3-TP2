package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Jugador;

public class EstadoVivo implements EstadoJugador{
    @Override
    public boolean derrotadoPor(Jugador unJugador) {
        return false;
    }
}
