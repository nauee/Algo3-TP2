package edu.fiuba.algo3;

public class Pais{

    private String nombre;
    private int idJugador;

    public Pais(String nombre){
        this.nombre = nombre;
    }

    public void asignarJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public boolean lePerteneceA(int idJugador) {
        return (this.idJugador == idJugador);
    }

    public String getNombre(){
        return (this.nombre);
    }

}