package edu.fiuba.algo3.elementos;

public interface Creador {
    Object crear(Object... datos);
    boolean esDeTipo(String tipo);
}