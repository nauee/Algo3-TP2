package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.OpcionesCantidad;
import edu.fiuba.algo3.interfaz.controladores.ControladorCantidadJugadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class VistaMenuCantidadJugadores extends BorderPane {

    private final Stage stage;
    private final int minJugadores =2;
    private final int maxJugadores=6;
    private final String rutaImagenFondoMenu= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";
    private final String rutaImagenFondoCentro= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public VistaMenuCantidadJugadores(Stage stage, MenuBarra menuArriba) {
        this.stage = stage;

        ImageView fondo = new ImageView(new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoMenu));
        fondo.fitHeightProperty().bind(this.heightProperty());
        fondo.fitWidthProperty().bind(this.widthProperty());

        this.getChildren().add(fondo);
        Text pregunta= new Text("\n   Por favor, selecciona la cantidad de jugadores:");
        pregunta.setTextAlignment(TextAlignment.CENTER);

        BorderPane.setAlignment(pregunta, Pos.TOP_CENTER);
        pregunta.setFont(new Font("Gabriola", 60));


        Image imagen = new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoCentro);
        //ImageView fondoCentro= new ImageView(imagen);
        //fondoCentro.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(2.0, 2.0, false, false, true, false));
        Background fondoCentro = new Background(fondoConImagen);

        BorderPane menuCantidades= new BorderPane();

        VBox opciones= new VBox();
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);

        MenuOpcionesCantidad menuCantidad = new MenuOpcionesCantidad(pregunta, minJugadores, maxJugadores, "jugadores", 50);

        //  public BackgroundSize(@javafx.beans.NamedArg("width") double v, @javafx.beans.NamedArg("height") double v1, @javafx.beans.NamedArg("widthAsPercentage") boolean b, @javafx.beans.NamedArg("heightAsPercentage") boolean b1, @javafx.beans.NamedArg("contain") boolean b2, @javafx.beans.NamedArg("cover") boolean b3) { /* compiled code */ }

        Button comenzar= new Button("Comenzar partida");
        comenzar.setOnAction(new ControladorCantidadJugadores(stage, menuCantidad.getOpciones()));

        menuCantidad.setBackground(fondoCentro);
        menuCantidad.getChildren().addAll(comenzar);

        this.getChildren().add(menuArriba);

        menuCantidad.setAlignment(Pos.CENTER);
        this.setCenter(menuCantidad);
    }
}
