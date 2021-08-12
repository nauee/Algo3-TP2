package edu.fiuba.algo3.modelo.excepciones;

public class NoSePudoLeerExcepcion extends Throwable {
    public NoSePudoLeerExcepcion(){
        super("No hay un lector implementado para su tipo de archivo.");
    }
}
