package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends VBox{

    Stage stage;
    Juego juego;

    public VistaJuego(Stage stage, Juego juego){
        super();
        this.stage = stage;
        this.juego = juego;

        MenuBar menuBar = new MenuBar();
        Menu salchicha = new Menu("salchicha");
        menuBar.getMenus().add(salchicha);
        MenuItem sopapo = new MenuItem("sopapo");
        MenuItem sarandipia = new MenuItem("sarandipia");
        salchicha.getItems().addAll(sopapo,sarandipia);
        AnchorPane pane = new AnchorPane();
        Image image = new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/interfaz/tableroteg.jpg");
        ImageView vista = new ImageView(image);
        vista.setFitHeight(695);
        vista.setFitWidth(1149);
        vista.setLayoutX(154);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        pane.getChildren().add(vista);

        Button canada = new Button("Canada");
        canada.setLayoutX(278);
        canada.setLayoutY(173);
        canada.setPrefSize(67,25);
        pane.getChildren().add(canada);

        Button yukon = new Button("Yukon");
        yukon.setLayoutX(224);
        yukon.setLayoutY(231);
        yukon.setPrefSize(50,25);
        pane.getChildren().add(yukon);

        Button alaska = new Button("Alaska");
        alaska.setLayoutX(165);
        alaska.setLayoutY(271);
        alaska.setPrefSize(56,25);
        alaska.setRotate(-82.4);
        pane.getChildren().add(alaska);

        Button oregon = new Button("Oregon");
        oregon.setLayoutX(232);
        oregon.setLayoutY(285);
        oregon.setPrefSize(67,25);
        oregon.setRotate(-31);
        pane.getChildren().add(oregon);

        Button nuevaYork = new Button("Nueva York");
        nuevaYork.setLayoutX(318);
        nuevaYork.setLayoutY(263);
        nuevaYork.setPrefSize(67,25);
        nuevaYork.setRotate(34.7);
        pane.getChildren().add(nuevaYork);

        Button terranova = new Button("Terranova");
        terranova.setLayoutX(354);
        terranova.setLayoutY(242);
        terranova.setPrefSize(67,25);
        terranova.setRotate(23.4);
        pane.getChildren().add(terranova);

        Button labrador = new Button("Labrador");
        labrador.setLayoutX(392);
        labrador.setLayoutY(214);
        labrador.setPrefSize(50,25);
        labrador.setRotate(21.8);
        pane.getChildren().add(labrador);

        Button california = new Button("California");
        california.setLayoutX(290);
        california.setLayoutY(313);
        california.setPrefSize(67,25);
        california.setRotate(-21);
        pane.getChildren().add(california);

        Button mexico = new Button("Mexico");
        mexico.setLayoutX(347);
        mexico.setLayoutY(345);
        mexico.setPrefSize(56,25);
        mexico.setRotate(32.5);
        pane.getChildren().add(mexico);

        Button colombia = new Button("Colombia");
        colombia.setLayoutX(436);
        colombia.setLayoutY(395);
        colombia.setPrefSize(56,25);
        colombia.setRotate(-27.9);
        pane.getChildren().add(colombia);

        Button brasil = new Button("Brasil");
        brasil.setLayoutX(512);
        brasil.setLayoutY(433);
        brasil.setPrefSize(83,25);
        pane.getChildren().add(brasil);

        Button peru = new Button("Peru");
        peru.setLayoutX(445);
        peru.setLayoutY(445);
        peru.setPrefSize(44,25);
        pane.getChildren().add(peru);

        Button uruguay = new Button("Uruguay");
        uruguay.setLayoutX(511);
        uruguay.setLayoutY(487);
        uruguay.setPrefSize(44,25);
        uruguay.setRotate(-30.3);
        pane.getChildren().add(uruguay);

        Button argentina = new Button("Argentina");
        argentina.setLayoutX(453);
        argentina.setLayoutY(509);
        argentina.setPrefSize(72,25);
        argentina.setRotate(-71.6);
        pane.getChildren().add(argentina);

        Button chile = new Button("Chile");
        chile.setLayoutX(424);
        chile.setLayoutY(509);
        chile.setPrefSize(56,25);
        chile.setRotate(-77);
        pane.getChildren().add(chile);

        Button groenlandia = new Button("groenlandia");
        groenlandia.setLayoutX(444);
        groenlandia.setLayoutY(150);
        groenlandia.setPrefSize(83,25);
        groenlandia.setRotate(39);
        pane.getChildren().add(groenlandia);

        Button islandia = new Button("islandia");
        islandia.setLayoutX(557);
        islandia.setLayoutY(268);
        islandia.setPrefSize(44,25);
        islandia.setRotate(-29.4);
        pane.getChildren().add(islandia);

        Button granBretania = new Button("granBretania");
        granBretania.setLayoutX(646);
        granBretania.setLayoutY(289);
        granBretania.setPrefSize(67,25);
        granBretania.setRotate(-45);
        pane.getChildren().add(granBretania);

        Button espania = new Button("espania");
        espania.setLayoutX(636);
        espania.setLayoutY(387);
        espania.setPrefSize(56,25);
        espania.setRotate(-23.2);
        pane.getChildren().add(espania);

        Button francia = new Button("francia");
        francia.setLayoutX(696);
        francia.setLayoutY(345);
        francia.setPrefSize(61,25);
        francia.setRotate(-39.1);
        pane.getChildren().add(francia);

        Button suecia = new Button("suecia");
        suecia.setLayoutX(721);
        suecia.setLayoutY(186);
        suecia.setPrefSize(56,25);
        suecia.setRotate(-34.7);
        pane.getChildren().add(suecia);

        Button rusia = new Button("rusia");
        rusia.setLayoutX(798);
        rusia.setLayoutY(234);
        rusia.setPrefSize(60,25);
        pane.getChildren().add(rusia);

        Button alemania = new Button("alemania");
        alemania.setLayoutX(760);
        alemania.setLayoutY(337);
        alemania.setPrefSize(46,25);
        alemania.setRotate(26.6);
        pane.getChildren().add(alemania);

        Button italia = new Button("italia");
        italia.setLayoutX(756);
        italia.setLayoutY(395);
        italia.setPrefSize(46,25);
        italia.setRotate(48.2);
        pane.getChildren().add(italia);

        Button polonia = new Button("polonia");
        polonia.setLayoutX(812);
        polonia.setLayoutY(312);
        polonia.setPrefSize(46,25);
        pane.getChildren().add(polonia);

        Button sahara = new Button("sahara");
        sahara.setLayoutX(723);
        sahara.setLayoutY(479);
        sahara.setPrefSize(56,25);
        pane.getChildren().add(sahara);

        Button zaire = new Button("zaire");
        zaire.setLayoutX(774);
        zaire.setLayoutY(515);
        zaire.setPrefSize(49,25);
        pane.getChildren().add(zaire);

        Button etiopia = new Button("etiopia");
        etiopia.setLayoutX(809);
        etiopia.setLayoutY(487);
        etiopia.setPrefSize(56,25);
        etiopia.setRotate(18.4);
        pane.getChildren().add(etiopia);

        Button egipto = new Button("egipto");
        egipto.setLayoutX(842);
        egipto.setLayoutY(458);
        egipto.setPrefSize(51,25);
        egipto.setRotate(22.6);
        pane.getChildren().add(egipto);

        Button sudafrica = new Button("sudafrica");
        sudafrica.setLayoutX(814);
        sudafrica.setLayoutY(547);
        sudafrica.setPrefSize(57,25);
        sudafrica.setRotate(-48);
        pane.getChildren().add(sudafrica);

        Button madagascar = new Button("Madagascar");
        madagascar.setLayoutX(881);
        madagascar.setLayoutY(528);
        madagascar.setPrefSize(83,25);
        madagascar.setRotate(-68.2);
        pane.getChildren().add(madagascar);

        Button aral = new Button("Aral");
        aral.setLayoutX(849);
        aral.setLayoutY(173);
        aral.setPrefSize(37,25);
        aral.setRotate(-69.4);
        pane.getChildren().add(aral);

        Button tartaria = new Button("tartaria");
        tartaria.setLayoutX(868);
        tartaria.setLayoutY(130);
        tartaria.setPrefSize(48,25);
        tartaria.setRotate(-77);
        pane.getChildren().add(tartaria);

        Button taymir = new Button("taymir");
        taymir.setLayoutX(911);
        taymir.setLayoutY(150);
        taymir.setPrefSize(48,25);
        taymir.setRotate(-25.2);
        pane.getChildren().add(taymir);

        Button siberia = new Button("siberia");
        siberia.setLayoutX(910);
        siberia.setLayoutY(181);
        siberia.setPrefSize(54,25);
        siberia.setRotate(-12.1);
        pane.getChildren().add(siberia);

        Button kamchatka = new Button("kamchatka");
        kamchatka.setLayoutX(971);
        kamchatka.setLayoutY(141);
        kamchatka.setPrefSize(48,25);
        kamchatka.setRotate(-20);
        pane.getChildren().add(kamchatka);

        Button japon = new Button("japon");
        japon.setLayoutX(1051);
        japon.setLayoutY(172);
        japon.setPrefSize(48,25);
        japon.setRotate(43.6);
        pane.getChildren().add(japon);

        Button mongolia = new Button("mongolia");
        mongolia.setLayoutX(913);
        mongolia.setLayoutY(222);
        mongolia.setPrefSize(66,25);
        pane.getChildren().add(mongolia);

        Button china = new Button("china");
        china.setLayoutX(1006);
        china.setLayoutY(268);
        china.setPrefSize(55,25);
        pane.getChildren().add(china);

        Button malasia = new Button("malasia");
        malasia.setLayoutX(1041);
        malasia.setLayoutY(325);
        malasia.setPrefSize(48,25);
        malasia.setRotate(-22.8);
        pane.getChildren().add(malasia);

        Button india = new Button("india");
        india.setLayoutX(981);
        india.setLayoutY(360);
        india.setPrefSize(48,25);
        india.setRotate(-40.2);
        pane.getChildren().add(india);

        Button gobi = new Button("gobi");
        gobi.setLayoutX(940);
        gobi.setLayoutY(267);
        gobi.setPrefSize(48,25);
        pane.getChildren().add(gobi);

        Button iran = new Button("iran");
        iran.setLayoutX(890);
        iran.setLayoutY(270);
        iran.setPrefSize(48,25);
        iran.setRotate(43.2);
        pane.getChildren().add(iran);

        Button turquia = new Button("turquia");
        turquia.setLayoutX(872);
        turquia.setLayoutY(334);
        turquia.setPrefSize(66,25);
        pane.getChildren().add(turquia);

        Button israel = new Button("israel");
        israel.setLayoutX(862);
        israel.setLayoutY(374);
        israel.setPrefSize(48,25);
        israel.setRotate(-28.3);
        pane.getChildren().add(israel);

        Button arabia = new Button("arabia");
        arabia.setLayoutX(901);
        arabia.setLayoutY(385);
        arabia.setPrefSize(55,25);
        arabia.setRotate(-43.2);
        pane.getChildren().add(arabia);

        Button sumatra = new Button("sumatra");
        sumatra.setLayoutX(953);
        sumatra.setLayoutY(445);
        sumatra.setPrefSize(48,25);
        sumatra.setRotate(42.4);
        pane.getChildren().add(sumatra);

        Button borneo = new Button("borneo");
        borneo.setLayoutX(1020);
        borneo.setLayoutY(402);
        borneo.setPrefSize(48,25);
        borneo.setRotate(56.3);
        pane.getChildren().add(borneo);

        Button java = new Button("java");
        java.setLayoutX(1067);
        java.setLayoutY(403);
        java.setPrefSize(41,25);
        java.setRotate(-68.7);
        pane.getChildren().add(java);

        Button australia = new Button("australia");
        australia.setLayoutX(1034);
        australia.setLayoutY(502);
        australia.setPrefSize(71,25);
        pane.getChildren().add(australia);

        this.getChildren().addAll(menuBar, pane);

    }
}
