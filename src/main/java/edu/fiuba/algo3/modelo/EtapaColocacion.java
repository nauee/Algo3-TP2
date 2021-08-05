package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;

public class EtapaColocacion extends Etapa{

    private FaseColocacion fase;

    public EtapaColocacion(){
        jugadorDeTurno = 0;
        fase = new FaseColocacion(jugadores.get(jugadorDeTurno));
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException {
        fase.jugar(cantidadEjercitos, paises);
    }

    @Override
    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3){
        int fichas = jugadores.get(jugadorDeTurno).canjearCartas(carta1, carta2, carta3, cartas);
        fase.agregarFichasDelCanje(fichas);
    }

    @Override
    public Etapa siguienteFase(){
        if (jugadorDeTurno == jugadores.size())
            return new EtapaBatalla();

        fase = (FaseColocacion) fase.siguienteFase(cartas);
        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta) throws CartaYaActivadaException {
        fase.activarCarta(unaCarta);
    }
}
