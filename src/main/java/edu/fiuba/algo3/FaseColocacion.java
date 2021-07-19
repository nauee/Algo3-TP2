package edu.fiuba.algo3;

class FaseColocacion implements Fase{
    private int fichasColocadas;
    @Override

    public FaseColocacion(){
        fichasColocadas = 0;
    }

    public void jugar(int cantidadEjercitos, Jugador jugador, Pais... paises) throws PaisNoTePerteneceException {
        if (jugador.getCantidadFichas() <= fichasColocadas + cantidadEjercitos) {
            throw new FichasInsuficientesException();
        }
        paises[0].agregarEjercitos(cantidadEjercitos, jugador);
        fichasColocadas += cantidadEjercitos;
    }
    @Override
    public Fase siguienteEtapa(int jugadorActual, int cantidadDeJugadores){

        return (new FaseAtaque());
    }

}
