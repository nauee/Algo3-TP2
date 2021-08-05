package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaMenuInicio extends BorderPane {

    Stage stage;

    public VistaMenuInicio(Stage stage){
        super();
        this.stage=stage;
        Button jugar= new Button("Jugar");
        jugar.setStyle("-fx-font-size: 30px");
        jugar.prefHeight(25);
        jugar.prefWidth(274.0);

        Button salir= new Button("Salir");
        salir.setStyle("-fx-font-size: 30px");
        salir.prefHeight(25.0);
        salir.prefWidth(274.0);

        Button instrucciones= new Button("Instrucciones");
        instrucciones.setStyle("-fx-font-size: 30px");
        instrucciones.prefHeight(25.0);
        instrucciones.prefWidth(274.0);

        Label titulo= new Label("   A.L.T.E.G.O");
        titulo.setLayoutX(500);
        titulo.setLayoutY(56.0);
        titulo.prefHeight(112.0);
        titulo.prefWidth(274.0);
        Font fuenteTitulo= new Font("Gabriola", 120);
        titulo.setFont(fuenteTitulo);

        jugar.setMinWidth(300.0);
        salir.setMinWidth(300.0);
        instrucciones.setMinWidth(300.0);
        VBox menuPrincipal= new VBox();
        menuPrincipal.getChildren().addAll(jugar, instrucciones, salir);
        jugar.setOnAction(new ControladorMenuInicioJugar(stage));
        instrucciones.setOnAction(new ControladorMenuInicioInstrucciones(stage));
        salir.setOnAction(e->{stage.close();});

        Image image = new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/interfaz/fondoTEG.jpg");
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
        this.setTop(titulo);
        this.setCenter(menuPrincipal);
        titulo.setAlignment(Pos.TOP_CENTER);
        menuPrincipal.setAlignment(Pos.CENTER);
        menuPrincipal.setSpacing(10);

    }

}
