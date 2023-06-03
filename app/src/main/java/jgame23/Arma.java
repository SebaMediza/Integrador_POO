package jgame23;
import java.awt.Graphics2D;

public abstract class Arma {
    protected final int danio = 10;
    protected int alcance;

    public void disparar(Avion_p38 plane){
        Municion bala = new Municion("imagenes/municion4.png");
        BattleOfMidway.addMunicionAmiga(bala);
        bala.setPosition(plane.getX() + 18, plane.getY());
    }

    public  void disparar(Enemigo plane){
        Municion bala = new Municion("imagenes/municion4.png");
        BattleOfMidway.addMunicionEnemiga(bala);
        bala.setPosition(plane.getX() + 18, plane.getY());
    }
}
