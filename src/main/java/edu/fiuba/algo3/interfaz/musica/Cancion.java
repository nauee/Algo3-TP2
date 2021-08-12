package edu.fiuba.algo3.interfaz.musica;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Cancion {

    private Media audio;
    private MediaPlayer musica;
    private String nombre;
    private final double volumen = 0.25;

    public Cancion(File rutaCancion){
        nombre= this.obtenerNombre(rutaCancion.getName());
        audio = new Media(rutaCancion.toURI().toString());
        musica = new MediaPlayer(audio);
    }

    public void reproducirLoop(Reproductor reproductor){
        musica.setVolume(volumen);
        musica.play();
        musica.setOnEndOfMedia(() -> {
            reproductor.reproducir(this);
        });
    }

    public void detener(){
        musica.stop();
    }

    public String nombre(){
        return nombre;
    }

   private String obtenerNombre(String archivoCancion){
        String[] partes = archivoCancion.split("\\.");
        return (partes[0]);// 654321
    }

}
