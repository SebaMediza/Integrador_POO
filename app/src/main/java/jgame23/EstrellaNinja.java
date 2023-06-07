package jgame23;

import com.entropyinteractive.Keyboard;

public class EstrellaNinja extends Power_up{
    public EstrellaNinja(String filename) {
        super(filename);
    }

    @Override
    public void activar(Avion_p38 avionP38) {
        avionP38.setEnegia(100);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {}

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
