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
    final double NAVE_DESPLAZAMIENTO=350.0;
    BufferedImage imagen = null;
    private final Point2D.Double posicion = new Point2D.Double();
    private final ArmaGenerica gun = new ArmaGenerica();
    private int enegia = 100;
    private long time, lastTime;


    int xMin = 0;
    int yMin = 27;
    int xMax = 495;
    int yMax = 695;

    private boolean inclinadoIzquierda = false;
    private boolean inclinadoDerecha = false;
    BufferedImage imagenincliizqui;
    BufferedImage imageninclidere;

    public Avion_p38(String file) {
        super(file);
        try {
            this.setImagen(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file))));
            imagenincliizqui = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/inclinacionIzquierda.png")));
            imageninclidere = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("imagenes/inclinacionDerecha.png")));
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
        if(inclinadoIzquierda){
            g.drawImage(imagenincliizqui, (int) posicion.getX(), (int) posicion.getY(), null);
        } else if(inclinadoDerecha){
            g.drawImage(imageninclidere, (int) posicion.getX(), (int) posicion.getY(), null);
        } else {
            g.drawImage(imagen, (int) posicion.getX(), (int) posicion.getY(), null);
        }
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {
        // Procesar teclas de direccion
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
            //shipY -= NAVE_DESPLAZAMIENTO * delta;
            int nuevaY = (int) (this.getY() - NAVE_DESPLAZAMIENTO * delta);
            if(nuevaY >= yMin){
                this.setY(nuevaY);
            }    
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            //shipY += NAVE_DESPLAZAMIENTO * delta;
            int nuevaY = (int) (this.getY() + NAVE_DESPLAZAMIENTO * delta);
            if (nuevaY <= yMax){
                this.setY(nuevaY);
            }
        }
        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)){
            ///shipX -= NAVE_DESPLAZAMIENTO * delta;
            int nuevaX = (int) (this.getX() - NAVE_DESPLAZAMIENTO * delta);
            if (nuevaX >= xMin){
                this.setX(nuevaX);
                inclinadoIzquierda = true;
                inclinadoDerecha = false;
            }
        }else if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)){
            //shipX += NAVE_DESPLAZAMIENTO * delta;
            int nuevaX = (int) (this.getX() + NAVE_DESPLAZAMIENTO * delta);
            if (nuevaX <= xMax){
                this.setX(nuevaX);
                inclinadoIzquierda = false;
                inclinadoDerecha = true;
            }
        }else{
            inclinadoIzquierda = false;
            inclinadoDerecha = false;
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
