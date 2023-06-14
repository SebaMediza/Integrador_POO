package jgame23;

import com.entropyinteractive.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class AvionEnemigo extends Enemigo{
    private long time, lastTime;
    public AvionEnemigo(String filename){
        super(filename);
        this.setPosition ((getHeight() / 2) + 100, (getWidth() / 2) + 100);
        time = 0;
        lastTime = System.currentTimeMillis();
    }
    @Override
    public void disparar() {
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(time > 1000) {
            super.disparar();
            time = 0;
        }
    }
    public void disparaMisil(){
        super.dispararMisil();
    }
    @Override
    public void mover(double delta, Keyboard keyboard) {}
    @Override
    public double getCoordenadas() {
        return 0;
    }
    public void draw(Graphics2D g) {
        super.draw(g);
    }
}
