package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

public class BotonPais {

    private final Button boton;

    public BotonPais(String nombre, int posicionX, int posicionY, int ancho, int alto, double rotacion){
        boton = new Button(nombre);
        boton.setLayoutX(posicionX);
        boton.setLayoutY(posicionY);
        boton.setPrefSize(ancho,alto);
        boton.setTextFill(Paint.valueOf("#B5884B00"));
        boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
        boton.setRotate(rotacion);
        boton.setOnMouseEntered(e-> {
            boton.setStyle("-fx-border-color: #B5884B;-fx-border-width: 2px 2px 2px 2px; -fx-background-color: #795523");
            boton.setTextFill(Paint.valueOf("#B5884B"));
        });
        boton.setOnMouseExited(e-> {
            boton.setTextFill(Paint.valueOf("#B5884B00"));
            boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
        });
    }

    public Button getBoton(){
        return boton;
    }
}
