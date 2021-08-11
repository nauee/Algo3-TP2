package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.excepciones.*;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaJuego extends BorderPane{

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

    public VistaJuego(Stage stage, Juego juego, MenuBarra menuArriba) throws PaisNoExisteException {
        super();
        this.stage = stage;
        this.juego = juego;

        this.setBackground(ImagenFondo.fondoJuego(rutaImagenFondoJuego));
        ArrayList<Pais> paisesSeleccionados = new ArrayList<>();

        Mapa mapa= new Mapa(stage, juego, colores, paisesSeleccionados);
        InformacionJuego informacion = new InformacionJuego(juego);


        JugadoresEnMapa jugadores = new JugadoresEnMapa(juego, colores);
        mapa.getChildren().add(jugadores);
        AnchorPane.setRightAnchor(jugadores, 0.0);
        mapa.getChildren().add(informacion);
        AnchorPane.setLeftAnchor(informacion, 0.0);


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

        this.setTop(menuArriba);
        this.setCenter(mapa);

    }
}
