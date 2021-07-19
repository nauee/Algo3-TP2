package edu.fiuba.algo3;

import java.util.ArrayList;

import static java.lang.Math.min;

class FaseAtaque implements Fase{

    @Override
    public void jugar(int cantidadEjercitos,Jugador jugador, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        Batalla batalla = new Batalla (paises[0], paises[1], cantidadEjercitos);
        batalla.batallar();
    }
    @Override
    public Fase siguienteEtapa(int jugadorActual, int cantidadDeJugadores){
        return (new FaseAgrupamiento());
    }
}



//ver parametros siguiente etapa
//como convencion primero seleccionamos el pais atacado y despues el atacante