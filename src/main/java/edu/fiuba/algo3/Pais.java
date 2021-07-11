package edu.fiuba.algo3;

public class Pais{

    private final String nombre;
    private Jugador duenio;
    private int cantidadEjercitos;

    public Pais(String nombre){
        this.nombre = nombre;
        this.cantidadEjercitos = 0;
    }

    public void asignarDuenio(Jugador nuevoDuenio) {
        this.duenio = nuevoDuenio;
    }

    public void serConquistadoPor(Jugador conquistador) {
        this.duenio.perderPais(this);
        conquistador.agregarPais(this);
    }

    public void agregarEjercitos(int cantidadEjercitos) {
        this.cantidadEjercitos += cantidadEjercitos;
    }

    public String getNombre(){
        return (this.nombre);
    }

    public Jugador getDuenio(){
        return this.duenio;
    }

    public boolean lePerteneceA(Jugador unJugador) {
        return (this.duenio.equals(unJugador));
    }

    public int getCantidadEjercitos(){
        return this.cantidadEjercitos;
    }

    public void serAtacado(){
        this.cantidadEjercitos--;
    }

    public void moverEjercitos(int cantidadEjercitos, Pais destino){
        destino.agregarEjercitos(cantidadEjercitos);
        this.cantidadEjercitos -= cantidadEjercitos;
    }
}