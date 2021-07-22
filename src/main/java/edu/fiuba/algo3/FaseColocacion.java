package edu.fiuba.algo3;

import java.util.ArrayList;

class FaseColocacion implements Fase{
    private int fichasColocadas;
    private Jugador jugadorDeTurno;

    public FaseColocacion(Jugador jugadorDeTurno){
        fichasColocadas = 0;
        this.jugadorDeTurno = jugadorDeTurno;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoTePerteneceException, FichasInsuficientesException {
        if (getCantidadFichas() < fichasColocadas + cantidadEjercitos) {
            throw new FichasInsuficientesException();
        }
        Pais pais = paises[0];
        pais.agregarEjercitos(cantidadEjercitos, jugadorDeTurno);
        fichasColocadas += cantidadEjercitos;
    }

    private int getCantidadFichas() {
        int fichas = jugadorDeTurno.getCantidadFichas();
        for (Continente continente : Etapa.continentes) {
            fichas += continente.getRecompensa(jugadorDeTurno);
        }
        return fichas;
    }

    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas){
        Jugador siguienteJugador= Etapa.siguienteJugador();
        return (new FaseColocacion(siguienteJugador));
    }

    public void activarCarta(Carta unaCarta) {
        jugadorDeTurno.activarCarta(unaCarta);
    }

}
