package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonPais;
import javafx.scene.layout.AnchorPane;

public class Mapa extends AnchorPane {

    private final String rutaImagenMapa= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/tableroteg.jpg";
    private final double altura= 695;
    private final double ancho= 1149;
    private final double posicionX= 154;

    public Mapa(){
        super();
        Imagen fotoMapa= new Imagen(rutaImagenMapa, altura, ancho, posicionX);
        this.getChildren().add(fotoMapa);

        this.ponerPaises();
    }

    private void ponerPaises(){
        BotonPais canada = new BotonPais("Canada", 278, 173, 67, 25, 0);
        this.getChildren().add(canada.getBoton());

        BotonPais yukon = new BotonPais("Yukon", 224, 231, 50, 25, 0);
        this.getChildren().add(yukon.getBoton());

        BotonPais alaska = new BotonPais("Alaksa", 165, 271, 56, 25, -82.4);
        this.getChildren().add(alaska.getBoton());

        BotonPais oregon = new BotonPais("Oregon", 232, 285, 67, 25, -31);
        this.getChildren().add(oregon.getBoton());

        BotonPais nuevaYork = new BotonPais("Nueva York", 318, 263, 67, 25, 34.7);
        this.getChildren().add(nuevaYork.getBoton());

        BotonPais terranova = new BotonPais("Terranova", 354, 242, 67, 25, 23.4);
        this.getChildren().add(terranova.getBoton());

        BotonPais labrador = new BotonPais("Labrador", 392, 214, 50, 25, 21.8);
        this.getChildren().add(labrador.getBoton());

        BotonPais california = new BotonPais("California", 290, 313, 67, 25, -21);
        this.getChildren().add(california.getBoton());

        BotonPais mexico = new BotonPais("Mexico", 347, 345, 56, 25, 32.5);
        this.getChildren().add(mexico.getBoton());

        BotonPais colombia = new BotonPais("Colombia", 436, 395, 56, 25, -27.9);
        this.getChildren().add(colombia.getBoton());

        BotonPais brasil = new BotonPais("Brasil", 512, 433, 83, 25, 0);
        this.getChildren().add(brasil.getBoton());

        BotonPais peru = new BotonPais("Peru", 445, 445, 44, 25, 0);
        this.getChildren().add(peru.getBoton());

        BotonPais uruguay = new BotonPais("Uruguay", 511, 487, 44, 25, -30.3);
        this.getChildren().add(uruguay.getBoton());

        BotonPais argentina = new BotonPais("Aregtina", 453, 509, 72, 25, -71.6);
        this.getChildren().add(argentina.getBoton());

        BotonPais chile = new BotonPais("Chile", 424, 509, 56, 25, -77);
        this.getChildren().add(chile.getBoton());

        BotonPais groenlandia = new BotonPais("Groenlandia", 444, 150, 83, 25, 39);
        this.getChildren().add(groenlandia.getBoton());

        BotonPais islandia = new BotonPais("Islandia", 557, 268, 44, 25, -29.4);
        this.getChildren().add(islandia.getBoton());

        BotonPais granBretania = new BotonPais("Gran Bretania", 646, 289, 67, 25, -45);
        this.getChildren().add(granBretania.getBoton());

        BotonPais espania = new BotonPais("Espania", 636, 387, 56, 25, -23.2);
        this.getChildren().add(espania.getBoton());

        BotonPais francia = new BotonPais("Francia", 696, 345, 61, 25, -39.1);
        this.getChildren().add(francia.getBoton());

        BotonPais suecia = new BotonPais("Suecia", 721, 186, 56, 25, -34.5);
        this.getChildren().add(suecia.getBoton());

        BotonPais rusia = new BotonPais("Rusia", 789, 240, 60, 25, 0);
        this.getChildren().add(rusia.getBoton());

        BotonPais alemania = new BotonPais("Alemania", 760, 337, 46, 25, 26.6);
        this.getChildren().add(alemania.getBoton());

        BotonPais italia = new BotonPais("Italia", 756, 395, 46, 25, 48.2);
        this.getChildren().add(italia.getBoton());

        BotonPais polonia = new BotonPais("Polonia", 812, 312, 46, 25, 0);
        this.getChildren().add(polonia.getBoton());

        BotonPais sahara = new BotonPais("Sahara", 723, 479, 56, 25, 0);
        this.getChildren().add(sahara.getBoton());

        BotonPais zaire = new BotonPais("Zaire", 774, 515, 49, 25, 0);
        this.getChildren().add(zaire.getBoton());

        BotonPais etiopia = new BotonPais("Etiopia", 809, 487, 56, 25, 18.4);
        this.getChildren().add(etiopia.getBoton());

        BotonPais egipto = new BotonPais("Egipto", 842, 458, 51, 25, 22.6);
        this.getChildren().add(egipto.getBoton());

        BotonPais sudafrica = new BotonPais("Sudafrica", 814, 547, 57, 25, -48);
        this.getChildren().add(sudafrica.getBoton());

        BotonPais madagascar = new BotonPais("Madagascar", 881, 528, 83, 25, -68.2);
        this.getChildren().add(madagascar.getBoton());

        BotonPais aral = new BotonPais("Aral", 849, 173, 37, 25, -69.4);
        this.getChildren().add(aral.getBoton());

        BotonPais tartaria = new BotonPais("Tartaria", 868, 130, 48, 25, -77);
        this.getChildren().add(tartaria.getBoton());

        BotonPais taymir = new BotonPais("Taymir", 911, 150, 48, 25, -25.2);
        this.getChildren().add(taymir.getBoton());

        BotonPais siberia = new BotonPais("Siberia", 910, 181, 54, 25,-12.1);
        this.getChildren().add(siberia.getBoton());

        BotonPais kamchatka = new BotonPais("Kamchatka", 971, 141, 48, 25, -20);
        this.getChildren().add(kamchatka.getBoton());

        BotonPais japon = new BotonPais("Japon", 1051, 172, 48, 25, 43.6);
        this.getChildren().add(japon.getBoton());

        BotonPais mongolia = new BotonPais("Mongolia", 913, 222, 66,25, 0);
        this.getChildren().add(mongolia.getBoton());

        BotonPais china = new BotonPais("China", 1006, 268, 55, 25, 0);
        this.getChildren().add(china.getBoton());

        BotonPais malasia = new BotonPais("Malasia", 1041, 325, 48, 25, -22.8);
        this.getChildren().add(malasia.getBoton());

        BotonPais india = new BotonPais("India", 981, 360, 48, 25, -40.2);
        this.getChildren().add(india.getBoton());

        BotonPais gobi = new BotonPais("Gobi", 940, 267, 48, 25, 0);
        this.getChildren().add(gobi.getBoton());

        BotonPais iran = new BotonPais("Iran", 890, 270, 48, 25, 43.2);
        this.getChildren().add(iran.getBoton());

        BotonPais turquia = new BotonPais("Turquia", 872, 334, 66, 25, 0);
        this.getChildren().add(turquia.getBoton());

        BotonPais israel = new BotonPais("Israel", 862, 374, 48, 25, -28.3);
        this.getChildren().add(israel.getBoton());

        BotonPais arabia = new BotonPais("Arabia", 901, 385, 55, 25, -43.2);
        this.getChildren().add(arabia.getBoton());

        BotonPais sumatra = new BotonPais("Sumatra", 953, 445, 48, 25, 42.4);
        this.getChildren().add(sumatra.getBoton());

        BotonPais borneo = new BotonPais("Borneo", 1020, 402, 48, 25, 56.3);
        this.getChildren().add(borneo.getBoton());

        BotonPais java = new BotonPais("Java", 1067, 403, 41, 25, -68.7);
        this.getChildren().add(java.getBoton());

        BotonPais australia = new BotonPais("Australia", 1034, 502, 71, 25, 0);
        this.getChildren().add(australia.getBoton());
    }



}
