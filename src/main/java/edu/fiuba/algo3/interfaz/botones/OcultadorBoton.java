package edu.fiuba.algo3.interfaz.botones;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class OcultadorBoton implements EventHandler<MouseEvent> {

    private final Button boton;

    public OcultadorBoton (Button boton){
        this.boton= boton;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setTextFill(Paint.valueOf("#B5884B00"));
        boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
    }
}
