package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonCartas;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonObjetivos;
import edu.fiuba.algo3.interfaz.controladores.ControladorPasarFase;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class PanelInformacionJuego extends VBox {

    private final Juego juego;
    private final SupervisorJuego supervisorJuego;
    private Label etapa;
    private Text informacionPais;

    public PanelInformacionJuego(Juego juego, SupervisorJuego supervisorJuego){
        this.juego=juego;
        this.supervisorJuego = supervisorJuego;
        this.etapa= new Label("ETAPA:" + juego.nombreFase() + "\n");
        Label turno= new Label("Turno" + juego.getNombreJugadorDeTurno() + "\n");
        Label jugadorDeTurno = new Label( juego.getNombreJugadorDeTurno() + "\n");
        jugadorDeTurno.setStyle("-fx-background-color: #54402F; -fx-text-fill: #FFFFFF");

        jugadorDeTurno.setMaxWidth(100);
        VBox paisesSelect = new VBox();
        Text titulo = new Text(" Paises seleccionados:");
        paisesSelect.getChildren().add(titulo);
        ArrayList<String> paises = supervisorJuego.obtenerNombresPaises();
        for (String pais : paises) {
            Text paisText = new Text(pais);
            paisesSelect.getChildren().add(paisText);
        }
        this.getChildren().addAll(etapa, turno, jugadorDeTurno, paisesSelect);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-size: 25px; -fx-background-color: #AB8146");

        ScrollPane listaPaises = new ScrollPane();
        VBox contenedorPaises = new VBox();
        ArrayList<Pais> paisesJugadorDeTurno = juego.paisesDeJugadorDeTurno();
        for (Pais pais : paisesJugadorDeTurno) {
            Text paisNombre = new Text(pais.getNombre() + ": " + pais.getCantidadEjercitos());
            contenedorPaises.getChildren().add(paisNombre);
        }
        listaPaises.setContent(contenedorPaises);
        listaPaises.setMaxHeight(300);
        getChildren().add(listaPaises);
        contenedorPaises.setStyle("-fx-background-color:  #AB8146");

    }

    public void mostrarInformacionPais(Pais pais){
        informacionPais = new Text("Ejercitos: " + pais.getCantidadEjercitos());
        getChildren().add(informacionPais);
    }

    public void ocultarInformacionPais(){
        getChildren().remove(informacionPais);
    }

}
