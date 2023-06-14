package jgame23;

import com.entropyinteractive.Keyboard;

public class Auto extends Power_up{

    public Auto(String filename) {
        super(filename);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {}

    @Override
    public double getCoordenadas() {
        return 0;
    }

    @Override
    protected void activar(Avion_p38 avionP38) {

    }
}
