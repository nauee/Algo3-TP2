package edu.fiuba.algo3.interfaz;


import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class VentanaConfirmacion extends VBox{

    public VentanaConfirmacion(String asunto,HBox opciones){
        super();
        Label pregunta = new Label("¿Estas seguro que queres " + asunto.toLowerCase() + "?");
        pregunta.setStyle("-fx-font-size: 25; -fx-font-family: Gabriola");
        pregunta.setTextAlignment(TextAlignment.CENTER);
        setSpacing(20);
        setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg"));
        getChildren().addAll(pregunta, opciones);
    }

}
