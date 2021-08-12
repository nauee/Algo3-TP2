package edu.fiuba.algo3.modelo.excepciones;

public class AtaqueAPaisPropioException extends Exception{

    public AtaqueAPaisPropioException() {
        super("No puede atacar a un pais que le pertenece.");
    }
}
