package edu.fiuba.algo3.modelo.excepciones;

public class FichasInsuficientesException extends Exception{

    public FichasInsuficientesException(){
        super("No puede colocar más ejércitos de los que tiene.");
    }

}