package edu.fiuba.algo3.modelo.excepciones;

public class PaisNoLimitrofeException extends Exception {
    public PaisNoLimitrofeException(){
        super("El pais no es limitrofe.");
    }
}
