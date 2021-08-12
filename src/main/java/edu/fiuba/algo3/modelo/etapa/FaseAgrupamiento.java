package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.MovimientoConCantidadInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLimitrofeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class FaseAgrupamiento implements Fase {

    private Jugador jugadorDeTurno;
    private final int origen = 0;
    private final int destino = 1;
    private final String nombre= "agrupamiento";

    public FaseAgrupamiento(Jugador jugadorDeTurno){
        this.jugadorDeTurno = jugadorDeTurno;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {
        Pais paisOrigen = paises[origen];
        Pais paisDestino = paises[destino];

        if(!jugadorDeTurno.tienePais(paisOrigen))
            throw new PaisNoTePerteneceException();

        paisOrigen.moverEjercitos(cantidadEjercitos, paisDestino);
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas){
        Jugador siguienteJugador = Etapa.siguienteJugador();
        return new FaseAtaque(siguienteJugador, cartas);
    }

    public String nombre() {
        return nombre;
    }
}

