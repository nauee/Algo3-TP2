package edu.fiuba.algo3.modelo.objetivo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ObjetivoDestruccion extends Objetivo {

    private final Jugador jugadorADestruir;

    public ObjetivoDestruccion (Jugador jugadorADestruir) {
        this.jugadorADestruir = jugadorADestruir;
    }

    @Override
    public boolean cumplido(Jugador jugador) {
        return objetivoComunCumplido(jugador) || jugadorADestruir.derrotadoPor(jugador);
    }

    public Jugador getJugador(){
        return jugadorADestruir;
    }

    public boolean destruirA(Jugador jugador){
        return jugador.equals(jugadorADestruir);
    }

    public String getDescripcion(){
        return "Destruye a " + jugadorADestruir.getNombre();
    }
}