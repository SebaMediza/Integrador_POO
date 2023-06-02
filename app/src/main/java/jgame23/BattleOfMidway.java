package jgame23;

import com.entropyinteractive.*;  //jgame
import java.awt.*;
import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes
import java.awt.Graphics2D;
import java.util.*;

public class BattleOfMidway extends JGame {
    //Date dInit = new Date();
    //Date dAhora;
    //SimpleDateFormat ft = new SimpleDateFormat ("mm:ss");
    private static Vector<ObjetoGrafico> municionAmiga = new Vector<>();
    private static Vector<ObjetoGrafico> municionEnemiga = new Vector<>();
    private static  Vector<ObjetoGrafico> avionEnemigos = new Vector<>();
    public static void addMunicionAmiga(ObjetoGrafico objetoGrafico){
        municionAmiga.add(objetoGrafico);
    }
    public static void addMunicionEnemiga(ObjetoGrafico objetoGrafico){
        municionEnemiga.add(objetoGrafico);
    }
    public static void addAvionEnemigo(ObjetoGrafico objetoGrafico){
        avionEnemigos.add(objetoGrafico);
    }
    BufferedImage img_fondo = null;
    Avion_p38 avionP38 = new Avion_p38();


    public BattleOfMidway() {
        super("Battle Of Midway", 550, 1300);
//        System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        try {
            img_fondo = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg")));
            avionP38.setImagen(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/avionp38.png"))));
            avionP38.setPosicion((double) getWidth() / 2, (double) getHeight() / 2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();
        avionP38.mover(delta, keyboard);
        for (int i = 0; i < BattleOfMidway.municionAmiga.size(); i++) {
            BattleOfMidway.municionAmiga.get(i).setPosition(municionAmiga.get(i).getX(), municionAmiga.get(i).getY() - 5);
        }
        for (int i = 0; i < BattleOfMidway.municionEnemiga.size(); i++) {
            BattleOfMidway.municionEnemiga.get(i).setPosition(municionEnemiga.get(i).getX(), municionEnemiga.get(i).getY() + 5);
        }

    }

    public void gameDraw(Graphics2D g) {
        g.drawImage(img_fondo, 0, 0, null);// imagen de fondo
        avionP38.draw(g);
        for (int i = 0; i < BattleOfMidway.municionAmiga.size(); i++) {
            BattleOfMidway.municionAmiga.get(i).draw(g);
        }
    }

    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    public static void main(String[] args) {
        BattleOfMidway battleOfMidway = new BattleOfMidway();
        battleOfMidway.run(1.0/60.0);
    }
}