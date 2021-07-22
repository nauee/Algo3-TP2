package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;
import java.io.IOException;

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

    public Object obtenerPaises() throws IOException, ParseException {
        LectorDePaisesCSV lpcsv = new LectorDePaisesCSV(rutaArchivo);
        LectorDePaisesJSON lpjson = new LectorDePaisesJSON(rutaArchivo);

        if (lpcsv.esDeTipo(tipoArchivo))
            return lpcsv.obtener();
        return lpjson.obtener();
    }

    public Object obtenerCartas() throws IOException, ParseException {
        LectorDeCartasCSV lccsv = new LectorDeCartasCSV(rutaArchivo);
        LectorDeCartasJSON lcjson = new LectorDeCartasJSON(rutaArchivo);

        if (lccsv.esDeTipo(tipoArchivo))
            return lccsv.obtener();
        return lcjson.obtener();
    }
}
