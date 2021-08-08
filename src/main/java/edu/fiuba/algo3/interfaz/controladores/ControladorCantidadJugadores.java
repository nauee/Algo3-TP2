package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.VistaJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorCantidadJugadores implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final int cantidad;

    public ControladorCantidadJugadores(Stage stage, int cantidad) {
        this.stage = stage;
        this.cantidad=cantidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaJugadores jugadores = new VistaJugadores(stage, cantidad);
        Scene scene = new Scene(jugadores, 1280, 720);
        stage.setScene(scene);

    }
}
