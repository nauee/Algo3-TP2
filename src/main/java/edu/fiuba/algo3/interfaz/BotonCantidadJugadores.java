package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.controladores.ControladorCantidadJugadores;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class BotonCantidadJugadores extends CheckBox {

    private final int cantidad;
    private final Stage stage;

    public BotonCantidadJugadores(Stage stage, int cantidad){
        super();
        this.cantidad=cantidad;
        this.stage=stage;
        this.setStyle("-fx-font-size: 30px; -fx-background-color: #000000");
        this.setOnAction(new ControladorCantidadJugadores(stage, cantidad));
    }
}