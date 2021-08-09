package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.interfaz.BotonMusica;
import edu.fiuba.algo3.interfaz.BotonPais;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioInstrucciones;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VistaJuego extends VBox{

    Stage stage;
    Juego juego;
    private final String colorAzul = "#0077bb";
    private final String colorRojo = "#cc3311";
    private final String colorAmarillo = "#ee7733";
    private final String colorVerde = "#009988";
    private final String colorRosa = "#ee3377";
    private final String colorNegro = "#000000";
    private final ArrayList<String> colores = new ArrayList<>(List.of(colorAzul, colorRojo, colorAmarillo, colorVerde, colorRosa, colorNegro));
    private final String rutaImagenFondoJuego= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public VistaJuego(Stage stage, Juego juego){
        super();
        this.stage = stage;
        this.juego = juego;

        Image imagen = new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoJuego);
        BackgroundImage fondoConImagen= new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,  new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background fondo= new Background(fondoConImagen);
        this.setBackground(fondo);


        MenuBar menuBar = new MenuBar();
        MenuItem ayuda = new MenuItem("Ayuda");
        MenuItem salir = new MenuItem("Salir");
        Menu opciones = new Menu("Opciones");
        opciones.getItems().addAll(ayuda, salir);

        salir.setOnAction(new ControladorSalir(stage));
        ayuda.setOnAction(new ControladorMenuInicioInstrucciones(stage));


        MenuMusica musica = new MenuMusica();
        menuBar.getMenus().addAll(opciones, musica);


        Mapa mapa= new Mapa();

        for (int i = 0; i < juego.getCantidadJugadores(); i++) {
            HBox jugador = new HBox();
            Label jugadorNombre = new Label(juego.getJugador(i).getNombre());
            jugadorNombre.setStyle("-fx-border-color: " + colores.get(i) + "; -fx-border-radius: 10%; -fx-font-size: 18px");
            jugadorNombre.setPadding(new Insets(0,0,0,10));
            jugadorNombre.setPrefSize(118, 52);
            jugador.setPrefSize(118, 52);
            jugador.setLayoutY(50 + i*75);
            jugador.getChildren().add(jugadorNombre);
            mapa.getChildren().add(jugador);
            AnchorPane.setRightAnchor(jugador, 0.0);
        }

        int jugadorDeTurnoIndex = juego.getJugadorDeTurno();
        Jugador jugadorDeTurno = juego.getJugador(jugadorDeTurnoIndex);
        ArrayList<Carta> cartasJugador = jugadorDeTurno.getCartas();
        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = cartasJugador.get(i);
            HBox cartaBox = new HBox();
            Label contenidoCarta = new Label(carta.getPais().getNombre() +"\n"+ carta.getSimbolo());
            contenidoCarta.setAlignment(Pos.CENTER);
            contenidoCarta.setPrefSize(156, 76);
            contenidoCarta.setStyle("-fx-border-radius: 25% 25% 0 0; -fx-border-color: red; -fx-border-width: 2px 2px 0 2px;-fx-text-alignment: center");
            cartaBox.getChildren().add(contenidoCarta);
            cartaBox.setPrefSize(156, 76);
            mapa.getChildren().add(cartaBox);
            AnchorPane.setBottomAnchor(cartaBox, (double) i*55);
            AnchorPane.setLeftAnchor(cartaBox, 0.0);
        }

        this.getChildren().addAll(menuBar, mapa);


    }
}
