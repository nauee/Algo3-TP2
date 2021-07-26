package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;

public class FachadaLector {

    private String tipoArchivo;
    private String rutaArchivo;

    public FachadaLector(String tipoArchivo, String rutaArchivo) {
        setTipoYRuta(tipoArchivo, rutaArchivo);
    }

    public void setTipoYRuta(String tipoArchivo, String rutaArchivo){
        this.tipoArchivo = tipoArchivo;
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<Continente> obtenerPaises() throws IOException, ParseException {
        LectorDePaisesCSV lpcsv = new LectorDePaisesCSV(rutaArchivo);
        LectorDePaisesJSON lpjson = new LectorDePaisesJSON(rutaArchivo);

        if (lpcsv.esDeTipo(tipoArchivo))
            return lpcsv.obtener();
        return lpjson.obtener();
    }

    public ArrayList<Carta> obtenerCartas() throws IOException, ParseException {
        LectorDeCartasCSV lccsv = new LectorDeCartasCSV(rutaArchivo);
        LectorDeCartasJSON lcjson = new LectorDeCartasJSON(rutaArchivo);

        if (lccsv.esDeTipo(tipoArchivo))
            return lccsv.obtener();
        return lcjson.obtener();
    }
}
