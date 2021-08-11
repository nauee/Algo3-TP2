package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.modelo.geografia.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonPais implements EventHandler<ActionEvent> {

    private final SupervisorJuego supervisorJuego;
    private final Pais pais;

    public ControladorBotonPais(Pais pais, SupervisorJuego supervisorJuego){
        this.supervisorJuego = supervisorJuego;
        this.pais= pais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        supervisorJuego.agregarPais(pais);
    }
}
