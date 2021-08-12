package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorBotonObjetivos implements EventHandler<ActionEvent> {


    private final String descripcionObjetivo;
    private final String rutaIcono= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/brujula.jpg";

    public ControladorBotonObjetivos(String descripcionObjetivo){
        this.descripcionObjetivo = descripcionObjetivo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Stage ventanaInformacion= new Stage();
        ventanaInformacion.setTitle("Objetivos");
        ventanaInformacion.initModality(Modality.APPLICATION_MODAL);

        ventanaInformacion.getIcons().add(new Image("file:"+System.getProperty("user.dir")+rutaIcono));
        AnchorPane objetivo= new AnchorPane();
        objetivo.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergaminoPapel.jpg"));
        Label texto= new Label(descripcionObjetivo);

        texto.setStyle("-fx-font-family: 'Book Antiqua'; -fx-font-size: 15; -fx-wrap-text: true; -fx-hgap: 2");
        texto.setMaxWidth(550);
        texto.setMaxHeight(550);
        texto.setTextAlignment(TextAlignment.CENTER);
        texto.setAlignment(Pos.CENTER);
        texto.setPadding(new Insets(25,25,25,25));

        objetivo.getChildren().add(texto);
        Scene informacionTexto= new Scene(objetivo, 400, 400);
        ventanaInformacion.setScene(informacionTexto);
        ventanaInformacion.show();
    }

}
