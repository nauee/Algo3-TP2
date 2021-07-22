package edu.fiuba.algo3;

import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public abstract class LectorDeCartas implements Lector{

    protected FileReader lector;
    protected JSONParser parser;

    protected abstract Carta obtenerCarta(Object carta);
}