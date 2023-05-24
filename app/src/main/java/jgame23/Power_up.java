package jgame23;

public abstract class Power_up {
    protected int duracion = 20;
    protected boolean activo;

    public Power_up(int duracion){
        this.duracion = duracion;
        this.activo = false;
    }

    public abstract void activar();

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
