package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class VentanaJugada extends Stage{

    private final Juego juego;
    private final ArrayList<Pais> paises;
    private final Stage stage;
    private final SupervisorJuego supervisor;

    public VentanaJugada(Juego juego, Stage stage, ArrayList<Pais> paises, SupervisorJuego supervisor){
        super();
        this.juego=juego;
        this.paises=paises;
        this.stage=stage;
        this.supervisor= supervisor;
    }

    public void mostrar(){
        setTitle("Jugar");
        initModality(Modality.APPLICATION_MODAL);
        initStyle(StageStyle.UNDECORATED);
        initOwner(stage);
        Scene scene= new Scene(determinarVista(), 400, 400);
        setScene(scene);
        show();
    }

    public VistaJugada determinarVista(){
        //VistaJugada vista;
        //if(juego.nombreFase().equals("agrupamiento")){
        //    vista= new VistaAgrupamiento(juego, paises);
        //}
        return (new VistaColocacion(juego, paises, supervisor, this));
    }

}
