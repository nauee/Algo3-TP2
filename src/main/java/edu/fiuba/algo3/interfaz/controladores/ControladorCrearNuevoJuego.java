package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import edu.fiuba.algo3.interfaz.vistas.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaMenuCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorCrearNuevoJuego implements EventHandler<ActionEvent> {

    Stage stage;
    VentanaConfirmacion ventana;
    VistaMenuCantidadJugadores menuCantidad;

    public ControladorCrearNuevoJuego(Stage stage, MenuBarra menuArriba, VentanaConfirmacion ventana){
        this.ventana= ventana;
        this.stage=stage;
        this.menuCantidad = new VistaMenuCantidadJugadores(stage, menuArriba);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.close();
        Scene scene = new Scene(menuCantidad, 1280, 720);
        stage.setScene(scene);
    }
}
