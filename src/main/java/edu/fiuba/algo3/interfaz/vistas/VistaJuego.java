package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.ObservadorJuego;
import edu.fiuba.algo3.interfaz.ObservadorPaisesSeleccionados;
import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaJuego extends BorderPane{

    private final ObservadorJuego observador;
    private final ObservadorPaisesSeleccionados observadorJuego;
    private final Stage stage;
    private Juego juego;
    private Mapa mapa;

    private final SupervisorJuego supervisorJuego;
    private final String colorAzul = "#0077bb";
    private final String colorRojo = "#cc3311";
    private final String colorAmarillo = "#ee7733";
    private final String colorVerde = "#009988";
    private final String colorRosa = "#ee3377";
    private final String colorNegro = "#000000";
    private final ArrayList<String> colores = new ArrayList<>(List.of(colorAzul, colorRojo, colorAmarillo, colorVerde, colorRosa, colorNegro));
    private final String rutaImagenFondoJuego= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergamino.jpg";

    public VistaJuego(Stage stage, Juego juego, MenuBarra menuArriba) throws PaisNoExisteException {
        super();
        this.stage = stage;
        this.juego = juego;
        supervisorJuego = new SupervisorJuego(juego, stage, menuArriba);
        observador = new ObservadorJuego(juego, this);
        observadorJuego = new ObservadorPaisesSeleccionados(supervisorJuego, this);
        mapa = new Mapa(stage, juego, supervisorJuego);

        this.setBackground(ImagenFondo.fondoJuego(rutaImagenFondoJuego));

        this.setTop(menuArriba);
        this.setCenter(mapa);
    }

    public void actualizarCompleto(){
        try{
            mapa.actualizar();
        } catch (PaisNoExisteException e) {
            e.printStackTrace();
        }
    }

    public void actualizarInformacion(){
        try{
            mapa.actualizar();
        } catch (PaisNoExisteException e) {
            e.printStackTrace();
        }
    }

}
