package jgame23;

import com.entropyinteractive.Keyboard;

public class AvionEnemigo extends Enemigo{

    public AvionEnemigo(){}
    @Override
    protected void disparar() {
        super.disparar();
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {}

    @Override
    public double getCoordenadas() {
        return 0;
    }
}
