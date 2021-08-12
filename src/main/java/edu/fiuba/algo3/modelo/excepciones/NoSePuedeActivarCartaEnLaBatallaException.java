package edu.fiuba.algo3.modelo.excepciones;

public class NoSePuedeActivarCartaEnLaBatallaException extends Exception{

    public NoSePuedeActivarCartaEnLaBatallaException(){
        super("Solo se puede activar una carta en la fase Colocacion.");
    }
}