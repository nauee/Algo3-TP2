package edu.fiuba.algo3.modelo.excepciones;

public class SimbolosInvalidosException extends Exception {
    public SimbolosInvalidosException() {
        super("Solo se pueden canjear cartas con los mismos simbolos o con todos simbolos diferentes.");
    }
}
