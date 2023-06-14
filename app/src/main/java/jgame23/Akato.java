package jgame23;

import com.entropyinteractive.Keyboard;

import java.awt.*;

public class Akato extends Enemigo{

    public Akato(String file) {
        super(file);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {}

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
