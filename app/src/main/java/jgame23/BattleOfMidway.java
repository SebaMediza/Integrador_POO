package jgame23;

import com.entropyinteractive.*;  //jgame
import java.awt.*;
import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes
import java.util.*;

public class BattleOfMidway extends JGame {
    private static final double VELOCIDAD_IMAGEN = 61, velocidadNuber = 200;;
    public static ArrayList<Municion> municionAmigaArrayList = new ArrayList<>();
    public static ArrayList<Municion> municionEnemigaArrayList = new ArrayList<>();
    public static ArrayList<AvionEnemigo> avionEnemigoArrayList = new ArrayList<>();
    public static ArrayList<Misil> misilArrayList = new ArrayList<>();
    public static void addMunicionAmigaArrayList(Municion municion){
        municionAmigaArrayList.add(municion);
    }
    public static void addMunicionEnemigaArrayList(Municion municion){
        municionEnemigaArrayList.add(municion);
    }
    public static void addAvionEnemigoArrayList(AvionEnemigo avionEnemigo){
        avionEnemigoArrayList.add(avionEnemigo);
    }
    public static void addMisilArrayList(Misil misil){
        misilArrayList.add(misil);
    }

    public static int finalScore = 0;
    BufferedImage img_fondo, imagenNubes;
    private  int offSetY, posicionNubesY;
    BufferedImage kabom = null;
    Avion_p38 avionP38;

    public BattleOfMidway() {
        super("Battle Of Midway", 945, Toolkit.getDefaultToolkit().getScreenSize().height - 37);
        System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        try {
            avionP38.setPosicion((double) getWidth() / 2, (double) getHeight() / 2);
            img_fondo = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/fondo3.png")));
            //imagenNubes = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/Enemigo.png")));
            kabom = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/explocion.gif")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        offSetY = img_fondo.getHeight() - getHeight();
    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();
        avionP38.mover(delta, keyboard);
        //MOVIMIENTO DEL FONDO
        offSetY -= VELOCIDAD_IMAGEN * delta;
        if(offSetY < -img_fondo.getHeight()){
            offSetY = 0;
        }
        posicionNubesY -= velocidadNuber * delta;
        //MOVIMIENTO DE LAS BALAS
        for (Municion bala : municionAmigaArrayList){
            bala.setPosition(bala.getX(),bala.getY() - 5);
        }
        //COLICION DE MUNICION AMIGA CON AVION ENEMIGO
        ArrayList<Municion> toDeleteMunicionAmiga= new ArrayList<>();
        for (Municion municionAmiga : municionAmigaArrayList) {
            int index = DetectorColiciones.detectarColicion(municionAmiga);
            if (index != -1){
                toDeleteMunicionAmiga.add(municionAmiga);
                avionEnemigoArrayList.remove(index);
            }
        }
        for (Municion municion: toDeleteMunicionAmiga) {
            municionAmigaArrayList.remove(municion);
        }
        //COLICION DE AVIONP_38 CON AVION ENEMIGO
        avionEnemigoArrayList.removeIf(avionEnemigo -> DetectorColiciones.detectarColicion(avionP38));
        //COLICION DE MUNICION ENEMIGA CON AVION_P38
        ArrayList<Municion> toDeleteMunicionEnemiga = new ArrayList<>();
        for (Municion municion : municionEnemigaArrayList) {
            municion.setPosition(municion.getX(), municion.getY() + 5);
            if (DetectorColiciones.detectarColicion(municion, avionP38)){
                toDeleteMunicionEnemiga.add(municion);
            }
        }
        for (Municion municion : toDeleteMunicionEnemiga){
            municionEnemigaArrayList.remove(municion);
        }
        for (AvionEnemigo avionEnemigo : avionEnemigoArrayList){
            avionEnemigo.disparar();
//            avionEnemigo.dispararMisil();
        }
    }

    public void gameDraw(Graphics2D g) {
        g.drawImage(img_fondo, 0, -offSetY,null);// imagen de fondo
        g.drawImage(imagenNubes, 0, -posicionNubesY, null);// imagen nubes
        avionP38.draw(g);
        for (Municion bala : municionAmigaArrayList){
            bala.draw(g);
        }
        for (AvionEnemigo plane : avionEnemigoArrayList) {
            plane.draw(g);
        }
        for (Municion balaEnemiga : municionEnemigaArrayList){
            balaEnemiga.draw(g);
        }
        g.setColor(Color.black);
        g.drawString(String.valueOf(avionP38.getEnegia()), 480, 50);
        g.drawString(String.valueOf(finalScore),5,50);
        g.setColor(Color.white);
        g.drawString(String.valueOf(avionP38.getEnegia()),482,52);
        g.drawString(String.valueOf(finalScore),7,52);
    }
    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    public static void main(String[] args) {
        BattleOfMidway battleOfMidway = new BattleOfMidway();
        battleOfMidway.run(1.0/60.0);
    }
}