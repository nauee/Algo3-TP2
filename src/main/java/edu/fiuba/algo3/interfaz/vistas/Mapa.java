package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.interfaz.botones.BotonPais;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Mapa extends AnchorPane {

    private final String rutaImagenMapa= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/tableroteg.jpg";
    private final double altura= 695;
    private final double ancho= 1149;
    private final double posicionX= 154;
    private final Stage stage;
    private Juego juego;
    private final ArrayList<String> colores;


    public Mapa(Stage stage, Juego juego, ArrayList<String> colores) throws PaisNoExisteException {
        super();
        Imagen fotoMapa= new Imagen(rutaImagenMapa, altura, ancho, posicionX);
        this.getChildren().add(fotoMapa);
        this.stage=stage;
        this.juego=juego;
        this.colores= colores;

        this.ponerPaises();
    }

    private void ponerPaises() throws PaisNoExisteException {
        BotonPais canada = new BotonPais(juego.buscarPais("Canada"), 278, 173, 67, 25, colores);
        this.getChildren().add(canada.getBoton());

        BotonPais yukon = new BotonPais(juego.buscarPais("Yukon"), 224, 231, 60, 25, colores);
        this.getChildren().add(yukon.getBoton());

        BotonPais alaska = new BotonPais(juego.buscarPais("Alaska"), 165, 271, 70, 25, colores);
        this.getChildren().add(alaska.getBoton());

        BotonPais oregon = new BotonPais(juego.buscarPais("Oregon"), 232, 285, 67, 25, colores);
        this.getChildren().add(oregon.getBoton());

        BotonPais nuevaYork = new BotonPais(juego.buscarPais("Nueva York"), 318, 263, 95, 25, colores);
        this.getChildren().add(nuevaYork.getBoton());

        BotonPais terranova = new BotonPais(juego.buscarPais("Terranova"), 354, 242, 80, 25, colores);
        this.getChildren().add(terranova.getBoton());

        BotonPais labrador = new BotonPais(juego.buscarPais("Labrador"), 392, 214, 80, 25, colores);
        this.getChildren().add(labrador.getBoton());

        BotonPais california = new BotonPais(juego.buscarPais("California"), 290, 313, 80, 25, colores);
        this.getChildren().add(california.getBoton());

        BotonPais mexico = new BotonPais(juego.buscarPais("Mexico"), 347, 345, 75, 25, colores);
        this.getChildren().add(mexico.getBoton());

        BotonPais colombia = new BotonPais(juego.buscarPais("Colombia"), 436, 395, 80, 25, colores);
        this.getChildren().add(colombia.getBoton());

        BotonPais brasil = new BotonPais(juego.buscarPais("Brasil"), 512, 433, 60, 25, colores);
        this.getChildren().add(brasil.getBoton());

        BotonPais peru = new BotonPais(juego.buscarPais("Peru"), 445, 445, 60, 25, colores);
        this.getChildren().add(peru.getBoton());

        BotonPais uruguay = new BotonPais(juego.buscarPais("Uruguay"), 511, 487, 70, 25, colores);
        this.getChildren().add(uruguay.getBoton());

        BotonPais argentina = new BotonPais(juego.buscarPais("Argentina"), 453, 500, 80, 25, colores);
        this.getChildren().add(argentina.getBoton());

        BotonPais chile = new BotonPais(juego.buscarPais("Chile"), 424, 480, 50, 25, colores);
        this.getChildren().add(chile.getBoton());

        BotonPais groenlandia = new BotonPais(juego.buscarPais("Groenlandia"), 444, 150, 100, 25,colores );
        this.getChildren().add(groenlandia.getBoton());

        BotonPais islandia = new BotonPais(juego.buscarPais("Islandia"), 557, 268, 80, 25, colores);
        this.getChildren().add(islandia.getBoton());

        BotonPais granBretania = new BotonPais(juego.buscarPais("Gran Bretania"), 646, 289, 100, 25, colores);
        this.getChildren().add(granBretania.getBoton());

        BotonPais espania = new BotonPais(juego.buscarPais("Espania"), 636, 387, 66, 25, colores);
        this.getChildren().add(espania.getBoton());

        BotonPais francia = new BotonPais(juego.buscarPais("Francia"), 696, 345, 61, 25, colores);
        this.getChildren().add(francia.getBoton());

        BotonPais suecia = new BotonPais(juego.buscarPais("Suecia"), 721, 186, 65, 25, colores);
        this.getChildren().add(suecia.getBoton());

        BotonPais rusia = new BotonPais(juego.buscarPais("Rusia"), 789, 230, 60, 25, colores);
        this.getChildren().add(rusia.getBoton());

        BotonPais alemania = new BotonPais(juego.buscarPais("Alemania"), 760, 337, 80, 25, colores);
        this.getChildren().add(alemania.getBoton());

        BotonPais italia = new BotonPais(juego.buscarPais("Italia"), 756, 395, 60, 25, colores);
        this.getChildren().add(italia.getBoton());

        BotonPais polonia = new BotonPais(juego.buscarPais("Polonia"), 812, 312, 70, 25, colores);
        this.getChildren().add(polonia.getBoton());

        BotonPais sahara = new BotonPais(juego.buscarPais("Sahara"), 723, 479, 70, 25, colores);
        this.getChildren().add(sahara.getBoton());

        BotonPais zaire = new BotonPais(juego.buscarPais("Zaire"), 774, 515, 49, 25, colores);
        this.getChildren().add(zaire.getBoton());

        BotonPais etiopia = new BotonPais(juego.buscarPais("Etiopia"), 809, 487, 70, 25, colores);
        this.getChildren().add(etiopia.getBoton());

        BotonPais egipto = new BotonPais(juego.buscarPais("Egipto"), 842, 458, 60, 25, colores);
        this.getChildren().add(egipto.getBoton());

        BotonPais sudafrica = new BotonPais(juego.buscarPais("Sudafrica"), 814, 547, 80, 25, colores);
        this.getChildren().add(sudafrica.getBoton());

        BotonPais madagascar = new BotonPais(juego.buscarPais("Madagascar"), 881, 528, 90, 25, colores);
        this.getChildren().add(madagascar.getBoton());

        BotonPais aral = new BotonPais(juego.buscarPais("Aral"), 849, 173, 60, 25, colores);
        this.getChildren().add(aral.getBoton());

        BotonPais tartaria = new BotonPais(juego.buscarPais("Tartaria"), 868, 130, 80, 25, colores );
        this.getChildren().add(tartaria.getBoton());

        BotonPais taymir = new BotonPais(juego.buscarPais("Taymir"), 911, 150, 65, 25, colores);
        this.getChildren().add(taymir.getBoton());

        BotonPais siberia = new BotonPais(juego.buscarPais("Siberia"), 910, 181, 70, 25,colores);
        this.getChildren().add(siberia.getBoton());

        BotonPais kamchatka = new BotonPais(juego.buscarPais("Kamtchatka"), 971, 141, 90, 25, colores);
        this.getChildren().add(kamchatka.getBoton());

        BotonPais japon = new BotonPais(juego.buscarPais("Japon"), 1051, 172, 60, 25, colores);
        this.getChildren().add(japon.getBoton());

        BotonPais mongolia = new BotonPais(juego.buscarPais("Mongolia"), 913, 222, 80,25, colores);
        this.getChildren().add(mongolia.getBoton());

        BotonPais china = new BotonPais(juego.buscarPais("China"), 1006, 268, 55, 25, colores);
        this.getChildren().add(china.getBoton());

        BotonPais malasia = new BotonPais(juego.buscarPais("Malasia"), 1041, 325, 78, 25, colores);
        this.getChildren().add(malasia.getBoton());

        BotonPais india = new BotonPais(juego.buscarPais("India"), 981, 360, 60, 25, colores);
        this.getChildren().add(india.getBoton());

        BotonPais gobi = new BotonPais(juego.buscarPais("Gobi"), 940, 267, 48, 25, colores);
        this.getChildren().add(gobi.getBoton());

        BotonPais iran = new BotonPais(juego.buscarPais("Iran"), 890, 270, 48, 25, colores);
        this.getChildren().add(iran.getBoton());

        BotonPais turquia = new BotonPais(juego.buscarPais("Turquia"), 872, 334, 66, 25, colores);
        this.getChildren().add(turquia.getBoton());

        BotonPais israel = new BotonPais(juego.buscarPais("Israel"), 862, 374, 48, 25, colores);
        this.getChildren().add(israel.getBoton());

        BotonPais arabia = new BotonPais(juego.buscarPais("Arabia"), 901, 385, 55, 25, colores);
        this.getChildren().add(arabia.getBoton());

        BotonPais sumatra = new BotonPais(juego.buscarPais("Sumatra"), 953, 445, 75, 25, colores);
        this.getChildren().add(sumatra.getBoton());

        BotonPais borneo = new BotonPais(juego.buscarPais("Borneo"), 1020, 402, 70, 25, colores);
        this.getChildren().add(borneo.getBoton());

        BotonPais java = new BotonPais(juego.buscarPais("Java"), 1067, 403, 55, 25, colores);
        this.getChildren().add(java.getBoton());

        BotonPais australia = new BotonPais(juego.buscarPais("Australia"), 1034, 502, 71, 25, colores);
        this.getChildren().add(australia.getBoton());
    }



}
