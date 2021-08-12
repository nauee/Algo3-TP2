package edu.fiuba.algo3.modelo.excepciones;

public class AtaqueConCantidadInvalidaException extends Exception{

    public AtaqueConCantidadInvalidaException(){
        super("No puede atacar un pais con una cantidad invalida de ejércitos.");
    }
}