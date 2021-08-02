package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends VBox{

    Stage stage;
    Juego juego;

    public VistaJuego(Stage stage, Juego juego){
        super();
        this.stage = stage;
        this.juego = juego;

        Image image = new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/interfaz/tableroteg.jpg");
        ImageView vista = new ImageView(image);
        vista.setCache(true);
        vista.setPreserveRatio(true);

        BorderPane pane = new BorderPane();

        VBox opciones = new VBox();
        Button colocar = new Button("Colocar");
        Button batalla = new Button("Batalla");
        Button reagrupar = new Button("Reagrupar");

        opciones.getChildren().addAll(colocar, batalla, reagrupar);
        pane.setRight(opciones);

        vista.fitWidthProperty().bind(stage.widthProperty());
        vista.fitHeightProperty().bind(stage.heightProperty());
        pane.setCenter(vista);
        this.getChildren().addAll(pane);
    }
}
