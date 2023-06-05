package jgame23;

public class Auto extends Power_up{

    public double newVelocidad;

    public Auto(int duracion, double newVelocidad){
        super(duracion);
        this.newVelocidad = newVelocidad;
    }

    @Override
    public void activar(){

    }

    public void desactivar(){
        super.desactivar();
    }

}
