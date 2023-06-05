package jgame23;

import com.entropyinteractive.*;  //jgame
import java.awt.*;
import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes
import java.util.*;

public class BattleOfMidway extends JGame {
    //Date dInit = new Date();
    //Date dAhora;
    //SimpleDateFormat ft = new SimpleDateFormat ("mm:ss");

    private final int minX=8;
    private final int maxX=480;
    private final int minY=48;
    private final int maxY=780;
    public static Vector<Municion> municionAmiga = new Vector<>();
    public static Vector<Municion> municionEnemiga = new Vector<>();
    public static  Vector<AvionEnemigo> avionEnemigos = new Vector<>();
    public static Vector<Misil> misilEnemigo = new Vector<>();
    public static void addMunicionAmiga(Municion municion){
        municionAmiga.add(municion);
    }
    public static void addMunicionEnemiga(Municion municion){
        municionEnemiga.add(municion);
    }
    public static void addAvionEnemigo(AvionEnemigo avionEnemigo){
        avionEnemigos.add(avionEnemigo);
    }
    public static void addMisilEnemigo(Misil misil){
        misilEnemigo.add(misil);
    }
    public static ArrayList<Municion> municionAmigaArrayList = new ArrayList<>();
    public static void addMunicionAmigaArrayList(Municion municion){
        municionAmigaArrayList.add(municion);
    }
    private final int min = 1; // Valor mínimo del rango
    private final int max = 100; // Valor máximo del rango


    BufferedImage img_fondo = null;
    BufferedImage kabom = null;
    Avion_p38 avionP38;

    public BattleOfMidway() {
        super("Battle Of Midway", 550, 1300);
        System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        try {
            avionP38 = new Avion_p38("imagenes/avionp38.png");
            avionP38.setPosicion((double) getWidth() / 2, (double) getHeight() / 2);
            img_fondo = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg")));
            kabom = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/explocion.gif")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i=0;i<1;i++){
            BattleOfMidway.addAvionEnemigo(new AvionEnemigo("imagenes/avionEnemigo.png"));
        }
        System.out.println(avionEnemigos.size());
    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();
        avionP38.mover(delta, keyboard);
//        for (int i = 0; i < BattleOfMidway.municionAmiga.size(); i++) {
//            BattleOfMidway.municionAmiga.get(i).setPosition(municionAmiga.get(i).getX(), municionAmiga.get(i).getY() - 5);
//        }
        for (Municion bala : municionAmigaArrayList){
            bala.setPosition(bala.getX(),bala.getY() - 5);
        }
        //COLICION DE MUNICION AMIGA CON AVION ENEMIGO
        ArrayList<Municion> toDelete= new ArrayList<>();
        for (Municion municionAmiga : municionAmigaArrayList) {
            int index = DetectorColiciones.detectarColicion(municionAmiga);
            if (index != -1){
                toDelete.add(municionAmiga);
                avionEnemigos.remove(index);
            }
        }
        for (Municion municion: toDelete) {
            municionAmigaArrayList.remove(municion);
        }
//        municionAmigaArrayList.removeAll(toDelete);

//        ListIterator<Municion> iterator = municionAmiga.listIterator(municionAmiga.size());
//        while (iterator.hasPrevious()) {
//            if (DetectorColiciones.detectarColicion(iterator.previous())) {
//                iterator.remove();
//            }
//        }
//        for (Municion municion: municionAmiga) {
//            int resultado = DetectorColiciones.detectarColicion(municion);
//            if (resultado != -1){
//                avionEnemigos.remove(resultado);
//                municionAmiga.remove(municion);
//            }
//            nroBala = municionAmiga.indexOf(municion);
//        }
//        municionAmiga.remove(nroBala);
        //COLICION DE AVIONP_38 CON AVION ENEMIGO
        avionEnemigos.removeIf(avionEnemigo -> DetectorColiciones.detectarColicion(avionP38));
        //COLICION DE MUNICION ENEMIGA CON AVION_P38
        for (Municion municion : municionEnemiga) {
            municion.setPosition(municion.getX(), municion.getY() + 5);
        }

        for (AvionEnemigo avionEnemigo : avionEnemigos){
//            int x = (int) (Math.random() * (maxX - maxY + 1)) + minX;
//            int y = (int) (Math.random() * (maxY - minY + 1)) + minY;
//            avionEnemigo.setPosition(avionEnemigo.getX() + 1, avionEnemigo.getY());
//            if (avionEnemigo.getX() == maxX){
//
//            }
//            avionEnemigo.setPosition(avionEnemigo.getX() + x, avionEnemigo.getY() + y);
//            avionEnemigo.disparar();
//            DetectorColiciones.detectarColicion(avionEnemigo, avionP38);
//            avionEnemigo.disparaMisil();
        }
    }

    public void gameDraw(Graphics2D g) {
        g.drawImage(img_fondo, 0, 0, null);// imagen de fondo
        avionP38.draw(g);
//        for (Municion bala : municionAmiga) {
//            bala.draw(g);
//        }
        for (Municion bala : municionAmigaArrayList){
            bala.draw(g);
        }
        for (AvionEnemigo plane : avionEnemigos) {
            plane.draw(g);
        }
        for (Municion balaEnemiga : municionEnemiga){
            balaEnemiga.draw(g);
        }
        g.setColor(Color.black);
        g.drawString(String.valueOf(avionP38.getEnegia()), 480, 50);
        g.setColor(Color.white);
        g.drawString(String.valueOf(avionP38.getEnegia()),482,52);
    }
    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    public static void main(String[] args) {
        BattleOfMidway battleOfMidway = new BattleOfMidway();
        battleOfMidway.run(1.0/60.0);
    }
}