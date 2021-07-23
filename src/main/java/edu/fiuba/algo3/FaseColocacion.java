package edu.fiuba.algo3;

import java.util.ArrayList;

class FaseColocacion implements Fase{
    private int fichasColocadas;
    private Jugador jugadorDeTurno;
    private int fichasDelJugador;

    public FaseColocacion(Jugador jugadorDeTurno){
        fichasColocadas = 0;
        this.jugadorDeTurno = jugadorDeTurno;
        fichasDelJugador = getCantidadFichas();
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoTePerteneceException, FichasInsuficientesException {
        if (fichasDelJugador < fichasColocadas + cantidadEjercitos) {
            throw new FichasInsuficientesException();
        }
        Pais pais = paises[0];
        pais.agregarEjercitos(cantidadEjercitos, jugadorDeTurno);
        fichasColocadas += cantidadEjercitos;
    }

    private int getCantidadFichas() {
        for (Continente continente : Etapa.continentes) {
            jugadorDeTurno.agregarEjercitos(continente.getRecompensa(jugadorDeTurno));
        }
        int fichas = jugadorDeTurno.getCantidadFichas();
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
