package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import edu.fiuba.algo3.interfaz.botones.BotonGrande;
import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.*;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.menu.MenuInicio;
import edu.fiuba.algo3.interfaz.menu.MenuOpcionesCantidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaGanador extends BorderPane {

    Stage stage;
    private final String rutaImagenFondoMenu="/src/main/java/edu/fiuba/algo3/recursos/imagenes/fondoTEG.jpg";

    public VistaGanador(Stage stage, MenuBarra barraMenu,Jugador ganador){
        this.stage = stage;
        ImageView fondo = new ImageView(new Image("file:"+System.getProperty("user.dir")+rutaImagenFondoMenu));
        fondo.fitHeightProperty().bind(this.heightProperty());
        fondo.fitWidthProperty().bind(this.widthProperty());

        this.setBackground(ImagenFondo.fondoTotal(rutaImagenFondoMenu));

        VBox contenedor = new VBox();
        Text pregunta= new Text(ganador.getNombre() + " ha ganado la guerra!");
        pregunta.setTextAlignment(TextAlignment.CENTER);

        BorderPane.setAlignment(pregunta, Pos.TOP_CENTER);
        pregunta.setFont(new Font("Gabriola", 100));

        BotonGrande volverAlMenu= new BotonGrande("Volver al menu", "Gabriola", new ControladorVolverAlMenu(stage, barraMenu));
        BotonGrande salir= new BotonGrande("Salir", "Gabriola", new ControladorSalir(stage));
        contenedor.getChildren().addAll(pregunta,volverAlMenu, salir);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(5);
        salir.setAlignment(Pos.BOTTOM_CENTER);

        this.setCenter(contenedor);

    }

}