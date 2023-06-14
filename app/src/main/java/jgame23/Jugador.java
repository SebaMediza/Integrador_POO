package jgame23;

public class Jugador {

    public static String nombre;
    public static int puntuacion;

    public Jugador(String nombreParametro, int puntuacionParametro){
        nombre = nombreParametro;
        puntuacion = puntuacionParametro;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreParametro) {
        nombre = nombreParametro;
    }

    public static int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacionParametro) {
        puntuacion = puntuacionParametro;
    }
}
