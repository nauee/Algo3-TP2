package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonGrande;
import edu.fiuba.algo3.interfaz.controladores.ControladorInicio;
import edu.fiuba.algo3.interfaz.controladores.ControladorVolver;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaNombresJugadores extends BorderPane {

    Stage stage;
    private final String rutaImagenFondoCentro= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";
    private final String rutaImagenFondo= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";

    public VistaNombresJugadores(Stage stage, int cantidad, MenuBarra menuArriba){
        super();
        this.stage = stage;

        NombresJugadores jugadores = new NombresJugadores(cantidad);
        VBox vboxNombres = new VBox();

        vboxNombres.setAlignment(Pos.CENTER);
        vboxNombres.setStyle("-fx-font-family: Gabriola");
        vboxNombres.setStyle("-fx-font-weight: bold");
        vboxNombres.setSpacing(10);

        Label tituloDeCuadroNombres = new Label(" Agregar Nombres");
        tituloDeCuadroNombres.setFont(new Font("Gabriola", 50));
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(0,0,0,0));

        BotonGrande inicioBoton = new BotonGrande("Iniciar", "Gabriola", new ControladorInicio(stage, jugadores.nombres(), menuArriba));
        inicioBoton.setAlignment(Pos.CENTER);

        BotonGrande atrasBoton = new BotonGrande("Volver", "Gabriola", new ControladorVolver(stage, menuArriba));
        atrasBoton.setAlignment(Pos.CENTER);

        HBox opciones= new HBox();
        opciones.getChildren().addAll(atrasBoton, inicioBoton);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);
        this.setBackground(ImagenFondo.fondoTotal(rutaImagenFondo));

        VBox nombres= new VBox();
        nombres.getChildren().addAll(tituloDeCuadroNombres, jugadores, opciones);
        nombres.setAlignment(Pos.CENTER);
        nombres.setSpacing(20);
        nombres.setBackground(ImagenFondo.fondoParcial(rutaImagenFondoCentro));
        this.setTop(menuArriba);
        this.setCenter(nombres);
    }
}