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
    private int enegia = 100;
    private long time, lastTime;

    public Avion_p38(String file) {
        super(file);
        try {
            this.setImagen(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file))));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        time = 0;
        lastTime = System.currentTimeMillis();
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
//            out.println(this.getX());
//            out.println(this.getY());
        }
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (keyboard.isKeyPressed(KeyEvent.VK_Z) && time > 300){
            gun.disparar(this);
            time = 0;

        }
        if (keyboard.isKeyPressed(KeyEvent.VK_H)){
            BattleOfMidway.addAvionEnemigoArrayList(new AvionEnemigo("imagenes/avionEnemigo.png"));
        }
        // Esc fin del juego
        LinkedList< KeyEvent > keyEvents = keyboard.getEvents();
        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) &&
                    (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
                exit(0);
            }
        }
    }

    public void hit(){
        this.enegia = this.enegia - 1;
    }
    public void superHit(){
        this.enegia = this.enegia - 5;
    }
    public void crash(){
        this.enegia = this.enegia - 10;
    }
    public int getEnegia(){
        return Math.max(enegia, 0);
    }
    public void setEnegia(int enegia){
        if (this.enegia + enegia > 100){
            this.enegia = 100;
        }else {
            this.enegia += enegia;
        }
    }

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
