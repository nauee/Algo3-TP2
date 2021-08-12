package edu.fiuba.algo3.modelo.geografia;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logica.Batalla;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Pais {

    private final String nombre;
    private Jugador duenio;
    private int cantidadEjercitos;
    private final ArrayList<String> limitrofes;
    private final int cantidadMaximaDeEjercitos = 3;

    public Pais(String nombre, ArrayList<String> limitrofes) {
        this.nombre = nombre;
        this.limitrofes = limitrofes;
        cantidadEjercitos = 0;
    }

    public void asignarDuenio(Jugador nuevoDuenio) {
        duenio = nuevoDuenio;
    }

    public void agregarEjercitos(int cantidadEjercitos, Jugador jugador) throws PaisNoTePerteneceException {
        if (!lePerteneceA(jugador)) {
            throw new PaisNoTePerteneceException();
        }

        this.cantidadEjercitos += cantidadEjercitos;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getDuenio() {
        return duenio;
    }

    public ArrayList<String> getLimitrofes() {
        return limitrofes;
    }

    public boolean lePerteneceA(Jugador unJugador) {
        return duenio.equals(unJugador);
    }

    public int getCantidadEjercitos() {
        return cantidadEjercitos;
    }

    public void serAtacado() {
        cantidadEjercitos--;
    }

    public void moverEjercitos(int cantidadEjercitos, Pais destino) throws PaisNoTePerteneceException, PaisNoLimitrofeException, MovimientoConCantidadInvalidaException {
        if (!destino.esLimitrofeCon(nombre))
            throw new PaisNoLimitrofeException();
        if (cantidadEjercitos >= this.cantidadEjercitos)
            throw new MovimientoConCantidadInvalidaException();

        destino.agregarEjercitos(cantidadEjercitos, duenio);
        this.cantidadEjercitos -= cantidadEjercitos;
    }

    public Boolean esLimitrofeCon(String unPais) {
        return limitrofes.contains(unPais);
    }

    public void serConquistadoPor(Pais paisConquistador) {
        Jugador conquistado = duenio;
        duenio.perderPais(this);
        paisConquistador.ganarleAPais(this);
        if (conquistado.seQuedoSinPaises()) conquistado.serDerrotadoPor(duenio);
    }

    public void ganarleAPais(Pais pais) {
        duenio.agregarPais(pais);
    }

    public int defensores() {
        return min(cantidadEjercitos, 3);
    }

    public int atacantes(int cantidadAtacantes) throws AtaqueConCantidadInvalidaException {
        if (cantidadEjercitos <= cantidadAtacantes)
            throw new AtaqueConCantidadInvalidaException();

        return min(cantidadAtacantes, cantidadMaximaDeEjercitos);
    }

    public void atacarPais(Pais paisAtacado, int cantidadEjercito, Jugador jugador) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {
        if (!lePerteneceA(jugador))
            throw new PaisNoTePerteneceException();
        if (cantidadEjercitos <= cantidadEjercito)
            throw new AtaqueConCantidadInvalidaException();

        Batalla batalla = new Batalla(paisAtacado, this, cantidadEjercito);
        batalla.batallar();
    }

    public boolean fueVencido() {
        return cantidadEjercitos <= 0;
    }

    public void conquistar(Pais paisConquistado) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {
        if (paisConquistado.fueVencido()) {
            paisConquistado.serConquistadoPor(this);
            moverEjercitos(1, paisConquistado);
        }
    }

    public boolean mismoDuenio(Pais pais) {
        return (pais.lePerteneceA(duenio));
    }

    public int getIdDuenio(){
        return duenio.getId();
    }
}

