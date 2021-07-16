package edu.fiuba.algo3;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Pais{

    private final String nombre;
    private Jugador duenio;
    private int cantidadEjercitos;
    private final ArrayList<String> limitrofes;

    public Pais(String nombre, ArrayList<String> limitrofes) {

        this.nombre = nombre;
        this.limitrofes= limitrofes;
        cantidadEjercitos = 0;
    }

    public void asignarDuenio(Jugador nuevoDuenio) {
        duenio = nuevoDuenio;
    }

    public void agregarEjercitos(int cantidadEjercitos, Jugador jugador) throws PaisNoTePerteneceException {
        if (!duenio.equals(jugador)) {
            throw new PaisNoTePerteneceException();
        }
        this.cantidadEjercitos += cantidadEjercitos;
    }

    public String getNombre(){
        return nombre;
    }

    public Jugador getDuenio(){
        return duenio;
    }

    public ArrayList<String> getLimitrofes(){
        return limitrofes;
    }

    public boolean lePerteneceA(Jugador unJugador) {
        return duenio.equals(unJugador);
    }

    public int getCantidadEjercitos(){
        return cantidadEjercitos;
    }

    public void serAtacado(){
        cantidadEjercitos--;
    }



    public void moverEjercitos(int cantidadEjercitos, Pais destino) throws  PaisNoTePerteneceException, PaisNoLimitrofeException{
        if (!destino.esLimitrofeCon(nombre))
            throw new PaisNoLimitrofeException();
        destino.agregarEjercitos(cantidadEjercitos, duenio);
        this.cantidadEjercitos -= cantidadEjercitos;
    }

    public Boolean esLimitrofeCon(String unPais){
        return limitrofes.contains(unPais);
    }

    public void serConquistadoPor(Pais paisConquistador){

        duenio.perderPais(this);
        paisConquistador.ganarleAPais(this);
    }

    public void ganarleAPais(Pais pais){
        duenio.agregarPais(pais);
    }

    public int defensores(){
        return min(cantidadEjercitos,3);
    }

    public int atacantes(int cantidadAtacantes) throws AtaqueConCantidadInvalidaException{
        if(cantidadEjercitos <= cantidadAtacantes)
            throw new AtaqueConCantidadInvalidaException();
        return min(cantidadEjercitos,3);
    }

}