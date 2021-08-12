package edu.fiuba.algo3.interfaz.botones;

import javafx.scene.control.CheckBox;

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