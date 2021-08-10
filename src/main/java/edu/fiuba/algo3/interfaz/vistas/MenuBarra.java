package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.controladores.ControladorInicio;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioInstrucciones;
import edu.fiuba.algo3.interfaz.controladores.ControladorNuevoJuego;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarra extends MenuBar {

    private final String rutaImagenFondo= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public MenuBarra(Stage stage){
        super();

        MenuItem ayuda = new MenuItem("Ayuda");
        MenuItem nuevoJuego = new MenuItem("Nuevo juego");
        MenuItem salir = new MenuItem("Salir");
        Menu opciones = new Menu("Opciones");

        opciones.getItems().addAll(nuevoJuego, ayuda, salir);

        salir.setOnAction(new ControladorSalir(stage));
        ayuda.setOnAction(new ControladorMenuInicioInstrucciones(stage));
        nuevoJuego.setOnAction(new ControladorNuevoJuego(stage, this));

        MenuMusica musica = new MenuMusica();
        musica.setStyle("-fx-background-color: #B2864B00");

        this.getMenus().addAll(opciones, musica);
        opciones.setStyle("-fx-background-color: #B2864B00");

        this.setBackground(ImagenFondo.fondoJuego(rutaImagenFondo));
        this.setStyle("-fx-border-color: #905A02; -fx-border-width: 4px 4px 4px 4px");
        this.setStyle("-fx-font-family: Gabriola; -fx-font-size: 20px; -fx-font-weight: bold");
    }
}
