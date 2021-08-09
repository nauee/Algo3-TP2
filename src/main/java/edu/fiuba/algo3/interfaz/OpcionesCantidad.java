package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.interfaz.controladores.ControladorDeSeleccion;

import java.util.ArrayList;

public class OpcionesCantidad extends ArrayList<BotonCantidad>{


    public OpcionesCantidad(int cantidadMinima, int cantidadMaxima){
        super();

        for (int i = cantidadMinima; i <= cantidadMaxima; i++) {
            BotonCantidad botonCantidad = new BotonCantidad(i);
            this.add(botonCantidad);
        }
        this.get(0).setSelected(true);
        this.discriminarOpciones();
    }

    private void discriminarOpciones(){
        for(int i=0; i<this.size(); i++)
            this.get(i).setOnAction(new ControladorDeSeleccion(this, this.get(i)));
    }

    public void desactivarOpciones(){
        for(int i=0; i<this.size(); i++)
            this.get(i).setSelected(false);
    }
}
