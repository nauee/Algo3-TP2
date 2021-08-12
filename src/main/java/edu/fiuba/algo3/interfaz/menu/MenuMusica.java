package edu.fiuba.algo3.interfaz.menu;

import edu.fiuba.algo3.interfaz.musica.Reproductor;
import edu.fiuba.algo3.interfaz.botones.BotonMusica;
import edu.fiuba.algo3.interfaz.musica.Cancion;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;

public class MenuMusica extends Menu {

    private Reproductor reproductor;
    private final ArrayList<BotonMusica> botonesCanciones= new ArrayList<>();

    public MenuMusica(){
        this.setText("Musica");

        reproductor= new Reproductor();
        this.obtenerCanciones();
        this.agregarBotones();

    }

    private void obtenerCanciones(){
        ArrayList<Cancion> canciones= reproductor.canciones();
        for(int i=0; i<canciones.size(); i++){
            botonesCanciones.add(new BotonMusica(reproductor, canciones.get(i)));
        }

    }

    private void agregarBotones(){
        RadioMenuItem detener= new RadioMenuItem("Parar");
        detener.setOnAction(e->reproductor.detener());

        ToggleGroup toggleGroup= new ToggleGroup();
        for(int i=0; i<botonesCanciones.size(); i++){
            toggleGroup.getToggles().add(botonesCanciones.get(i));
            this.getItems().addAll(botonesCanciones.get(i));
        }

        toggleGroup.getToggles().add(detener);
        this.getItems().add(detener);
    }

    public Reproductor getReproductor(){
        return reproductor;
    }


}
