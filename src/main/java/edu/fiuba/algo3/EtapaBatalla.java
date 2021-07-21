package edu.fiuba.algo3;

public class EtapaBatalla extends Etapa{

    private Fase fase;

    public EtapaBatalla(){
        fase = new FaseAtaque(jugadores.get(jugadorDeTurno-1), cartas);
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public Etapa siguienteFase(){
        if (jugadorDeTurno == jugadores.size())
            return new EtapaColocacion();
        fase = fase.siguienteFase(jugadores.get(jugadorDeTurno), cartas);
        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException {
        throw new NoSePuedeActivarCartaEnLaBatallaException();
    }
}
