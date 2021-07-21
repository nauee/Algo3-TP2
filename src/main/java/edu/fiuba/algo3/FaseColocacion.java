package edu.fiuba.algo3;

class FaseColocacion implements Fase{
    private int fichasColocadas;
    private Jugador jugadorDeTurno;

    public FaseColocacion(Jugador jugadorDeTurno){
        fichasColocadas = 0;
        this.jugadorDeTurno = jugadorDeTurno;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoTePerteneceException, FichasInsuficientesException {
        if (jugadorDeTurno.getCantidadFichas() <= fichasColocadas + cantidadEjercitos) {
            throw new FichasInsuficientesException();
        }
        paises[0].agregarEjercitos(cantidadEjercitos, jugadorDeTurno);
        fichasColocadas += cantidadEjercitos;
    }

    @Override
    public Fase siguienteFase(Jugador siguienteJugador){
        return (new FaseColocacion(siguienteJugador));
    }

}
