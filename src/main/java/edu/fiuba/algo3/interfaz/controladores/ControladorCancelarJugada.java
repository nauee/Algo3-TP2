package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorCancelarJugada implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final SupervisorJuego supervisor;

    public ControladorCancelarJugada(SupervisorJuego supervisor, Stage stage){
        this.stage=stage;
        this.supervisor=supervisor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        supervisor.limpiar();
        stage.close();
    }
}
