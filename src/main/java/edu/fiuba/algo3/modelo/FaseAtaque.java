package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;

import java.util.ArrayList;

public class FaseAtaque implements Fase{

    private final Jugador jugadorDeTurno;
    private ArrayList<Carta> cartas;
    private final int posAtacante = 0;
    private final int posAtacado= 1;
    private boolean huboConquista= false;
    private final String nombre= "ataque";

    public FaseAtaque(Jugador jugadorDeTurno, ArrayList<Carta> cartas){
        this.jugadorDeTurno = jugadorDeTurno;
        this.cartas = cartas;
    }

    @Override
    public void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, MovimientoConCantidadInvalidaException {
        Pais paisAtacante = paises[posAtacante];
        Pais paisAtacado = paises[posAtacado];
        paisAtacante.atacarPais(paisAtacado,cantidadEjercitos, jugadorDeTurno);

        if (paisAtacado.lePerteneceA(jugadorDeTurno)) huboConquista = true;
    }

    @Override
    public Fase siguienteFase(ArrayList<Carta> cartas){
        if(huboConquista) {
            jugadorDeTurno.darleCarta(cartas.get(0));
            cartas.remove(0);
        }
        return (new FaseAgrupamiento(jugadorDeTurno));
    }

    public String nombre() {
        return nombre;
    }
}