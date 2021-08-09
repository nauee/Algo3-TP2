package edu.fiuba.algo3.interfaz;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Cancion {

    private Media audio;
    private MediaPlayer musica;

    public Cancion(File rutaCancion){

        audio = new Media(rutaCancion.toURI().toString());
        musica = new MediaPlayer(audio);
    }

    public void reproducir(){
        musica.play();
    }

    public void detener(){
        musica.stop();
    }
}
