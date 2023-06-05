package jgame23;

import com.entropyinteractive.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Objects;

import static java.lang.System.*;

class Avion_p38 extends ObjetoGrafico implements Movible {
    final double NAVE_DESPLAZAMIENTO=150.0;
    BufferedImage imagen = null;
    private final Point2D.Double posicion = new Point2D.Double();
    private final ArmaGenerica gun = new ArmaGenerica();

    public Avion_p38() {
        try {

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void setImagen(BufferedImage img) {
        this.imagen = img;
    }
    public void setPosicion(double x, double y) {
        posicion.setLocation(x, y);
    }
    public void setX(double x) {
        posicion.x = x;
    }
    public void setY(double y) {
        posicion.y = y;
    }
    public double getX() {
        return posicion.getX();
    }
    public double getY() {
        return posicion.getY();
    }
    public void update(double delta) {}
    public void draw(Graphics2D g) {
        g.drawImage(imagen, (int) posicion.getX(), (int) posicion.getY(), null);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {
        // Procesar teclas de direccion
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
            this.setY(this.getY() - NAVE_DESPLAZAMIENTO * delta);
            //shipY -= NAVE_DESPLAZAMIENTO * delta;
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            //shipY += NAVE_DESPLAZAMIENTO * delta;
            this.setY(this.getY() + NAVE_DESPLAZAMIENTO * delta);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)){
            ///shipX -= NAVE_DESPLAZAMIENTO * delta;
            this.setX(this.getX() - NAVE_DESPLAZAMIENTO * delta);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)){
            //shipX += NAVE_DESPLAZAMIENTO * delta;
            this.setX(this.getX() + NAVE_DESPLAZAMIENTO * delta);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_Z)){
            gun.disparar(this);
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_H)){
            for (int i=0;i<10;i++){
                BattleOfMidway.addAvionEnemigo(new AvionEnemigo("imagenes/avionEnemigo.png"));
            }
            out.println(BattleOfMidway.avionEnemigos.size());
        }
        // Esc fin del juego
        LinkedList< KeyEvent > keyEvents = keyboard.getEvents();
        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) &&
                    (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
                exit(0);
            }
        }
        this.update(delta);
    }

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
