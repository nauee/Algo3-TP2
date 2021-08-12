package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonCartas;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonObjetivos;
import edu.fiuba.algo3.interfaz.controladores.ControladorPasarFase;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PanelAcciones extends AnchorPane {

    private Juego juego;
    private TablaJugadores jugadores;
    private VBox botones= new VBox();

    public PanelAcciones(Juego juego, ArrayList<String> colores){
        this.juego=juego;
        this.jugadores= new TablaJugadores(juego, colores);
        crearBotonesAcciones();
        setPrefHeight(695);

        getChildren().addAll(jugadores, botones);
        AnchorPane.setBottomAnchor(botones, 100.0);
        AnchorPane.setRightAnchor(botones, 0.0);
    }


    private void crearBotonesAcciones(){
        BotonMediano objetivo = new BotonMediano("Objetivo", "Gabriola", new ControladorBotonObjetivos(juego.getObjetivoJugadorDeTurno()));
        BotonMediano cartas = new BotonMediano("Cartas", "Gabriola", new ControladorBotonCartas(juego));
        BotonMediano pasarDeFase = new BotonMediano("Pasar", "Gabriola", new ControladorPasarFase(juego));
        objetivo.setAlignment(Pos.CENTER);
        cartas.setAlignment(Pos.CENTER);
        pasarDeFase.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(objetivo, cartas, pasarDeFase);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(2);
        botones.setAlignment(Pos.CENTER);
    }
}
