package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.excepciones.QuedanFichasPorColocarException;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;

public class FaseInicial implements Fase {
    private int fichasColocadas;
    private final Jugador jugadorDeTurno;
    private final String nombre= "colocacion";
    private final int fichasIniciales;
    private int fichasDelJugador = 0;

    public FaseInicial(Jugador jugadorDeTurno, int cantidadDeFichas){
        this.fichasIniciales = cantidadDeFichas;
        fichasColocadas = 0;
        this.jugadorDeTurno = jugadorDeTurno;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoTePerteneceException, FichasInsuficientesException {
        if(fichasIniciales < fichasColocadas + cantidadEjercitos)
            throw new FichasInsuficientesException();

        Pais pais = paises[0];
        pais.agregarEjercitos(cantidadEjercitos, jugadorDeTurno);
        fichasColocadas += cantidadEjercitos;
    }

    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas) throws QuedanFichasPorColocarException {
        if(fichasIniciales > fichasColocadas)
            throw new QuedanFichasPorColocarException();
        Jugador siguienteJugador= Etapa.siguienteJugador();
        return new FaseInicial(siguienteJugador, fichasIniciales);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    public void activarCarta(Carta unaCarta) throws CartaYaActivadaException, PaisNoTePerteneceException{
        jugadorDeTurno.activarCarta(unaCarta);
    }

    public void agregarFichasDelCanje(int fichas){
        fichasDelJugador += fichas;
    }

    public int getCantidadFichasDisponibles() {
        return fichasIniciales - fichasColocadas;
    }

}
