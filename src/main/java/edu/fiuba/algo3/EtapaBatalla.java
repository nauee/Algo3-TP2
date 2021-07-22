package edu.fiuba.algo3;

public class EtapaBatalla extends Etapa{

    private Fase fase;

    public EtapaBatalla(){
        jugadorDeTurno = 1;
        fase = new FaseAtaque(jugadores.get(jugadorDeTurno-1), cartas);
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public Etapa siguienteFase(){
        fase = fase.siguienteFase(cartas);
        if (jugadorDeTurno > jugadores.size())
            return new EtapaColocacion();
        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException {
        throw new NoSePuedeActivarCartaEnLaBatallaException();
    }

}
