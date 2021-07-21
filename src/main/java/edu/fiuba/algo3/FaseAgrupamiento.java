package edu.fiuba.algo3;

class FaseAgrupamiento implements Fase{

    private Jugador jugadorDeTurno;

    public FaseAgrupamiento(Jugador jugadorDeTurno){
        this.jugadorDeTurno = jugadorDeTurno;
    }
    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException {
        paises[0].moverEjercitos(cantidadEjercitos, paises[1]);
    }
    @Override
    public Fase siguienteFase(Jugador siguienteJugador){
        return new FaseAtaque(siguienteJugador);
    }
}


//el primer pais es el que provee los ejercitos y el segundo el que los recibe

