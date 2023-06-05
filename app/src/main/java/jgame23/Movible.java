package jgame23;

import com.entropyinteractive.Keyboard;

public interface Movible {
    void mover(double delta, Keyboard keyboard);
    double getCoordenadas();
}
