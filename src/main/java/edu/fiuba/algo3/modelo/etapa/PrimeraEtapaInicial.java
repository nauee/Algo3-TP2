package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Pais;

public class PrimeraEtapaInicial extends Etapa{
    private FaseInicial fase;
    private final int fichasIniciales = 5;

    public PrimeraEtapaInicial(){
        jugadorDeTurno = 0;
        fase = new FaseInicial(jugadores.get(jugadorDeTurno), fichasIniciales);
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
    public String nombreFase() {
        return fase.nombre();
    }

    @Override
    public int getCantidadPaisesNecesarios() {
        return 1;
    }

    @Override
    public Etapa siguienteFase() throws QuedanFichasPorColocarException {
        fase = (FaseInicial) fase.siguienteFase(cartas);
        if (jugadorDeTurno >= jugadores.size())
            return new SegundaEtapaInicial();
        return this;
    }

    @Override
    public void activarCarta(Carta unaCarta) throws CartaYaActivadaException, PaisNoTePerteneceException{
        fase.activarCarta(unaCarta);
    }

    @Override
    public int getCantidadFichasDisponibles() {
        return fase.getCantidadFichasDisponibles();
    }

}
