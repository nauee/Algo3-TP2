package edu.fiuba.algo3.interfaz.vistas;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import edu.fiuba.algo3.interfaz.Cancion;
import java.io.File;
import java.util.List;

public class Reproductor {

    private Cancion cancionActual;
    private ArrayList<Cancion> canciones= new ArrayList<>();

    public Reproductor(Cancion cancionInicio){
        cancionActual=cancionInicio;
        this.reproducir(cancionActual);

    }

    public void reproducir(Cancion cancion){
        cancionActual.detener();
        cancion.reproducirLoop(this);
        cancionActual = cancion;
    }

    public void detener(){
        cancionActual.detener();
    }

    public void agregar(Cancion cancion){
        canciones.add(cancion);
    }

    public void reproducirTodo(){
        for (int i = 0; i < canciones.size(); i++) {
            final Cancion cancion = canciones.get(i);
            final Cancion proximaCancion = canciones.get((i + 1) % canciones.size());
            cancion.proximaCancion(proximaCancion);
        }

        cancionActual = canciones.get(0);
        cancionActual.reproducir();
    }
}
