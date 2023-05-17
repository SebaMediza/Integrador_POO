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

    public getDuracion(){
        return duracion;
    }

    public setDuracion(int duracion){
        this.duracion = duracion;
    }

    public isActivo(){
        return activo;
    }

    public setActivo(boolean activo){
        this.activo = activo;
    }

}
