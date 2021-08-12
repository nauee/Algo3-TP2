package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.menu.MenuInicio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class VistaInicio extends VBox {

    Stage stage;
    private final String rutaImagenFondoMenu="/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";

    public VistaInicio(Stage stage, MenuBarra menuArriba){
        super();
        this.stage=stage;

        MenuInicio menu= new MenuInicio(stage, menuArriba);

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

        //centro.setTop(titulo);
        //centro.setCenter(menu);
        this.getChildren().addAll(menuArriba, titulo, menu);
        menu.setPadding(new Insets(30,10,0,10));
        titulo.setAlignment(Pos.TOP_CENTER);
    }

}
