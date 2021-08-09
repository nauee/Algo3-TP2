package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.ImagenFondo;
import edu.fiuba.algo3.interfaz.controladores.ControladorInicio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaJugadores extends BorderPane {

    Stage stage;
    private final String rutaImagenFondoCentro= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";
    private final String rutaImagenFondo= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";

    public VistaJugadores(Stage stage, int cantidad, MenuBarra menuArriba){
        super();
        this.stage = stage;

        ArrayList<TextField> jugadores = new ArrayList<>();
        VBox vboxNombres = new VBox();

        for(int i=1;i<=cantidad;i++){
            Label lJugador = new Label("Nombre Jugador" + i);
            lJugador.setStyle("-fx-font-size: 15px");
            HBox.setMargin(lJugador,new Insets(0,25,0,0));
            TextField areaTextoNombreJugador = new TextField("");
            areaTextoNombreJugador.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
            HBox HBnombreJugador = new HBox();
            HBnombreJugador.getChildren().addAll(lJugador, areaTextoNombreJugador);
            HBnombreJugador.setAlignment(Pos.CENTER);
            jugadores.add(areaTextoNombreJugador);
            vboxNombres.getChildren().add(HBnombreJugador);
        }

        vboxNombres.setAlignment(Pos.CENTER);
        vboxNombres.setStyle("-fx-font-family: Gabriola");
        vboxNombres.setStyle("-fx-font-weight: bold");
        vboxNombres.setSpacing(10);

        Label tituloDeCuadroNombres = new Label(" Agregar Nombres");
        tituloDeCuadroNombres.setTextFill(Paint.valueOf("#3c3c3c"));
        tituloDeCuadroNombres.setStyle("-fx-font-size: 25px");
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(0,0,0,0));

        Button inicioButton = new Button("Iniciar");
        inicioButton.setStyle("-fx-font-size: 30px");
        inicioButton.setOnAction(new ControladorInicio(stage, jugadores));
        inicioButton.setAlignment(Pos.CENTER);
        inicioButton.setStyle("-fx-background-color: #DBDBDF; -fx-font-size: 25px; -fx-text-fill: #3c3c3c; -fx-padding: 10px;");

        this.setBackground(ImagenFondo.fondoTotal(rutaImagenFondo));

        VBox nombres= new VBox();
        nombres.getChildren().addAll(tituloDeCuadroNombres, vboxNombres, inicioButton);
        nombres.setAlignment(Pos.CENTER);
        nombres.setSpacing(20);
        nombres.setBackground(ImagenFondo.fondoParcial(rutaImagenFondoCentro));
        this.setTop(menuArriba);
        this.setCenter(nombres);
    }
}