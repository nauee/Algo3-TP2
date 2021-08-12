package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorCancelarNuevoJuego implements EventHandler<ActionEvent>{

    private final Stage ventana;

    public ControladorCancelarNuevoJuego(Stage ventana){
        this.ventana=ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.close();
    }
}
