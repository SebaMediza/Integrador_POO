package jgame23;

import java.awt.*;

public abstract class Power_up extends Bonus {
    protected int duracion = 20;
    protected boolean activo;
    protected int salud;

    public Power_up(String filename){
        super(filename);
    }

    protected void activar(Avion_p38 avionP38) {}

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
    }

}
