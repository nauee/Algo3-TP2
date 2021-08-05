package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorMenuInicioJugar implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ControladorMenuInicioJugar(Stage stage){
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        VistaJugadores inicio = new VistaJugadores(stage);
        Scene scene = new Scene(inicio, 1280, 720);
        stage.setScene(scene);
    }

}
