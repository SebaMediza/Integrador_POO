package jgame23;

import java.awt.*;

public abstract class Enemigo extends ObjetoGrafico{

    public Enemigo(String filename) {
        super(filename);
    }

    private ArmaGenerica gun = new ArmaGenerica();
    protected int cantEnergia;
    protected Color colorEnemigo;
    protected double x;
    protected double y;
    protected double speed;
    protected boolean movingDown;
    protected int maxY;
    protected int minY;

    // public Enemigo(double x, double y, double speed) {
    //     this.x = x;
    //     this.y = y;
    //     this.speed = speed;
    //     this.movingDown = true;
    // }

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
