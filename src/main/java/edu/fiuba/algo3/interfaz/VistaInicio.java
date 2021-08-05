package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class VistaInicio extends VBox {

    Stage stage;

    public VistaInicio(Stage stage){
        super();
        this.stage = stage;

        ArrayList<TextField> jugadores = new ArrayList<>();

        Label Ljugador1 = new Label("Nombre Jugador 1");
        Ljugador1.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador1,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador1 = new TextField("");
        areaTextoNombreJugador1.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador1 = new HBox();
        HBnombreJugador1.getChildren().addAll(Ljugador1, areaTextoNombreJugador1);
        HBnombreJugador1.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador1);

        Label Ljugador2 = new Label("Nombre Jugador 2");
        Ljugador2.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador2,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador2 = new TextField("");
        areaTextoNombreJugador2.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador2 = new HBox();
        HBnombreJugador2.getChildren().addAll(Ljugador2, areaTextoNombreJugador2);
        HBnombreJugador2.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador2);

        Label Ljugador3 = new Label("Nombre Jugador 3");
        Ljugador3.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador3,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador3 = new TextField("");
        areaTextoNombreJugador3.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador3 = new HBox();
        HBnombreJugador3.getChildren().addAll(Ljugador3, areaTextoNombreJugador3);
        HBnombreJugador3.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador3);

        Label Ljugador4 = new Label("Nombre Jugador 4");
        Ljugador4.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador4,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador4 = new TextField("");
        areaTextoNombreJugador4.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador4 = new HBox();
        HBnombreJugador4.getChildren().addAll(Ljugador4, areaTextoNombreJugador4);
        HBnombreJugador4.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador4);

        Label Ljugador5 = new Label("Nombre Jugador 5");
        Ljugador5.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador5,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador5 = new TextField("");
        areaTextoNombreJugador5.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador5 = new HBox();
        HBnombreJugador5.getChildren().addAll(Ljugador5, areaTextoNombreJugador5);
        HBnombreJugador5.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador5);

        Label Ljugador6 = new Label("Nombre Jugador 6");
        Ljugador6.setStyle("-fx-font-size: 15px");
        HBox.setMargin(Ljugador6,new Insets(0,25,0,0));
        TextField areaTextoNombreJugador6 = new TextField("");
        areaTextoNombreJugador6.setStyle("-fx-background-color: #DBDBDF; -fx-border-color: #FFFFFF;-fx-font-size: 30px");
        HBox HBnombreJugador6 = new HBox();
        HBnombreJugador6.getChildren().addAll(Ljugador6, areaTextoNombreJugador6);
        HBnombreJugador6.setAlignment(Pos.CENTER);
        jugadores.add(areaTextoNombreJugador6);

        VBox vboxNombres = new VBox();
        vboxNombres.getChildren().addAll(HBnombreJugador1, HBnombreJugador2, HBnombreJugador3, HBnombreJugador4, HBnombreJugador5, HBnombreJugador6);
        vboxNombres.setAlignment(Pos.CENTER);
        vboxNombres.setStyle("-fx-font-family: Arial Unicode MS");
        vboxNombres.setStyle("-fx-font-weight: bold");
        VBox.setMargin(HBnombreJugador1,new Insets(0,0,5,0));
        VBox.setMargin(HBnombreJugador2,new Insets(0,0,5,0));
        VBox.setMargin(HBnombreJugador3,new Insets(0,0,5,0));
        VBox.setMargin(HBnombreJugador4,new Insets(0,0,5,0));
        VBox.setMargin(HBnombreJugador5,new Insets(0,0,5,0));
        VBox.setMargin(HBnombreJugador6,new Insets(0,0,5,0));

        Label tituloDeCuadroNombres = new Label("Agregar Nombres");
        tituloDeCuadroNombres.setTextFill(Paint.valueOf("#3c3c3c"));
        tituloDeCuadroNombres.setStyle("-fx-font-size: 25px");
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(0,0,25,0));

        Button inicioButton = new Button("Iniciar");
        inicioButton.setStyle("-fx-font-size: 30px");
        ControladorInicio controladorInicio = new ControladorInicio(stage, jugadores);
        inicioButton.setOnAction(controladorInicio);
        inicioButton.setAlignment(Pos.CENTER);
        inicioButton.setStyle("-fx-background-color: #DBDBDF; -fx-font-size: 25px; -fx-text-fill: #3c3c3c; -fx-padding: 10px;");

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
