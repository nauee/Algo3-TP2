package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vistas.VistaJuego;

public class ObservadorJuego implements Observador{

    private final VistaJuego vista;

    public ObservadorJuego(Observable juego, VistaJuego vista){
        this.vista= vista;
        juego.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        vista.actualizarCompleto();
    }
}
