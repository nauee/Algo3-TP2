package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vistas.VistaJuego;

public class ObservadorPaisesSeleccionados implements Observador{


    private final VistaJuego vista;
    private final SupervisorJuego supervisorJuego;

    public ObservadorPaisesSeleccionados (SupervisorJuego supervisorJuego, VistaJuego vista){
        this.vista = vista;
        this.supervisorJuego = supervisorJuego;
        supervisorJuego.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        vista.actualizarInformacion();
    }
}
