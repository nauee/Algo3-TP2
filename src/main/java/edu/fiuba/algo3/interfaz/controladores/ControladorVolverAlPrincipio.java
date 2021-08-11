package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorVolverAlPrincipio implements EventHandler<ActionEvent> {

    Stage stage;
    VentanaConfirmacion ventana;
    VistaInicio menuCantidad;

    public ControladorVolverAlPrincipio(Stage stage, MenuBarra menuArriba, VentanaConfirmacion ventana){
        this.ventana= ventana;
        this.stage=stage;
        this.menuCantidad = new VistaInicio(stage, menuArriba);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.close();
        Scene scene = new Scene(menuCantidad, 1280, 720);
        stage.setScene(scene);
    }
}
