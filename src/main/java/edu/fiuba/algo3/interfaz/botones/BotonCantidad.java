package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class BotonCantidad extends CheckBox {

    private final int cantidad;


    public BotonCantidad(int cantidad){
        super();
        this.cantidad=cantidad;
        this.setStyle("-fx-font-size: 30px; -fx-background-color: #B5884B");

    }

    public int getCantidad(){
        return (this.cantidad);
    }

}