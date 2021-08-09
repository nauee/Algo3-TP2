package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.Cancion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.interfaz.Reproductor;

public class ControladorMusica implements EventHandler<ActionEvent> {

    private final Reproductor reproductor;
    private final Cancion cancion;

    public ControladorMusica(Reproductor reproductor, Cancion cancion){
       this.reproductor=reproductor;
       this.cancion = cancion;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        reproductor.reproducir(cancion);
    }
}
