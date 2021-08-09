package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.BotonCantidadJugadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class VistaMenuCantidadJugadores extends BorderPane {

    private final Stage stage;
    private final int MaxJugadores=6;
    private final String rutaImagenFondoMenu= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";
    private final String rutaImagenFondoCentro= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public VistaMenuCantidadJugadores(Stage stage) {
        this.stage = stage;

        ImageView fondo = new ImageView(new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoMenu));
        fondo.fitHeightProperty().bind(this.heightProperty());
        fondo.fitWidthProperty().bind(this.widthProperty());



        this.getChildren().add(fondo);
        Text pregunta= new Text("\n   Por favor, selecciona la cantidad de jugadores:");
        pregunta.setTextAlignment(TextAlignment.CENTER);
        pregunta.setY(50);
        BorderPane.setAlignment(pregunta, Pos.TOP_CENTER);
        pregunta.setFont(new Font("Gabriola", 60));
        this.setTop(pregunta);


        Image imagen = new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoCentro);
        //ImageView fondoCentro= new ImageView(imagen);
        //fondoCentro.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondoCentro = new Background(fondoConImagen);
        BorderPane menuCantidades= new BorderPane();

        VBox opciones= new VBox();
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);


        for (int i = 2; i <= MaxJugadores; i++) {
            Label textoCantidad = new Label(i+ " jugadores ");
            //textoCantidad.setBackground(fondoCentro);
            textoCantidad.setFont(new Font("Gabriola", 50));
            HBox cantidadJugadores = new HBox();
            HBox.setMargin(textoCantidad,new Insets(0,25,0,0));
            BotonCantidadJugadores botonCantidad = new BotonCantidadJugadores(stage, i);
            cantidadJugadores.getChildren().addAll(textoCantidad, botonCantidad);
            cantidadJugadores.setAlignment(Pos.CENTER);
            opciones.getChildren().add(cantidadJugadores);
            opciones.setAlignment(Pos.CENTER);
        }


        opciones.setBackground(fondoCentro);
        menuCantidades.getChildren().add(opciones);


        this.setCenter(opciones);



    }
}
