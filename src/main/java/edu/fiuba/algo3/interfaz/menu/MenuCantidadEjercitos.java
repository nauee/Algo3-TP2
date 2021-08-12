package edu.fiuba.algo3.interfaz.menu;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuCantidadEjercitos extends VBox {

    Slider cantidades;

    public MenuCantidadEjercitos(String pregunta, int cantidad){
        Text instruccion = new Text(pregunta);
        cantidades = new Slider(0,cantidad,0);
        cantidades.setBlockIncrement(1);
        cantidades.setShowTickLabels(true);
        cantidades.setMinorTickCount(0);
        cantidades.setMajorTickUnit(1);
        cantidades.setSnapToTicks(true);
        cantidades.setMinWidth(20);
        cantidades.setMinSize(20, 20);
        getChildren().addAll(instruccion, cantidades);

    }

    public int cantidadEjercitos(){
        return ((int)cantidades.getValue());
    }

}
