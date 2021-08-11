package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaMenuCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorVolver implements EventHandler<ActionEvent> {

    Stage stage;
    MenuBarra menu;

    public ControladorVolver(Stage stage, MenuBarra menu){
        this.stage=stage;
        this.menu= menu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaMenuCantidadJugadores menuJugadores = new VistaMenuCantidadJugadores(stage, menu);
        Scene scene = new Scene(menuJugadores, 1280, 720);
        stage.setScene(scene);
    }
}
