package edu.fiuba.algo3;

import java.util.ArrayList;

public class EtapaColocacion extends Etapa{

    private FaseColocacion fase;

    public EtapaColocacion(){
        jugadorDeTurno = 1;
        fase = new FaseColocacion(jugadores.get(jugadorDeTurno-1));
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public Etapa siguienteFase(){
        if (jugadorDeTurno == jugadores.size())
            return new EtapaBatalla();
        fase = (FaseColocacion) fase.siguienteFase(cartas);
        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta){
        fase.activarCarta(unaCarta);
    }

}
