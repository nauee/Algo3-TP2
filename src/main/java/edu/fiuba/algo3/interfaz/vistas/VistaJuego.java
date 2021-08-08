package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Jugador;
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
    private final String rutaImagenMapa= "/src/main/java/edu/fiuba/algo3/recursos/tableroteg.jpg";
    private final String rutaImagenFondoJuego= "/src/main/java/edu/fiuba/algo3/recursos/pergamino.jpg";

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
        Menu musica = new Menu("Musica");
        RadioMenuItem cancion1 = new RadioMenuItem("Track 1");
        RadioMenuItem cancion2 = new RadioMenuItem("Track 2");
        RadioMenuItem cancion3 = new RadioMenuItem("Track 3");
        ToggleGroup toggleGroup= new ToggleGroup();
        toggleGroup.getToggles().addAll(cancion1, cancion2, cancion3);

        musica.getItems().addAll(cancion1, cancion2, cancion3);

        menuBar.getMenus().addAll(opciones, musica);

        AnchorPane pane = new AnchorPane();
        Image image = new Image("file:"+System.getProperty("user.dir")+rutaImagenMapa);
        ImageView vista = new ImageView(image);
        vista.setFitHeight(695);
        vista.setFitWidth(1149);
        vista.setLayoutX(154);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        pane.getChildren().add(vista);

        BotonPais canada = new BotonPais("Canada", 278, 173, 67, 25, 0);
        pane.getChildren().add(canada.getBoton());

        BotonPais yukon = new BotonPais("Yukon", 224, 231, 50, 25, 0);
        pane.getChildren().add(yukon.getBoton());

        BotonPais alaska = new BotonPais("Alaksa", 165, 271, 56, 25, -82.4);
        pane.getChildren().add(alaska.getBoton());

        BotonPais oregon = new BotonPais("Oregon", 232, 285, 67, 25, -31);
        pane.getChildren().add(oregon.getBoton());

        BotonPais nuevaYork = new BotonPais("Nueva York", 318, 263, 67, 25, 34.7);
        pane.getChildren().add(nuevaYork.getBoton());

        BotonPais terranova = new BotonPais("Terranova", 354, 242, 67, 25, 23.4);
        pane.getChildren().add(terranova.getBoton());

        BotonPais labrador = new BotonPais("Labrador", 392, 214, 50, 25, 21.8);
        pane.getChildren().add(labrador.getBoton());

        BotonPais california = new BotonPais("California", 290, 313, 67, 25, -21);
        pane.getChildren().add(california.getBoton());

        BotonPais mexico = new BotonPais("Mexico", 347, 345, 56, 25, 32.5);
        pane.getChildren().add(mexico.getBoton());

        BotonPais colombia = new BotonPais("Colombia", 436, 395, 56, 25, -27.9);
        pane.getChildren().add(colombia.getBoton());

        BotonPais brasil = new BotonPais("Brasil", 512, 433, 83, 25, 0);
        pane.getChildren().add(brasil.getBoton());

        BotonPais peru = new BotonPais("Peru", 445, 445, 44, 25, 0);
        pane.getChildren().add(peru.getBoton());

        BotonPais uruguay = new BotonPais("Uruguay", 511, 487, 44, 25, -30.3);
        pane.getChildren().add(uruguay.getBoton());

        BotonPais argentina = new BotonPais("Aregtina", 453, 509, 72, 25, -71.6);
        pane.getChildren().add(argentina.getBoton());

        BotonPais chile = new BotonPais("Chile", 424, 509, 56, 25, -77);
        pane.getChildren().add(chile.getBoton());

        BotonPais groenlandia = new BotonPais("Groenlandia", 444, 150, 83, 25, 39);
        pane.getChildren().add(groenlandia.getBoton());

        BotonPais islandia = new BotonPais("Islandia", 557, 268, 44, 25, -29.4);
        pane.getChildren().add(islandia.getBoton());

        BotonPais granBretania = new BotonPais("Gran Bretania", 646, 289, 67, 25, -45);
        pane.getChildren().add(granBretania.getBoton());

        BotonPais espania = new BotonPais("Espania", 636, 387, 56, 25, -23.2);
        pane.getChildren().add(espania.getBoton());

        BotonPais francia = new BotonPais("Francia", 696, 345, 61, 25, -39.1);
        pane.getChildren().add(francia.getBoton());

        BotonPais suecia = new BotonPais("Suecia", 721, 186, 56, 25, -34.5);
        pane.getChildren().add(suecia.getBoton());

        BotonPais rusia = new BotonPais("Rusia", 789, 240, 60, 25, 0);
        pane.getChildren().add(rusia.getBoton());

        BotonPais alemania = new BotonPais("Alemania", 760, 337, 46, 25, 26.6);
        pane.getChildren().add(alemania.getBoton());

        BotonPais italia = new BotonPais("Italia", 756, 395, 46, 25, 48.2);
        pane.getChildren().add(italia.getBoton());

        BotonPais polonia = new BotonPais("Polonia", 812, 312, 46, 25, 0);
        pane.getChildren().add(polonia.getBoton());

        BotonPais sahara = new BotonPais("Sahara", 723, 479, 56, 25, 0);
        pane.getChildren().add(sahara.getBoton());

        BotonPais zaire = new BotonPais("Zaire", 774, 515, 49, 25, 0);
        pane.getChildren().add(zaire.getBoton());

        BotonPais etiopia = new BotonPais("Etiopia", 809, 487, 56, 25, 18.4);
        pane.getChildren().add(etiopia.getBoton());

        BotonPais egipto = new BotonPais("Egipto", 842, 458, 51, 25, 22.6);
        pane.getChildren().add(egipto.getBoton());

        BotonPais sudafrica = new BotonPais("Sudafrica", 814, 547, 57, 25, -48);
        pane.getChildren().add(sudafrica.getBoton());

        BotonPais madagascar = new BotonPais("Madagascar", 881, 528, 83, 25, -68.2);
        pane.getChildren().add(madagascar.getBoton());

        BotonPais aral = new BotonPais("Aral", 849, 173, 37, 25, -69.4);
        pane.getChildren().add(aral.getBoton());

        BotonPais tartaria = new BotonPais("Tartaria", 868, 130, 48, 25, -77);
        pane.getChildren().add(tartaria.getBoton());

        BotonPais taymir = new BotonPais("Taymir", 911, 150, 48, 25, -25.2);
        pane.getChildren().add(taymir.getBoton());

        BotonPais siberia = new BotonPais("Siberia", 910, 181, 54, 25,-12.1);
        pane.getChildren().add(siberia.getBoton());

        BotonPais kamchatka = new BotonPais("Kamchatka", 971, 141, 48, 25, -20);
        pane.getChildren().add(kamchatka.getBoton());

        BotonPais japon = new BotonPais("Japon", 1051, 172, 48, 25, 43.6);
        pane.getChildren().add(japon.getBoton());

        BotonPais mongolia = new BotonPais("Mongolia", 913, 222, 66,25, 0);
        pane.getChildren().add(mongolia.getBoton());

        BotonPais china = new BotonPais("China", 1006, 268, 55, 25, 0);
        pane.getChildren().add(china.getBoton());

        BotonPais malasia = new BotonPais("Malasia", 1041, 325, 48, 25, -22.8);
        pane.getChildren().add(malasia.getBoton());

        BotonPais india = new BotonPais("India", 981, 360, 48, 25, -40.2);
        pane.getChildren().add(india.getBoton());

        BotonPais gobi = new BotonPais("Gobi", 940, 267, 48, 25, 0);
        pane.getChildren().add(gobi.getBoton());

        BotonPais iran = new BotonPais("Iran", 890, 270, 48, 25, 43.2);
        pane.getChildren().add(iran.getBoton());

        BotonPais turquia = new BotonPais("Turquia", 872, 334, 66, 25, 0);
        pane.getChildren().add(turquia.getBoton());

        BotonPais israel = new BotonPais("Israel", 862, 374, 48, 25, -28.3);
        pane.getChildren().add(israel.getBoton());

        BotonPais arabia = new BotonPais("Arabia", 901, 385, 55, 25, -43.2);
        pane.getChildren().add(arabia.getBoton());

        BotonPais sumatra = new BotonPais("Sumatra", 953, 445, 48, 25, 42.4);
        pane.getChildren().add(sumatra.getBoton());

        BotonPais borneo = new BotonPais("Borneo", 1020, 402, 48, 25, 56.3);
        pane.getChildren().add(borneo.getBoton());

        BotonPais java = new BotonPais("Java", 1067, 403, 41, 25, -68.7);
        pane.getChildren().add(java.getBoton());

        BotonPais australia = new BotonPais("Australia", 1034, 502, 71, 25, 0);
        pane.getChildren().add(australia.getBoton());

        for (int i = 0; i < juego.getCantidadJugadores(); i++) {
            HBox jugador = new HBox();
            Label jugadorNombre = new Label(juego.getJugador(i).getNombre());
            jugadorNombre.setStyle("-fx-border-color: " + colores.get(i) + "; -fx-border-radius: 10%; -fx-font-size: 18px");
            jugadorNombre.setPadding(new Insets(0,0,0,10));
            jugadorNombre.setPrefSize(118, 52);
            jugador.setPrefSize(118, 52);
            jugador.setLayoutY(50 + i*75);
            jugador.getChildren().add(jugadorNombre);
            pane.getChildren().add(jugador);
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
            pane.getChildren().add(cartaBox);
            AnchorPane.setBottomAnchor(cartaBox, (double) i*55);
            AnchorPane.setLeftAnchor(cartaBox, 0.0);
        }

        this.getChildren().addAll(menuBar, pane);


    }
}
