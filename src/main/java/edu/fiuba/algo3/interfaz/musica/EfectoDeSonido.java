package edu.fiuba.algo3.interfaz.musica;

import javafx.scene.media.AudioClip;
import java.io.File;

public class EfectoDeSonido {

    private final AudioClip audio;

    public EfectoDeSonido(File rutaAudio){
        audio = new AudioClip(rutaAudio.toURI().toString());
    }

    public void reproducir(){
        audio.play();
    }

    public void parar(){
        audio.stop();
    }
}
