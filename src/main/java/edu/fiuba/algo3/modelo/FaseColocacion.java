package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class FaseColocacion implements Fase{
    private int fichasColocadas;
    private final Jugador jugadorDeTurno;
    private int fichasDelJugador;
    private final String nombre= "colocacion";

    public FaseColocacion(Jugador jugadorDeTurno){
        fichasColocadas = 0;
        this.jugadorDeTurno = jugadorDeTurno;
        fichasDelJugador = getCantidadFichas();
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoTePerteneceException, FichasInsuficientesException {
        if(fichasDelJugador < fichasColocadas + cantidadEjercitos)
            throw new FichasInsuficientesException();

        Pais pais = paises[0];
        pais.agregarEjercitos(cantidadEjercitos, jugadorDeTurno);
        fichasColocadas += cantidadEjercitos;
    }

    private int getCantidadFichas() {
        int fichasDelJugador = jugadorDeTurno.getCantidadFichasPorPais();
        for(Continente continente : Etapa.continentes)
            fichasDelJugador += continente.getRecompensa(jugadorDeTurno);
        return fichasDelJugador;
    }

    public void agregarFichasDelCanje(int fichas){
        fichasDelJugador += fichas;
    }

    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas){
        Jugador siguienteJugador= Etapa.siguienteJugador();
        return new FaseColocacion(siguienteJugador);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    public void activarCarta(Carta unaCarta) throws CartaYaActivadaException {
        jugadorDeTurno.activarCarta(unaCarta);
    }
}
