package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.Button;

public class BotonPais {

    private final Button boton;

    public BotonPais(String nombre, int posicionX, int posicionY, int ancho, int alto, double rotacion){
        boton = new Button(nombre);
        boton.setLayoutX(posicionX);
        boton.setLayoutY(posicionY);
        boton.setPrefSize(ancho,alto);
        boton.setRotate(rotacion);
    }

    public Button getBoton(){
        return boton;
    }
}
