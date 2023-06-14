package jgame23;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemigo extends ObjetoGrafico{

    public Enemigo(String filename) {
        super(filename);
    }

    private ArmaGenerica gun = new ArmaGenerica();
    protected int cantEnergia;
    protected Color colorEnemigo;
    protected double x;
    protected double y;
    protected static double speed;
    protected boolean movingDown;
    protected int maxY;
    protected int minY;
    private BufferedImage imagen;

    public void update(double delta){
        if(movingDown){
            y += speed * delta;
            if(y >= (getHeight() - imagen.getHeight())){
                y = getHeight() - imagen.getHeight();
                movingDown = false;
            }
        } else {
            y -= speed * delta;
            if(y <= 0){
                y = 0;
                movingDown = true;
            }
        }
    }

    // public void mover(double delta){
    //     if(movingDown){
    //         y += speed * delta;
    //         if(y >= maxY){
    //             y = maxY;
    //             movingDown = false;
    //         } else {
    //             y -= speed * delta;
    //             if(y <= minY){
    //                 y = minY;
    //                 movingDown = true;
    //             }
    //         }
    //     }
    // }


    protected void disparar(){
        gun.disparar(this);
    }

    protected void dispararMisil(){
        gun.dispararMisil(this);
    }
}
