package edu.fiuba.algo3;

class FaseAgrupamiento implements Fase{
    @Override
    public void jugar(int cantidadEjercitos, Jugador jugador, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException {
        paises[0].moverEjercitos(cantidadEjercitos, paises[1]);
    }
    @Override
    public Fase siguienteEtapa(int jugadorActual, int cantidadDeJugadores){
        return ((jugadorActual==cantidadDeJugadores) ? new FaseColocacion() : new FaseAtaque());
    }
}


//el primer pais es el que provee los ejercitos y el segundo el que los recibe

