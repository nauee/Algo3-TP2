package edu.fiuba.algo3.interfaz.vistas;

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

public class VistaJugadores extends VBox {

    Stage stage;

    public VistaJugadores(Stage stage, int cantidad){
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

        Label tituloDeCuadroNombres = new Label("Agregar Nombres");
        tituloDeCuadroNombres.setTextFill(Paint.valueOf("#3c3c3c"));
        tituloDeCuadroNombres.setStyle("-fx-font-size: 25px");
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(0,0,25,0));

        Button inicioButton = new Button("Iniciar");
        inicioButton.setStyle("-fx-font-size: 30px");
        inicioButton.setOnAction(new ControladorInicio(stage, jugadores));
        inicioButton.setAlignment(Pos.CENTER);
        inicioButton.setStyle("-fx-background-color: #DBDBDF; -fx-font-size: 25px; -fx-text-fill: #3c3c3c; -fx-padding: 10px;");

        Image image = new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/fondoTEG.jpg");
        ImageView vista = new ImageView(image);
        AnchorPane imagenFondo = new AnchorPane();
        imagenFondo.getChildren().addAll(vista);
        vista.setFitHeight(695);
        vista.setFitWidth(1149);
        vista.setLayoutX(154);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo= new Background(fondoConImagen);
        this.setBackground(fondo);

        BorderPane border = new BorderPane();
        border.setTop(tituloDeCuadroNombres);
        border.setCenter(vboxNombres);
        border.setBottom(inicioButton);
        BorderPane.setAlignment(tituloDeCuadroNombres, Pos.CENTER);
        BorderPane.setAlignment(vboxNombres, Pos.CENTER);
        BorderPane.setAlignment(inicioButton, Pos.CENTER);
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(0,0,25,0));
        this.getChildren().addAll(border);
        this.setAlignment(Pos.CENTER);
    }
}