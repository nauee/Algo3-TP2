package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Jugador;

public interface EstadoJugador {

    boolean derrotadoPor (Jugador unJugador);
    boolean gano();
    boolean perdio();
}
