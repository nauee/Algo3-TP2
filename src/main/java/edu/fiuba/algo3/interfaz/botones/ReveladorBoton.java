package edu.fiuba.algo3.interfaz.botones;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class ReveladorBoton implements EventHandler<MouseEvent> {

    private final Button boton;
    private final String color;

    public ReveladorBoton(Button boton, String color){
        this.boton= boton;
        this.color= color;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
        boton.setTextFill(Paint.valueOf("#000000"));
    }
}
