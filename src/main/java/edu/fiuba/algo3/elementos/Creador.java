package edu.fiuba.algo3.elementos;

public interface Creador {
    Object crear(String pais, String[] datos);
    boolean esDeTipo(String tipo);
}