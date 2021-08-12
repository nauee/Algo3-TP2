package edu.fiuba.algo3.modelo.excepciones;

public class PaisNoExisteException extends Exception{

    public PaisNoExisteException() {
        super("No existe el pais.");
    }
}