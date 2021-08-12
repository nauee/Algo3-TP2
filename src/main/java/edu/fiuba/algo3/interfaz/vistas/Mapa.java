package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonCartas;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonObjetivos;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.interfaz.botones.BotonPais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AnchorPane {

    private final String rutaImagenMapa= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/tableroteg.jpg";
    private final double altura= 695;
    private final double ancho= 1130;
    private final double posicionX= 154;
    private final Stage stage;
    private PanelAcciones acciones;
    private Juego juego;
    private final String colorAzul = "#0077bb";
    private final String colorRojo = "#cc3311";
    private final String colorAmarillo = "#ee7733";
    private final String colorVerde = "#009988";
    private final String colorRosa = "#ee3377";
    private final String colorNegro = "#000000";
    private final ArrayList<String> colores = new ArrayList<>(List.of(colorAzul, colorRojo, colorAmarillo, colorVerde, colorRosa, colorNegro));
    private SupervisorJuego supervisorJuego;
    private ArrayList<BotonPais> botonesPaises = new ArrayList<>();
    private PanelInformacionJuego informacion;
    private TablaJugadores jugadores;

    public Mapa(Stage stage, Juego juego, SupervisorJuego supervisorJuego) throws PaisNoExisteException {
        super();
        Imagen fotoMapa= new Imagen(rutaImagenMapa, altura, ancho, posicionX);
        this.getChildren().add(fotoMapa);
        this.stage=stage;
        this.juego=juego;
        this.supervisorJuego = supervisorJuego;

        this.acciones= new PanelAcciones(juego, colores);
        this.informacion = new PanelInformacionJuego(juego, supervisorJuego);
        
        getChildren().addAll(acciones, informacion);
        AnchorPane.setRightAnchor(acciones, 0.0);
        AnchorPane.setLeftAnchor(informacion, 0.0);

        this.ponerPaises();

    }

    private void mostrarBotonesJugadorDeTurno(ArrayList<Pais> paisesDeTurno){
        for (BotonPais botonesPais: botonesPaises) {
            for (Pais pais : paisesDeTurno) {
                botonesPais.activar(pais);
            }
        }
    }

    public void actualizar() throws PaisNoExisteException {
        getChildren().clear();
        Imagen fotoMapa= new Imagen(rutaImagenMapa, altura, ancho, posicionX);
        this.getChildren().add(fotoMapa);

        this.acciones= new PanelAcciones(juego, colores);
        this.informacion = new PanelInformacionJuego(juego, supervisorJuego);

        getChildren().addAll(acciones, informacion);
        AnchorPane.setRightAnchor(acciones, 0.0);
        AnchorPane.setLeftAnchor(informacion, 0.0);

        this.ponerPaises();
    }

    public String getColor(int id){
        return (colores.get(id));
    }

    public void mostrarInformacionPais(Pais pais){
        informacion.mostrarInformacionPais(pais);
    }

    public void ocultarInformacionPais(){
        informacion.ocultarInformacionPais();
    }

    private void ponerPaises() throws PaisNoExisteException {

        BotonPais canada = new BotonPais(juego.buscarPais("Canada"), 278, 173, 67, 25, this, supervisorJuego);
        this.getChildren().add(canada.getBoton());
        botonesPaises.add(canada);

        BotonPais yukon = new BotonPais(juego.buscarPais("Yukon"), 224, 231, 60, 25, this, supervisorJuego);
        this.getChildren().add(yukon.getBoton());
        botonesPaises.add(yukon);

        BotonPais alaska = new BotonPais(juego.buscarPais("Alaska"), 165, 271, 70, 25, this, supervisorJuego);
        this.getChildren().add(alaska.getBoton());
        botonesPaises.add(alaska);

        BotonPais oregon = new BotonPais(juego.buscarPais("Oregon"), 232, 285, 67, 25, this, supervisorJuego);
        this.getChildren().add(oregon.getBoton());
        botonesPaises.add(oregon);

        BotonPais nuevaYork = new BotonPais(juego.buscarPais("Nueva York"), 318, 263, 95, 25, this, supervisorJuego);
        this.getChildren().add(nuevaYork.getBoton());
        botonesPaises.add(nuevaYork);

        BotonPais terranova = new BotonPais(juego.buscarPais("Terranova"), 354, 242, 80, 25, this, supervisorJuego);
        this.getChildren().add(terranova.getBoton());
        botonesPaises.add(terranova);

        BotonPais labrador = new BotonPais(juego.buscarPais("Labrador"), 392, 214, 80, 25, this, supervisorJuego);
        this.getChildren().add(labrador.getBoton());
        botonesPaises.add(labrador);

        BotonPais california = new BotonPais(juego.buscarPais("California"), 290, 313, 80, 25, this, supervisorJuego);
        this.getChildren().add(california.getBoton());
        botonesPaises.add(california);

        BotonPais mexico = new BotonPais(juego.buscarPais("Mexico"), 347, 345, 75, 25, this, supervisorJuego);
        this.getChildren().add(mexico.getBoton());
        botonesPaises.add(mexico);

        BotonPais colombia = new BotonPais(juego.buscarPais("Colombia"), 436, 395, 80, 25, this, supervisorJuego);
        this.getChildren().add(colombia.getBoton());
        botonesPaises.add(colombia);

        BotonPais brasil = new BotonPais(juego.buscarPais("Brasil"), 512, 433, 60, 25, this, supervisorJuego);
        this.getChildren().add(brasil.getBoton());
        botonesPaises.add(brasil);

        BotonPais peru = new BotonPais(juego.buscarPais("Peru"), 445, 445, 60, 25, this, supervisorJuego);
        this.getChildren().add(peru.getBoton());
        botonesPaises.add(peru);

        BotonPais uruguay = new BotonPais(juego.buscarPais("Uruguay"), 511, 487, 70, 25, this, supervisorJuego);
        this.getChildren().add(uruguay.getBoton());
        botonesPaises.add(uruguay);

        BotonPais argentina = new BotonPais(juego.buscarPais("Argentina"), 453, 500, 80, 25, this, supervisorJuego);
        this.getChildren().add(argentina.getBoton());
        botonesPaises.add(argentina);

        BotonPais chile = new BotonPais(juego.buscarPais("Chile"), 424, 480, 50, 25, this, supervisorJuego);
        this.getChildren().add(chile.getBoton());
        botonesPaises.add(chile);

        BotonPais groenlandia = new BotonPais(juego.buscarPais("Groenlandia"), 444, 150, 100, 25,this, supervisorJuego);
        this.getChildren().add(groenlandia.getBoton());
        botonesPaises.add(groenlandia);

        BotonPais islandia = new BotonPais(juego.buscarPais("Islandia"), 557, 268, 80, 25, this, supervisorJuego);
        this.getChildren().add(islandia.getBoton());
        botonesPaises.add(islandia);

        BotonPais granBretania = new BotonPais(juego.buscarPais("Gran Bretania"), 646, 289, 100, 25, this, supervisorJuego);
        this.getChildren().add(granBretania.getBoton());
        botonesPaises.add(granBretania);

        BotonPais espania = new BotonPais(juego.buscarPais("Espania"), 636, 387, 66, 25, this, supervisorJuego);
        this.getChildren().add(espania.getBoton());
        botonesPaises.add(espania);

        BotonPais francia = new BotonPais(juego.buscarPais("Francia"), 696, 345, 61, 25, this, supervisorJuego);
        this.getChildren().add(francia.getBoton());
        botonesPaises.add(francia);

        BotonPais suecia = new BotonPais(juego.buscarPais("Suecia"), 721, 186, 65, 25, this, supervisorJuego);
        this.getChildren().add(suecia.getBoton());
        botonesPaises.add(suecia);

        BotonPais rusia = new BotonPais(juego.buscarPais("Rusia"), 789, 230, 60, 25, this, supervisorJuego);
        this.getChildren().add(rusia.getBoton());
        botonesPaises.add(rusia);

        BotonPais alemania = new BotonPais(juego.buscarPais("Alemania"), 760, 337, 80, 25, this, supervisorJuego);
        this.getChildren().add(alemania.getBoton());
        botonesPaises.add(alemania);

        BotonPais italia = new BotonPais(juego.buscarPais("Italia"), 756, 395, 60, 25, this, supervisorJuego);
        this.getChildren().add(italia.getBoton());
        botonesPaises.add(italia);

        BotonPais polonia = new BotonPais(juego.buscarPais("Polonia"), 812, 312, 70, 25, this, supervisorJuego);
        this.getChildren().add(polonia.getBoton());
        botonesPaises.add(polonia);

        BotonPais sahara = new BotonPais(juego.buscarPais("Sahara"), 723, 479, 70, 25, this, supervisorJuego);
        this.getChildren().add(sahara.getBoton());
        botonesPaises.add(sahara);

        BotonPais zaire = new BotonPais(juego.buscarPais("Zaire"), 774, 515, 49, 25, this, supervisorJuego);
        this.getChildren().add(zaire.getBoton());
        botonesPaises.add(zaire);

        BotonPais etiopia = new BotonPais(juego.buscarPais("Etiopia"), 809, 487, 70, 25, this, supervisorJuego);
        this.getChildren().add(etiopia.getBoton());
        botonesPaises.add(etiopia);

        BotonPais egipto = new BotonPais(juego.buscarPais("Egipto"), 842, 458, 60, 25, this, supervisorJuego);
        this.getChildren().add(egipto.getBoton());
        botonesPaises.add(egipto);

        BotonPais sudafrica = new BotonPais(juego.buscarPais("Sudafrica"), 814, 547, 80, 25, this, supervisorJuego);
        this.getChildren().add(sudafrica.getBoton());
        botonesPaises.add(sudafrica);

        BotonPais madagascar = new BotonPais(juego.buscarPais("Madagascar"), 881, 528, 90, 25, this, supervisorJuego);
        this.getChildren().add(madagascar.getBoton());
        botonesPaises.add(madagascar);

        BotonPais aral = new BotonPais(juego.buscarPais("Aral"), 849, 173, 60, 25, this, supervisorJuego);
        this.getChildren().add(aral.getBoton());
        botonesPaises.add(aral);

        BotonPais tartaria = new BotonPais(juego.buscarPais("Tartaria"), 868, 130, 80, 25, this , supervisorJuego);
        this.getChildren().add(tartaria.getBoton());
        botonesPaises.add(tartaria);

        BotonPais taymir = new BotonPais(juego.buscarPais("Taymir"), 911, 150, 65, 25, this, supervisorJuego);
        this.getChildren().add(taymir.getBoton());
        botonesPaises.add(taymir);

        BotonPais siberia = new BotonPais(juego.buscarPais("Siberia"), 910, 181, 70, 25,this, supervisorJuego);
        this.getChildren().add(siberia.getBoton());
        botonesPaises.add(siberia);

        BotonPais kamchatka = new BotonPais(juego.buscarPais("Kamtchatka"), 971, 141, 90, 25, this, supervisorJuego);
        this.getChildren().add(kamchatka.getBoton());
        botonesPaises.add(kamchatka);

        BotonPais japon = new BotonPais(juego.buscarPais("Japon"), 1051, 172, 60, 25, this, supervisorJuego);
        this.getChildren().add(japon.getBoton());
        botonesPaises.add(japon);

        BotonPais mongolia = new BotonPais(juego.buscarPais("Mongolia"), 913, 222, 80,25, this, supervisorJuego);
        this.getChildren().add(mongolia.getBoton());
        botonesPaises.add(mongolia);

        BotonPais china = new BotonPais(juego.buscarPais("China"), 1006, 268, 55, 25, this, supervisorJuego);
        this.getChildren().add(china.getBoton());
        botonesPaises.add(china);

        BotonPais malasia = new BotonPais(juego.buscarPais("Malasia"), 1041, 325, 78, 25, this, supervisorJuego);
        this.getChildren().add(malasia.getBoton());
        botonesPaises.add(malasia);

        BotonPais india = new BotonPais(juego.buscarPais("India"), 981, 360, 60, 25, this, supervisorJuego);
        this.getChildren().add(india.getBoton());
        botonesPaises.add(india);

        BotonPais gobi = new BotonPais(juego.buscarPais("Gobi"), 940, 267, 48, 25, this, supervisorJuego);
        this.getChildren().add(gobi.getBoton());
        botonesPaises.add(gobi);

        BotonPais iran = new BotonPais(juego.buscarPais("Iran"), 890, 270, 48, 25, this, supervisorJuego);
        this.getChildren().add(iran.getBoton());
        botonesPaises.add(iran);

        BotonPais turquia = new BotonPais(juego.buscarPais("Turquia"), 872, 334, 66, 25, this, supervisorJuego);
        this.getChildren().add(turquia.getBoton());
        botonesPaises.add(turquia);

        BotonPais israel = new BotonPais(juego.buscarPais("Israel"), 862, 374, 70, 25, this, supervisorJuego);
        this.getChildren().add(israel.getBoton());
        botonesPaises.add(israel);

        BotonPais arabia = new BotonPais(juego.buscarPais("Arabia"), 901, 385, 65, 25, this, supervisorJuego);
        this.getChildren().add(arabia.getBoton());
        botonesPaises.add(arabia);

        BotonPais sumatra = new BotonPais(juego.buscarPais("Sumatra"), 953, 445, 75, 25, this, supervisorJuego);
        this.getChildren().add(sumatra.getBoton());
        botonesPaises.add(sumatra);

        BotonPais borneo = new BotonPais(juego.buscarPais("Borneo"), 1020, 402, 70, 25, this, supervisorJuego);
        this.getChildren().add(borneo.getBoton());
        botonesPaises.add(borneo);

        BotonPais java = new BotonPais(juego.buscarPais("Java"), 1067, 403, 55, 25, this, supervisorJuego);
        this.getChildren().add(java.getBoton());
        botonesPaises.add(java);

        BotonPais australia = new BotonPais(juego.buscarPais("Australia"), 1034, 502, 71, 25, this, supervisorJuego);
        this.getChildren().add(australia.getBoton());
        botonesPaises.add(australia);

        this.mostrarBotonesJugadorDeTurno(juego.paisesDeJugadorDeTurno());

    }



}
