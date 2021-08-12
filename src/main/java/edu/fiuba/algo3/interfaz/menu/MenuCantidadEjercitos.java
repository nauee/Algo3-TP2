package edu.fiuba.algo3.interfaz.menu;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class MenuCantidadEjercitos extends VBox {

    Slider cantidades;


    public MenuCantidadEjercitos(String pregunta, int cantidad){
        mostrarSlide(pregunta, cantidad);
        if(cantidad<=0)
            mostrarError();
    }

    public int cantidadEjercitos(){
        return ((int)cantidades.getValue());
    }

    private void mostrarSlide(String pregunta, int cantidad){
        Label instruccion = new Label(pregunta);
        instruccion.setStyle("-fx-font-family: Gabriola; -fx-font-size: 25");
        cantidades = new Slider(0, cantidad, 0);
        cantidades.setBlockIncrement(1);
        cantidades.setShowTickLabels(true);
        cantidades.setMinorTickCount(0);
        cantidades.setMajorTickUnit(1);
        cantidades.setSnapToTicks(true);
        cantidades.setMinWidth(20);
        cantidades.setMinSize(50, 50);
        cantidades.setMaxWidth(450);
        cantidades.setStyle("-fx-font-size: 20");
        setSpacing(20);
        getChildren().addAll(instruccion, cantidades);
    }

    private void mostrarError(){
        Label mensaje = new Label("No hay ejercitos disponibles para jugar");
        mensaje.setStyle("-fx-font-family: Gabriola; -fx-font-size: 25");
        setSpacing(20);
        getChildren().addAll(mensaje);
    }

}
