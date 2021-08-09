package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.interfaz.vistas.Reproductor;

public class ControladorMusica implements EventHandler<ActionEvent> {

    private final Reproductor reproductor;
    private int numeroCancion;

    public ControladorMusica(Reproductor reproductor, int numeroCancion){
       this.reproductor=reproductor;
       this.numeroCancion=numeroCancion;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        reproductor.reproducir(numeroCancion);
    }
}
