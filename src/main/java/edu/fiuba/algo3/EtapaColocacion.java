package edu.fiuba.algo3;

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

    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3){
        jugadores.get(jugadorDeTurno-1).canjearCartas(carta1, carta2, carta3, cartas);
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
