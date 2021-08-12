package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.AlertaError;
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
    String faseAgrupamiento="agrupamiento";
    String faseAtaque= "ataque";
    String faseColocacion = "colocacion";

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
        Scene scene= new Scene(determinarVista(), 500, 300);
        setScene(scene);
        show();
    }

    public VistaJugada determinarVista(){
        VistaJugada vista= null;
        if(juego.nombreFase().equals(faseColocacion))
            vista= new VistaColocacion(juego, paises, supervisor, this);
        else if(juego.nombreFase().equals(faseAtaque))
            vista= new VistaAtaque(juego, paises, supervisor, this);
        else if (juego.nombreFase().equals(faseAgrupamiento))
            vista = new VistaAgrupamiento(juego, paises, supervisor, this);

        return vista;
    }

}
