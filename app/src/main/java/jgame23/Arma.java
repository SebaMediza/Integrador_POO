package jgame23;
import java.awt.Graphics2D;

public abstract class Arma {
    protected int danio;
    protected int alcance;

    public void dispararP38(){
        Municion bala = new Municion("imagenes/municion.png");
        BattleOfMidway.addMunicionAmiga(bala);

    }
}
