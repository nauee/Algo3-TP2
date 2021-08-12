package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;

import java.util.ArrayList;

public class SupervisorJuego implements Observable{

    private final ArrayList<Pais> paisesSeleccionados;
    private final ArrayList<Observador> observadores;
    private final Juego juego;

    public SupervisorJuego(Juego juego){
        paisesSeleccionados = new ArrayList<Pais>();
        observadores = new ArrayList<>();
        this.juego = juego;
    }

    public void agregarPais(Pais pais){
        paisesSeleccionados.add(pais);
        this.notificar();
        if (paisesSeleccionados.size() == juego.getCantidadPaisesNecesarios()) {
            try {
                juego.jugar(1, paisesSeleccionados.get(0), paisesSeleccionados.get(1));
                limpiar();
            } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException e) {
                AlertaError.mensajeError(e.getMessage());
            }
        }
    }

    private void limpiar(){
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
