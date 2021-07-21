package edu.fiuba.algo3;

class FaseAtaque implements Fase{
    private final Jugador jugadorDeTurno;

    public FaseAtaque(Jugador jugadorDeTurno){
        this.jugadorDeTurno = jugadorDeTurno;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException {
        paises[0].atacarPais(paises[1],cantidadEjercitos, jugadorDeTurno);
    }

    @Override
    public Fase siguienteFase(Jugador siguienteJugador){
        return (new FaseAgrupamiento(siguienteJugador));
    }
}



//ver parametros siguiente etapa
//como convencion primero seleccionamos el pais atacado y despues el atacante