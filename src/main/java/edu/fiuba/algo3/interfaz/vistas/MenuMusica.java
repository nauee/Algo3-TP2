package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.BotonMusica;
import edu.fiuba.algo3.interfaz.Cancion;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

import java.io.File;

public class MenuMusica extends Menu {

    private final File archivoRockstar = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/rockstar.mpeg");
    private final File archivoPirata = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/pirates.mp3");
    private final File archivoQueHaces = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/queHaces.mpeg");
    Reproductor reproductor;

    public MenuMusica(){
        this.setText("Musica");

        reproductor= new Reproductor(new Cancion(archivoPirata));
        BotonMusica cancion1 = new BotonMusica(reproductor, "Piratas", new Cancion(archivoPirata));
        BotonMusica cancion2 = new BotonMusica(reproductor, "Rockstar", new Cancion(archivoRockstar));
        BotonMusica cancion3 = new BotonMusica(reproductor, "No escuches esto", new Cancion(archivoQueHaces));

        RadioMenuItem detener= new RadioMenuItem("Parar");
        RadioMenuItem reproducirTodo= new RadioMenuItem("Reproducir todo");
        reproducirTodo.setOnAction(e-> reproductor.reproducirTodo());
        detener.setOnAction(e->reproductor.detener());

        ToggleGroup toggleGroup= new ToggleGroup();
        toggleGroup.getToggles().addAll(cancion1, cancion2, cancion3, detener, reproducirTodo);
        this.getItems().addAll(cancion1, cancion2, cancion3, detener, reproducirTodo);

        cancion1.setSelected(true);

    }
}
