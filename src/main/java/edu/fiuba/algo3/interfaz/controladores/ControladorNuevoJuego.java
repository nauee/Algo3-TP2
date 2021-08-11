package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import edu.fiuba.algo3.interfaz.vistas.MenuBarra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorNuevoJuego implements EventHandler<ActionEvent> {

    Stage stage;
    MenuBarra menuArriba;

    public ControladorNuevoJuego(Stage stage, MenuBarra menuArriba){
        this.stage=stage;
        this.menuArriba=menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Button confirmar= new Button("Si");
        Button negar= new Button("No");

        VentanaConfirmacion confirmacion= new VentanaConfirmacion(stage, "crear un nuevo juego", confirmar, negar);
        negar.setOnAction(e-> confirmacion.close());
        confirmar.setOnAction(new ControladorVolverAlPrincipio(stage, menuArriba, confirmacion));
        confirmacion.initOwner(stage);
        confirmacion.show();
    }
}
