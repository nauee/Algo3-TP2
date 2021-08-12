package edu.fiuba.algo3.modelo.excepciones;

public class MovimientoConCantidadInvalidaException extends Exception{

    public MovimientoConCantidadInvalidaException(){
        super("No puede mover una cantidad invalida de ejércitos.");
    }

}
