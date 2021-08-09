package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.Cancion;
import edu.fiuba.algo3.interfaz.controladores.ControladorMusica;
import javafx.scene.control.RadioMenuItem;
import edu.fiuba.algo3.interfaz.Reproductor;

public class BotonMusica extends RadioMenuItem {

    public BotonMusica(Reproductor reproductor, String nombre, Cancion cancion){
       super();
       reproductor.agregar(cancion);
       this.setText(nombre);
       this.setOnAction(new ControladorMusica(reproductor, cancion));
    }
}
