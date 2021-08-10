package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaConfirmacion extends Stage {

    public VentanaConfirmacion(Stage stage, String asunto, Button opcion1, Button opcion2){
        super();
        this.setTitle(asunto);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(stage);

        VBox confirmacion= new VBox();
        Text pregunta = new Text("¿Estas seguro que queres " + asunto + "?");
        HBox opciones= new HBox();
        opciones.getChildren().addAll(opcion1, opcion2);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);

        pregunta.setTextAlignment(TextAlignment.CENTER);
        confirmacion.setSpacing(20);

        confirmacion.getChildren().addAll(pregunta, opciones);
        Scene escenaConfirmacion= new Scene(confirmacion, 300, 200);
        this.setScene(escenaConfirmacion);
    }

}
