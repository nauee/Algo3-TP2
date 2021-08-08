package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.VistaJugadores;
import edu.fiuba.algo3.interfaz.vistas.VistaMenuCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorMenuInicioJugar implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ControladorMenuInicioJugar(Stage stage){
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        VistaMenuCantidadJugadores menuJugadores = new VistaMenuCantidadJugadores(stage);
        Scene scene = new Scene(menuJugadores, 1280, 720);
        stage.setScene(scene);
    }

}
