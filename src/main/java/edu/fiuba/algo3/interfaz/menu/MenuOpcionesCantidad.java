package edu.fiuba.algo3.interfaz.menu;

import edu.fiuba.algo3.interfaz.OpcionesCantidad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MenuOpcionesCantidad extends VBox {

    OpcionesCantidad cantidades;
    ArrayList<Label> etiquetas= new ArrayList<>();

    public MenuOpcionesCantidad(Text pregunta, int cantidadMinima, int cantidadMaxima, String tipoOpcion, float tamanio){
        super();

        cantidades=new OpcionesCantidad(cantidadMinima, cantidadMaxima);
        this.crearEtiquetas(cantidadMinima,cantidadMaxima, tipoOpcion, tamanio);

        this.getChildren().add(pregunta);

        for(int i=0; i<cantidades.size();i++){
            HBox cantidadJugadores = new HBox();
            HBox.setMargin(etiquetas.get(i),new Insets(0,tamanio/2,0,0));
            cantidadJugadores.getChildren().addAll(etiquetas.get(i), cantidades.get(i));
            cantidadJugadores.setAlignment(Pos.CENTER);
            this.getChildren().add(cantidadJugadores);
        }

        this.setAlignment(Pos.CENTER);
    }

    private void crearEtiquetas(int cantidadMinima, int cantidadMaxima, String tipoOpcion, float tamanio){

        for (int i = cantidadMinima; i <= cantidadMaxima; i++) {
            Label textoCantidad = new Label(i+ " " + tipoOpcion);
            textoCantidad.setFont(new Font("Gabriola", tamanio));
            etiquetas.add(textoCantidad);
        }
    }

    public OpcionesCantidad getOpciones(){
        return (this.cantidades);
    }
}
