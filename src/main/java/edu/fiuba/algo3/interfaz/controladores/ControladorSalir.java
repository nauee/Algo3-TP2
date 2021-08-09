package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorSalir implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ControladorSalir(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}