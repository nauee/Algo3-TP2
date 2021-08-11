package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InformacionJuego extends VBox {

    private final Juego juego;
    private Text etapa;

    public InformacionJuego(Juego juego){
        this.juego=juego;
        this.etapa= new Text("Etapa: " + juego.nombreFase());
    }

}
