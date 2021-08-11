package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.Imagen;
import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class BotonGrande extends Button{

    private final String rutaImagenFondo= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public BotonGrande(String nombre, String fuente, EventHandler<ActionEvent> controlador){
        super();
        this.setText(nombre);
        this.setBackground(ImagenFondo.fondoJuego(rutaImagenFondo));
        this.setFont(new Font(fuente, 40));
        this.setStyle("-fx-border-color: #905A02; -fx-border-width: 4px 4px 4px 4px;-fx-text-alignment: center");
        this.setOnMouseEntered(e->this.setMinWidth(400.0));
        this.setOnMouseExited(e->this.setMinWidth(300.0));
        this.setOnAction(controlador);
        this.setMinWidth(300.0);
    }


}
