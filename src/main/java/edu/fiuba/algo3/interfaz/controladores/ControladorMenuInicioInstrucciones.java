package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
        AnchorPane instrucciones= new AnchorPane();
        Text texto= new Text("aca va la informacion del juego");
        texto.setX(20);
        texto.setY(20);
        instrucciones.getChildren().add(texto);
        Scene informacionTexto= new Scene(instrucciones, 300, 200);
        ventanaInformacion.setScene(informacionTexto);
        ventanaInformacion.show();
    }
}