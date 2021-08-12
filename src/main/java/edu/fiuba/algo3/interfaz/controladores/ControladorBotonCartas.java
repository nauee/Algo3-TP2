package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorBotonCartas implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final ArrayList<Carta> cartasJugador;

    public ControladorBotonCartas(Juego juego){
        this.juego = juego;
        this.cartasJugador = juego.getJugador(juego.getJugadorDeTurno()).getCartas();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage ventanaCartas= new Stage();
        ventanaCartas.setTitle("Cartas");
        ventanaCartas.initModality(Modality.APPLICATION_MODAL);
        //ventanaCartas.initOwner(stage);
        ventanaCartas.getIcons().add(new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/imagenes/iconoInformacion.jpg"));
        AnchorPane cartas= new AnchorPane();
        cartas.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergaminoPapel.jpg"));
        ArrayList<Carta> cartasSeleccionadas = new ArrayList<>();
        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = cartasJugador.get(i);
            HBox cartaBox = new HBox();
            Button contenidoCarta = new Button(carta.getPais().getNombre() +"\n"+ carta.getSimbolo());
            contenidoCarta.setOnAction(new ControladorBotonCarta(cartaBox, carta, cartasSeleccionadas, juego, ventanaCartas));
            contenidoCarta.setAlignment(Pos.CENTER);
            cartaBox.setAlignment(Pos.TOP_CENTER);
            cartaBox.setStyle("-fx-border-radius: 25% 25% 0 0; -fx-border-color: #984202; -fx-border-width: 2px 2px 0 2px;-fx-text-alignment: center");
            cartaBox.getChildren().add(contenidoCarta);
            cartaBox.setPrefSize(156, 76);
            cartaBox.setPadding(new Insets(10,0,0,0));
            cartas.getChildren().add(cartaBox);
            AnchorPane.setBottomAnchor(cartaBox, (double) (i/3)*55);
            AnchorPane.setLeftAnchor(cartaBox, (double) ((i%3)*156) + 25);
        }
        Scene informacionTexto= new Scene(cartas, 518, 500);
        ventanaCartas.setScene(informacionTexto);
        ventanaCartas.show();
    }
}
