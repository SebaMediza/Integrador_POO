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
    public static Vector<Municion> municionAmiga = new Vector<>();
    public static Vector<Municion> municionEnemiga = new Vector<>();
    public static  Vector<AvionEnemigo> avionEnemigos = new Vector<>();
    public static void addMunicionAmiga(Municion objetoGrafico){
        municionAmiga.add(objetoGrafico);
    }
    public static void addMunicionEnemiga(Municion objetoGrafico){
        municionEnemiga.add(objetoGrafico);
    }
    public static void addAvionEnemigo(AvionEnemigo objetoGrafico){
        avionEnemigos.add(objetoGrafico);
    }
    /*
    private static Hashtable<Integer, Municion> muncionAmigaHashTable = new Hashtable<>();
    private static Hashtable<Integer, AvionEnemigo> avionEnemigoHashTable = new Hashtable<>();
    private int indiceGeneral = 0;

    public static void addMuncionAmigaHashTable(int index, Municion bullet) {
        muncionAmigaHashTable.put(index, bullet);
    }

    public static void addavionEnemigoHashTable(int index, AvionEnemigo plane){
        avionEnemigoHashTable.put(index, plane);
    }
    */
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
//            avionP38.setImagen(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/avionp38.png"))));
            avionP38.setPosicion((double) getWidth() / 2, (double) getHeight() / 2);
            img_fondo = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg")));
            kabom = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/explocion.gif")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i=0;i<10;i++){
            BattleOfMidway.addAvionEnemigo(new AvionEnemigo("imagenes/avionEnemigo.png"));
//            avionEnemigoHashTable.put(i,new AvionEnemigo("imagenes/avionEnemigo.png"));
        }
        System.out.println(avionEnemigos.size());
//        BattleOfMidway.addAvionEnemigo(avionP38Enemigo);
    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();
        avionP38.mover(delta, keyboard);
        for (int i = 0; i < BattleOfMidway.municionAmiga.size(); i++) {
            BattleOfMidway.municionAmiga.get(i).setPosition(municionAmiga.get(i).getX(), municionAmiga.get(i).getY() - 5);
//            if (DetectorColiciones.detectarColicion(municionAmiga.get(i), avionEnemigos.get(i) , i)){
//                municionAmiga.removeElementAt(i);
//                municionAmiga.trimToSize();
//                avionEnemigos.removeElementAt(i);
//                avionEnemigos.trimToSize();
//            }
        }
        for (Municion municion: municionAmiga) {
            int resultado = DetectorColiciones.detectarColicion(municion);
            if (resultado != -1){
                avionEnemigos.remove(resultado);
//                municionAmiga.remove(municion);
            }
        }
        avionEnemigos.removeIf(avionEnemigo -> DetectorColiciones.detectarColicion(avionP38));
        for (Municion municion : municionEnemiga) {
            municion.setPosition(municion.getX(), municion.getY() + 5);
        }
        for (AvionEnemigo avionEnemigo : avionEnemigos){
            avionEnemigo.setPosition(avionEnemigo.getX() + 1, avionEnemigo.getY() + 1);
        }
    }

    public void gameDraw(Graphics2D g) {
        g.drawImage(img_fondo, 0, 0, null);// imagen de fondo
        avionP38.draw(g);
        for (Municion bala : municionAmiga) {
            bala.draw(g);
        }
        for (AvionEnemigo plane : avionEnemigos) {
            plane.draw(g);
        }
//        for (int i = 0; i < BattleOfMidway.municionAmiga.size(); i++) {
//            municionAmiga.get(i).draw(g);
//        }
//        for (int i = 0;i<avionEnemigos.size();i++){
//            avionEnemigos.get(i).draw(g);
//        }

    }
    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    public static void main(String[] args) {
        BattleOfMidway battleOfMidway = new BattleOfMidway();
        battleOfMidway.run(1.0/60.0);
    }
}