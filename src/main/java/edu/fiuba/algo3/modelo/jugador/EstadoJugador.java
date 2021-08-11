package edu.fiuba.algo3.modelo.jugador;

public interface EstadoJugador {

    boolean derrotadoPor (Jugador unJugador);
    boolean gano();
    boolean perdio();
}
