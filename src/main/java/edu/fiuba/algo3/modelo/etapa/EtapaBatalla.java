package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EtapaBatalla extends Etapa {

    private Fase fase;

    public EtapaBatalla(){
        jugadorDeTurno = 0;
        fase = new FaseAtaque(jugadores.get(jugadorDeTurno), cartas);
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public Etapa siguienteFase() throws QuedanFichasPorColocarException {
        fase = fase.siguienteFase(cartas);
        if (jugadorDeTurno >= jugadores.size())
            return new EtapaColocacion();

        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta) throws NoSePuedeActivarCartaEnLaBatallaException {
        throw new NoSePuedeActivarCartaEnLaBatallaException();
    }

    @Override
    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3) throws NoSePuedeCanjearEnEtapaBatallaException {
        throw new NoSePuedeCanjearEnEtapaBatallaException();
    }

    @Override
    public String nombreFase(){
        return fase.nombre();
    }

    @Override
    public int getCantidadPaisesNecesarios() {
        return 2;
    }

    public int getCantidadFichasDisponibles() {
        return 0;
    }

}
