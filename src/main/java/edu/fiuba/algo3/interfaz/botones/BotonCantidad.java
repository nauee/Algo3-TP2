package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class BotonCantidad extends CheckBox {

    private final int cantidad;


    public BotonCantidad(int cantidad){
        super();
        this.cantidad=cantidad;
        this.setStyle("-fx-font-size: 30px; -fx-background-color: #000000");
    }

    public int getCantidad(){
        return (this.cantidad);
    }

}