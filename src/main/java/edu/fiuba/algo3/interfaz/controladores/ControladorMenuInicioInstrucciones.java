package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorMenuInicioInstrucciones implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ControladorMenuInicioInstrucciones(Stage stage){
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Stage ventanaInformacion= new Stage();
        ventanaInformacion.setTitle("Informacion");
        ventanaInformacion.initModality(Modality.APPLICATION_MODAL);
        ventanaInformacion.initOwner(stage);
        ventanaInformacion.getIcons().add(new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/imagenes/iconoInformacion.jpg"));
        AnchorPane instrucciones= new AnchorPane();
        instrucciones.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergaminoPapel.jpg"));
        //instrucciones.setStyle("-fx-background-color: #B5884B");
        Text texto= new Text("aca va la informacion del juego");
        texto.setStyle("-fx-font-family: Gabriola; -fx-font-size: 20");

        texto.setTextAlignment(TextAlignment.CENTER);
        instrucciones.getChildren().add(texto);
        Scene informacionTexto= new Scene(instrucciones, 500, 500);
        ventanaInformacion.setScene(informacionTexto);
        ventanaInformacion.show();
    }
}