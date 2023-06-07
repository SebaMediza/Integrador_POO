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

    public void desactivar(){
        activo = false;
    }

    public int getDuracion(){
        return duracion;
    }

    public void setDuracion(int duracion){
        this.duracion = duracion;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }
}
