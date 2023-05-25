package jgame23;

public abstract class Arma {
    protected int danio;
    protected int alcance;

    public void disparar(){
        Municion bala = new Municion("src/main/resources/imagenes/municion.png");
    }
}
