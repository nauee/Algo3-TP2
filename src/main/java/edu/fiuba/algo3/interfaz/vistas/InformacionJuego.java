package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonObjetivos;
import edu.fiuba.algo3.interfaz.controladores.ControladorPasarFase;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class InformacionJuego extends VBox {

    private final Juego juego;
    private final SupervisorJuego supervisorJuego;
    private Text etapa;
    private Text informacionPais;

    public InformacionJuego(Juego juego, SupervisorJuego supervisorJuego){
        this.juego=juego;
        this.supervisorJuego = supervisorJuego;
        this.etapa= new Text("Etapa: " + juego.nombreFase());
        Text jugadorDeTurno= new Text("Jugador de turno: " + juego.getNombreJugadorDeTurno());
       // Button jugar = new Button("Jugar");
        VBox paisesSelect = new VBox();
        Text titulo = new Text("Paises seleccionados:");
        paisesSelect.getChildren().add(titulo);
        ArrayList<String> paises = supervisorJuego.obtenerNombresPaises();
        for (String pais : paises) {
            Text paisText = new Text(pais);
            paisesSelect.getChildren().add(paisText);
        }
        this.getChildren().addAll(etapa, jugadorDeTurno, paisesSelect);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-size: 25px; -fx-background-color: AB8146");
        Button pasarDeFase = new Button("Pasar");
        pasarDeFase.setOnAction(new ControladorPasarFase(juego));
        pasarDeFase.setLayoutX(278);
        pasarDeFase.setLayoutY(173);
        getChildren().add(pasarDeFase);

        ScrollPane listaPaises = new ScrollPane();
        VBox contenedorPaises = new VBox();
        ArrayList<Pais> paisesJugadorDeTurno = juego.paisesDeJugadorDeTurno();
        for (Pais pais : paisesJugadorDeTurno) {
            Text paisNombre = new Text(pais.getNombre() + ": " + pais.getCantidadEjercitos());
            contenedorPaises.getChildren().add(paisNombre);
        }
        listaPaises.setContent(contenedorPaises);
        listaPaises.setMaxHeight(250);
        getChildren().add(listaPaises);

        Button objetivo = new Button("Objetivo");
        objetivo.setOnAction(new ControladorBotonObjetivos(juego.getJugador(juego.getJugadorDeTurno()).getObjetivoDescripcion()));
        getChildren().add(objetivo);
    }

    public void mostrarInformacionPais(Pais pais){
        informacionPais = new Text("Ejercitos: " + pais.getCantidadEjercitos());
        getChildren().add(informacionPais);
    }

    public void ocultarInformacionPais(){
        getChildren().remove(informacionPais);
    }

}
