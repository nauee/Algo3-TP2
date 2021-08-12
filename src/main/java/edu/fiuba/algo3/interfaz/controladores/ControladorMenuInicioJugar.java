package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaMenuCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class ControladorMenuInicioJugar implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final MenuBarra menuBarra;

    public ControladorMenuInicioJugar(Stage stage, MenuBarra menuArriba){
        this.stage=stage;
        this.menuBarra=menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        VistaMenuCantidadJugadores menuJugadores = new VistaMenuCantidadJugadores(stage, menuBarra);
        Scene scene = new Scene(menuJugadores, 1280, 720);
        stage.setScene(scene);
    }

}
