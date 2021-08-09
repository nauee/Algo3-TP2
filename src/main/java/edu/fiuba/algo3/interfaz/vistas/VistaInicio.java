package edu.fiuba.algo3.interfaz.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicio extends BorderPane {

    Stage stage;
    private final String rutaImagenFondoMenu="/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";

    public VistaInicio(Stage stage){
        super();
        this.stage=stage;

        MenuInicio menu= new MenuInicio(stage);

        Label titulo= new Label("   A.L.T.E.G.O");
        titulo.setLayoutX(500);
        titulo.setLayoutY(56.0);
        titulo.prefHeight(112.0);
        titulo.prefWidth(274.0);
        Font fuenteTitulo= new Font("Gabriola", 120);
        titulo.setFont(fuenteTitulo);

        Image imagen = new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoMenu);
        BackgroundImage fondoConImagen= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo= new Background(fondoConImagen);
        this.setBackground(fondo);
        this.setTop(titulo);
        this.setCenter(menu);
        titulo.setAlignment(Pos.TOP_CENTER);
    }

}
