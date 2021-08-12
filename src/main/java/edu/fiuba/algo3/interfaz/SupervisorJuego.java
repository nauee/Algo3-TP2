package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.musica.EfectoDeSonido;
import edu.fiuba.algo3.interfaz.vistas.VentanaJugada;
import edu.fiuba.algo3.interfaz.vistas.VistaGanador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class SupervisorJuego implements Observable{

    private final ArrayList<Pais> paisesSeleccionados;
    private final ArrayList<Observador> observadores;
    private final Juego juego;
    private VentanaJugada presentacion;
    private final Stage stage;
    private final MenuBarra menuArriba;
    private final String rutaSonidoVictoria = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/victoria.mp3";

    public SupervisorJuego(Juego juego, Stage stage, MenuBarra menuArriba){
        paisesSeleccionados = new ArrayList<>();
        observadores = new ArrayList<>();
        this.stage=stage;
        this.juego = juego;
        this.menuArriba = menuArriba;
    }

    public void agregarPais(Pais pais){
        paisesSeleccionados.add(pais);
        this.notificar();
        if (paisesSeleccionados.size() == juego.getCantidadPaisesNecesarios()) {
            presentacion=new VentanaJugada(juego, stage, paisesSeleccionados, this);
            presentacion.mostrar();
            if (juego.hayGanador()) {
                Scene scene = new Scene(new VistaGanador(stage, menuArriba, juego.getGanador()), 1280, 720);
                stage.setScene(scene);
                stage.show();
                menuArriba.getReproductor().detener();
                EfectoDeSonido sonido = new EfectoDeSonido(new File(rutaSonidoVictoria));
                sonido.reproducir();
            }
        }
    }

    public void limpiar(){
        paisesSeleccionados.clear();
    }

    public ArrayList<String> obtenerNombresPaises() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Pais pais : paisesSeleccionados) {
            nombres.add(pais.getNombre());
        }
        return nombres;
    }

    @Override
    public void agregarObservador(Observador nuevoObservador) {
        observadores.add(nuevoObservador);
    }

    @Override
    public void notificar() {
        for(Observador observador: observadores){
            observador.actualizar();
        }
    }
}
