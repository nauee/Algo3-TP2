package edu.fiuba.algo3.interfaz;

public interface Observable {
    void agregarObservador(Observador nuevoObservador);
    void notificar();
}
