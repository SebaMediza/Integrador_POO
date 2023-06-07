package jgame23;

import com.entropyinteractive.Keyboard;

import java.awt.*;

public class Misil extends ObjetoGrafico{

    public Misil(String filename) {
        super(filename);
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
