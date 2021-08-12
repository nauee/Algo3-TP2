package edu.fiuba.algo3.interfaz.musica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reproductor {

    private Cancion cancionActual;
    private final ArrayList<Cancion> canciones=new ArrayList<>();

    private final File carpetaCanciones=new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica");;
    private ArrayList<File> rutaCanciones;
    private final Cancion cancionDefault= new Cancion(new File(System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/musica/Tronos.mp3"));

    public Reproductor(){
        this.obtenerCanciones();
        cancionActual = cancionDefault;
        this.reproducir(cancionActual);

    }

    private void obtenerCanciones(){
        rutaCanciones = new ArrayList<>(List.of((carpetaCanciones.listFiles())));
        for(int i=0; i<rutaCanciones.size(); i++)
           canciones.add(new Cancion(rutaCanciones.get(i)));
    }

    public void reproducir(Cancion cancion){
        cancionActual.detener();
        cancion.reproducirLoop(this);
        cancionActual = cancion;
    }

    public void detener(){
        cancionActual.detener();
    }

    public ArrayList<Cancion> canciones (){
        return (this.canciones);
    }
}
