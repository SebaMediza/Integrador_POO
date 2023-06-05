package jgame23;

import java.awt.*;

public abstract class Enemigo extends ObjetoGrafico{
    private ArmaGenerica gun = new ArmaGenerica();
    protected int cantEnergia;
    protected Color colorEnemigo;
    protected void disparar(){
        gun.disparar(this);
    }

    protected void dispararMisil(){
        gun.dispararMisil(this);
    }
}
