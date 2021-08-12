package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.controladores.ControladorBotonCarta;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaCarta extends HBox {

    private final Background fondoNormal;
    private final Background fondoActiva;
    private Button contenidoCarta;

    public VistaCarta(Carta carta, ArrayList<Carta> cartasSeleccionadas, Juego juego, Stage ventanaCartas) {
        this.contenidoCarta = new Button(carta.getPais().getNombre() +"\n"+ carta.getSimbolo());
        this.fondoNormal = new Background(new BackgroundFill(Color.valueOf("#dac4a4"), new CornerRadii(25,25,0,0,false), Insets.EMPTY));
        this.fondoActiva = new Background(new BackgroundFill(Color.valueOf("#cbad80"), new CornerRadii(25,25,0,0,false), Insets.EMPTY));
        contenidoCarta.setPrefSize(156, 100);
        contenidoCarta.setStyle("-fx-text-alignment: center");
        contenidoCarta.setOnAction(new ControladorBotonCarta(this, carta, cartasSeleccionadas, juego, ventanaCartas));
        contenidoCarta.setAlignment(Pos.TOP_CENTER);
        contenidoCarta.setBackground(fondoNormal);
        setAlignment(Pos.TOP_CENTER);
        setStyle("-fx-border-radius: 25px 25px 0 0; -fx-border-color: #984202; -fx-border-width: 2px 2px 0 2px;-fx-text-alignment: center");
        getChildren().add(contenidoCarta);
        setPrefSize(156, 100);
    }

    public void subirCarta(){
        contenidoCarta.setBackground(fondoActiva);
        contenidoCarta.setPrefSize(156,115);
        setPrefSize(156,115);
    }

}
