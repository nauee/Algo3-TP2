package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.ControladorCancelarJugada;
import edu.fiuba.algo3.interfaz.menu.MenuCantidadEjercitos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VistaJugada extends VBox {

    protected MenuCantidadEjercitos menu;

    protected VistaJugada(){
        setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg"));
        setAlignment(Pos.CENTER);
    }

    protected MenuCantidadEjercitos agregarOpcionesCantidadEjercitos(String pregunta, int cantidad){
        MenuCantidadEjercitos opcionesCantidades = new MenuCantidadEjercitos(pregunta, cantidad);
        opcionesCantidades.setAlignment(Pos.CENTER);
        return opcionesCantidades;
    }

    protected HBox botonesJugada(EventHandler<ActionEvent> realizarJugada, EventHandler<ActionEvent> cancelarJugada){
        HBox opciones= new HBox();
        BotonMediano jugar = new BotonMediano("Jugar", "Gabriola", realizarJugada);
        BotonMediano cancelar = new BotonMediano("Cancelar", "Gabriola", cancelarJugada);
        opciones.setAlignment(Pos.BOTTOM_CENTER);
        opciones.setSpacing(10);
        opciones.getChildren().addAll(cancelar, jugar);
        return opciones;
    }

}
