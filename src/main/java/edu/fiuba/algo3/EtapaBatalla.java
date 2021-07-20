package edu.fiuba.algo3;

import java.util.ArrayList;

public class EtapaBatalla implements Etapa{

    private ArrayList<Jugador> jugadores;
    private Fase fase;
    private int jugadorDeTurno;

    public EtapaBatalla(ArrayList<Jugador> jugadores){
        jugadorDeTurno = 1;
        this.jugadores = jugadores;
        fase = new FaseAtaque(jugadores.get(jugadorDeTurno-1));
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public Etapa siguienteFase(){
        if (jugadorDeTurno == jugadores.size())
            return new EtapaReagrupacion(jugadores);
        fase = fase.siguienteFase(jugadores.get(jugadorDeTurno));
        jugadorDeTurno++;
        return this;
    }
}
