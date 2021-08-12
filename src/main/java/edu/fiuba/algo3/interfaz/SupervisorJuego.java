package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vistas.VentanaJugada;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SupervisorJuego implements Observable{

    private final ArrayList<Pais> paisesSeleccionados;
    private final ArrayList<Observador> observadores;
    private final Juego juego;
    private VentanaJugada presentacion;
    private final Stage stage;

    public SupervisorJuego(Juego juego, Stage stage){
        paisesSeleccionados = new ArrayList<>();
        observadores = new ArrayList<>();
        this.stage=stage;
        this.juego = juego;
    }

    public void agregarPais(Pais pais){
        paisesSeleccionados.add(pais);
        this.notificar();
        if (paisesSeleccionados.size() == juego.getCantidadPaisesNecesarios()) {
            presentacion=new VentanaJugada(juego, stage, paisesSeleccionados, this);
            presentacion.mostrar();
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
