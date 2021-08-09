package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioInstrucciones;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarra extends MenuBar {


    public MenuBarra(Stage stage){
        super();
        MenuItem ayuda = new MenuItem("Ayuda");
        MenuItem salir = new MenuItem("Salir");
        Menu opciones = new Menu("Opciones");
        opciones.getItems().addAll(ayuda, salir);

        salir.setOnAction(new ControladorSalir(stage));
        ayuda.setOnAction(new ControladorMenuInicioInstrucciones(stage));

        MenuMusica musica = new MenuMusica();
        this.getMenus().addAll(opciones, musica);
    }
}
