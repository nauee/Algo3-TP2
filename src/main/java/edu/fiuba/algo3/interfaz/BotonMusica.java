package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.controladores.ControladorMusica;
import javafx.scene.control.RadioMenuItem;
import edu.fiuba.algo3.interfaz.vistas.Reproductor;

public class BotonMusica extends RadioMenuItem {

    public BotonMusica(Reproductor reproductor, String nombre, int id){
       super();
       this.setText(nombre);
       this.setOnAction(new ControladorMusica(reproductor, id));
    }
}
