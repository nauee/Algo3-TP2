package edu.fiuba.algo3.modelo.excepciones;

public class NoSePuedeCanjearEnEtapaBatallaException extends Exception{
    public NoSePuedeCanjearEnEtapaBatallaException(){
        super("Solo se pueden canjear cartas en fase colocacion.");
    }
}
