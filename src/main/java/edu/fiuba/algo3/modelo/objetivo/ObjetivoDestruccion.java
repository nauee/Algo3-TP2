package edu.fiuba.algo3.modelo.objetivo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;

public class ObjetivoDestruccion extends Objetivo {

    private final Jugador jugadorADestruir;

    public ObjetivoDestruccion (Jugador jugadorADestruir) {
        this.jugadorADestruir = jugadorADestruir;
    }

    @Override
    public boolean cumplido(Jugador jugador) {
        return objetivoComunCumplido(jugador) || jugadorADestruir.derrotadoPor(jugador);
    }
}