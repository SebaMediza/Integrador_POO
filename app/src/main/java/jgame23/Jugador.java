package jgame23;

public class Jugador {

    private String nombre;
    private int puntuacion;

    public Jugador(String nombre){
        this.nombre=nombre;
        this.puntuacion=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
