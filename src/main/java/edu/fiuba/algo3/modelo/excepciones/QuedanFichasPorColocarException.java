package edu.fiuba.algo3.modelo.excepciones;

public class QuedanFichasPorColocarException extends Exception{
    public QuedanFichasPorColocarException(){
        super("No puede avanzar sin colocar todas las fichas.");
    }
}
