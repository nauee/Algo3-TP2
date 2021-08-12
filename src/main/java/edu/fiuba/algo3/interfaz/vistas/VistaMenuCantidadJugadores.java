package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonGrande;
import edu.fiuba.algo3.interfaz.controladores.ControladorCantidadJugadores;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.menu.MenuOpcionesCantidad;
import javafx.geometry.Pos;
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

        this.setBackground(ImagenFondo.fondoTotal(rutaImagenFondoMenu));
        Text pregunta= new Text("Por favor, selecciona la cantidad de jugadores:");
        pregunta.setTextAlignment(TextAlignment.CENTER);

        BorderPane.setAlignment(pregunta, Pos.TOP_CENTER);
        pregunta.setFont(new Font("Gabriola", 60));

        MenuOpcionesCantidad menuCantidad = new MenuOpcionesCantidad(pregunta, minJugadores, maxJugadores, "jugadores", 50);
        BotonGrande comenzar= new BotonGrande("Comenzar partida", "Gabriola",new ControladorCantidadJugadores(stage, menuCantidad.getOpciones(), menuArriba));


        comenzar.setAlignment(Pos.BOTTOM_CENTER);
        menuCantidad.setBackground(ImagenFondo.fondoParcial(rutaImagenFondoCentro));
        menuCantidad.getChildren().add(comenzar);
        menuCantidad.setAlignment(Pos.CENTER);

        this.setTop(menuArriba);
        this.setCenter(menuCantidad);
    }
}
