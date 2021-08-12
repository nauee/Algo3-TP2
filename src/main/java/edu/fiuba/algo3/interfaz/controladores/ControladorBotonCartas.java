package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import edu.fiuba.algo3.interfaz.vistas.VistaCarta;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorBotonCartas implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final ArrayList<Carta> cartasJugador;
    private final String rutaIcono= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/brujula.jpg";

    public ControladorBotonCartas(Juego juego){
        this.juego = juego;
        this.cartasJugador = juego.getJugador(juego.getIdJugadorDeTurno()).getCartas();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage ventanaCartas= new Stage();
        ventanaCartas.setTitle("Cartas");
        ventanaCartas.initModality(Modality.APPLICATION_MODAL);
        //ventanaCartas.initOwner(stage);
        ventanaCartas.getIcons().add(new Image("file:"+System.getProperty("user.dir")+rutaIcono));
        AnchorPane cartas= new AnchorPane();
        cartas.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergaminoPapel.jpg"));
        ArrayList<Carta> cartasSeleccionadas = new ArrayList<>();
        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = cartasJugador.get(i);
            VistaCarta vistaCarta = new VistaCarta(carta, cartasSeleccionadas, juego, ventanaCartas);
            cartas.getChildren().add(0, vistaCarta);
            AnchorPane.setBottomAnchor(vistaCarta, (double) (i/3)*55);
            AnchorPane.setLeftAnchor(vistaCarta, (double) ((i%3)*156) + 25);
        }
        Scene informacionTexto= new Scene(cartas, 518, 500);
        ventanaCartas.setScene(informacionTexto);
        ventanaCartas.show();
    }
}
