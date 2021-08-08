package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonMenuInicio extends Button{

    public BotonMenuInicio(String nombre, String fuente, double altura, double ancho , EventHandler<ActionEvent> controlador){
        super();
        this.setText(nombre);
        this.setStyle("-fx-font-size: 30px");
        this.prefHeight(25);
        this.prefWidth(274.0);
        this.setOnAction(controlador);
        this.setMinWidth(300.0);

    }


}
