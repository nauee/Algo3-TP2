package edu.fiuba.algo3;

import java.util.ArrayList;

class FaseAtaque implements Fase{
    private final Jugador jugadorDeTurno;
    private ArrayList<Carta> cartas;

    public FaseAtaque(Jugador jugadorDeTurno, ArrayList<Carta> cartas){
        this.jugadorDeTurno = jugadorDeTurno;
        this.cartas = cartas;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {
        Pais paisAtacante = paises[0];
        Pais paisAtacado = paises[1];
        paisAtacante.atacarPais(paisAtacado,cantidadEjercitos, jugadorDeTurno);
        if (paisAtacado.lePerteneceA(jugadorDeTurno))
            jugadorDeTurno.darleCarta(cartas.get(0));
            cartas.remove(0);
    }

    @Override
    public Fase siguienteFase(Jugador siguienteJugador, ArrayList<Carta> cartas){
        return (new FaseAgrupamiento(jugadorDeTurno));
    }
}