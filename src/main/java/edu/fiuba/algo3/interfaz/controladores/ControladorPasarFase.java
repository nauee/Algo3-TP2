package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.modelo.excepciones.QuedanFichasPorColocarException;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.io.File;
import edu.fiuba.algo3.interfaz.musica.EfectoDeSonido;

public class ControladorPasarFase implements EventHandler<ActionEvent> {

    private final Juego juego;
    ArrayList<File> sonidos = new ArrayList<>();
    private final String rutaSonidoColocacion = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/FaseColocacion.mp3";
    private final String rutaSonidoAtaque = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/pasarAFaseBatalla.mp3";
    private final String rutaSonidoReagrupacion = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/FaseReagrupacion2.mp3";
    private final String faseColocacion = "colocacion";
    private final String faseAtaque = "ataque";

    public ControladorPasarFase(Juego juego){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        inicializarSonidos();
        try {
            juego.pasarDeFase();
            EfectoDeSonido sonido = new EfectoDeSonido(obtenerSonido(juego.getNombreFase()));
            sonido.reproducir();
        } catch (QuedanFichasPorColocarException e) {
            AlertaError.mensajeError(e.getMessage());
        }
    }

    private void inicializarSonidos(){
        sonidos.add(new File(rutaSonidoColocacion));
        sonidos.add(new File(rutaSonidoAtaque));
        sonidos.add(new File(rutaSonidoReagrupacion));
    }

    private File obtenerSonido(String nombreFase){
        switch(nombreFase){
            case faseColocacion:
                return sonidos.get(0);
            case faseAtaque:
                return sonidos.get(1);
            default:
                return sonidos.get(2);
        }
    }
}
