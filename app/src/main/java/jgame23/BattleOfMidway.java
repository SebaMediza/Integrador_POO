package jgame23;

import com.entropyinteractive.*;  //jgame
import java.awt.*;
import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes
import java.awt.Graphics2D;
import java.util.*;

public class BattleOfMidway extends JGame{
    Date dInit = new Date();
    Date dAhora;
    //SimpleDateFormat ft = new SimpleDateFormat ("mm:ss");
    BufferedImage img_fondo = null;
    Avion_p38 avionP38 = new Avion_p38();


    public BattleOfMidway() {
        super("Battle Of Midway", 550, 1300);
        System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        try{
            img_fondo= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/fondo2.png")));
            avionP38.setImagen(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/avionp38.png"))));
            avionP38.setPosicion((double) getWidth() / 2,(double) getHeight() / 2 );
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();
        avionP38.mover(delta,keyboard);
    }

    public void gameDraw(Graphics2D g) {
        /*dAhora= new Date( );
        long dateDiff = dAhora.getTime() - dInit.getTime();
        long diffSeconds = dateDiff / 1000 % 60;
        long diffMinutes = dateDiff / (60 * 1000) % 60;
        g.setColor(Color.black);
        g.drawString("Tiempo de Juego: "+diffMinutes+":"+diffSeconds,12,42);
        g.drawString("Tecla ESC = Fin del Juego ",592,42);
        g.setColor(Color.white);
        g.drawString("Tiempo de Juego: "+diffMinutes+":"+diffSeconds,10,40);
        g.drawString("Tecla ESC = Fin del Juego ",590,40);*/
        g.drawImage(img_fondo,0,0,null);// imagen de fondo
        avionP38.draw(g);
    }

    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    public static void main(String[] args) {
        new BattleOfMidway();
    }
}