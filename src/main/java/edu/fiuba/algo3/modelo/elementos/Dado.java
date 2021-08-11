package edu.fiuba.algo3.modelo.elementos;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.random;

public class Dado{

    public static ArrayList<Integer> lanzar(int cantidad){

        ArrayList<Integer> dados = new ArrayList<>();
        for (int i = 0; i < cantidad; i++)
            dados.add((int) (1 + random() * 6));

        dados.sort(Collections.reverseOrder());
        return dados;
    }
}