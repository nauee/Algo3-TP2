package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonMediano extends Button{

    public BotonMediano(String nombre, String fuente, EventHandler<ActionEvent> controlador) {
        super();
        setText(nombre);
        setFont(new Font(fuente, 20));
        Background fondoNormal = new Background(new BackgroundFill(Color.valueOf("#B5884B"), new CornerRadii(5), Insets.EMPTY));
        Background fondoActivo = new Background(new BackgroundFill(Color.valueOf("#a37b43"), new CornerRadii(5), Insets.EMPTY));
        setStyle("-fx-border-color: #905A02; -fx-border-width: 4px 4px 4px 4px;-fx-text-alignment: center; -fx-border-radius: 5px");
        setBackground(fondoNormal);
        setOnMouseEntered(e -> setBackground(fondoActivo));
        setOnMouseExited(e -> setBackground(fondoNormal));
        setOnAction(controlador);
        setMaxWidth(150.0);
    }

}
