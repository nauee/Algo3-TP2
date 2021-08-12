package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.excepciones.QuedanFichasPorColocarException;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class FaseColocacion implements Fase {
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
    public Fase siguienteFase(ArrayList<Carta> cartas) throws QuedanFichasPorColocarException {
        if(fichasDelJugador > fichasColocadas)
            throw new QuedanFichasPorColocarException();
        Jugador siguienteJugador= Etapa.siguienteJugador();
        return new FaseColocacion(siguienteJugador);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    public void activarCarta(Carta unaCarta) throws CartaYaActivadaException, PaisNoTePerteneceException{
        jugadorDeTurno.activarCarta(unaCarta);
    }

    public int getCantidadFichasDisponibles() {
        return fichasDelJugador - fichasColocadas;
    }

}
