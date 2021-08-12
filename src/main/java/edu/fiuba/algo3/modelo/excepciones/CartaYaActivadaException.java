package edu.fiuba.algo3.modelo.excepciones;

public class CartaYaActivadaException extends Throwable {
    public CartaYaActivadaException(){
        super("No puede activar una carta ya activada.");
    }
}
