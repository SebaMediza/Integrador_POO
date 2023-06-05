package jgame23;


//public class Pow {

import com.entropyinteractive.Keyboard;

public class Pow extends Power_up{
    
    public Pow(int salud) {
        super();
    }

    @Override
    protected void activar(Avion_p38 avionP38) {
        avionP38.setEnegia(25);
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {

    }

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
