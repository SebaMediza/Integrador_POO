package jgame23;

import com.entropyinteractive.Keyboard;

public class BarcoEnemigo extends Enemigo{
    public BarcoEnemigo(String filename) {
        super(filename);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {

    }

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
