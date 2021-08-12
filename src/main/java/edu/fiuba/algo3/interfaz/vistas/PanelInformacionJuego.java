package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
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

        this.etapa= new Label("ETAPA \n");
        etapa.setStyle("-fx-font-size: 15; -fx-font-family: Gabriola");
        Label nombreEtapa= new Label(" "+juego.nombreFase()+ " ");
        nombreEtapa.setStyle("-fx-font-size: 20; -fx-font-family: Gabriola; -fx-background-color: #54402F; -fx-text-fill: #FFFFFF");
        nombreEtapa.prefWidth(140);
        nombreEtapa.prefHeight(18);

        Label turno= new Label("TURNO \n");
        turno.setStyle("-fx-font-size: 15; -fx-font-family: Gabriola");
        Label nombreJugador= new Label( " "+juego.getNombreJugadorDeTurno()+" ");
        nombreJugador.setStyle("-fx-font-size: 20; -fx-font-family: Gabriola; -fx-background-color: #54402F; -fx-text-fill: #FFFFFF");
        nombreJugador.prefWidth(140);
        nombreJugador.prefHeight(18);

        setPadding(new Insets(10,10,10,10));
        turno.setMaxWidth(140);
        VBox paisesSelect = new VBox();
        Text titulo = new Text("Paises seleccionados:");
        titulo.setStyle("-fx-font-family: Gabriola; -fx-font-size: 21px");
        paisesSelect.getChildren().add(titulo);
        ArrayList<String> paises = supervisorJuego.obtenerNombresPaises();
        for (String pais : paises) {
            Text paisText = new Text(pais);
            paisesSelect.getChildren().add(paisText);
        }
        this.getChildren().addAll(etapa, nombreEtapa, turno, nombreJugador, paisesSelect);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-size: 22px");

        ScrollPane listaPaises = new ScrollPane();
        VBox contenedorPaises = new VBox();
        ArrayList<Pais> paisesJugadorDeTurno = juego.paisesDeJugadorDeTurno();
        for (Pais pais : paisesJugadorDeTurno) {
            Text paisNombre = new Text(pais.getNombre() + ": " + pais.getCantidadEjercitos());
            contenedorPaises.getChildren().add(paisNombre);
        }

        listaPaises.setStyle("-fx-background-color: #AB8146;");
        listaPaises.setContent(contenedorPaises);
        listaPaises.setMaxHeight(300);
        listaPaises.setMaxWidth(140);
        getChildren().add(listaPaises);
        contenedorPaises.setStyle("-fx-background-color: #AB8146;");
        Text fichasDisponibles = new Text("\nFichas disponibles: " + juego.getCantidadFichasDisponibles());
        fichasDisponibles.setStyle("-fx-font-size: 21; -fx-font-family: Gabriola");
        fichasDisponibles.setLineSpacing(0.1);
        getChildren().add(fichasDisponibles);
        setMaxWidth(140);

    }

    public void mostrarInformacionPais(Pais pais){
        informacionPais = new Text("Ejercitos: " + pais.getCantidadEjercitos());
        getChildren().add(informacionPais);
    }

    public void ocultarInformacionPais(){
        getChildren().remove(informacionPais);
    }

}
