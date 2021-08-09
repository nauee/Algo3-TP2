package edu.fiuba.algo3.interfaz.vistas;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import edu.fiuba.algo3.interfaz.Cancion;
import java.io.File;
import java.util.List;

public class Reproductor {

    private final File archivoRockstar = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/rockstar.mpeg");
    private final File archivoPirata = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/pirates.mp3");
    private final File archivoQueHaces = new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/queHaces.mpeg");

    private final ArrayList<Cancion> canciones = new ArrayList<>();
    private Cancion cancionActual;

    public Reproductor(){

        Cancion musicaRockstar = new Cancion(archivoRockstar);
        Cancion musicaQueHaces= new Cancion(archivoQueHaces);
        Cancion musicaPirata= new Cancion(archivoPirata);
        canciones.addAll(List.of(musicaPirata, musicaRockstar, musicaQueHaces));

    }

    public void reproducir(int numeroCancion){
        cancionActual.detener();
        Cancion cancion = canciones.get(numeroCancion);
        cancion.reproducir();
        cancionActual = cancion;
    }
}
