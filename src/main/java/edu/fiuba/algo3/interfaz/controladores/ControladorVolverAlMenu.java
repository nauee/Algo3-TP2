package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorVolverAlMenu implements EventHandler<ActionEvent> {

    Stage stage;
    MenuBarra menuArriba;

    public ControladorVolverAlMenu(Stage stage, MenuBarra menuArriba){
        this.stage=stage;
        this.menuArriba = menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaInicio menuCantidad = new VistaInicio(stage, menuArriba);
        Scene scene = new Scene(menuCantidad, 1280, 720);
        stage.setScene(scene);
    }

}