package jgame23;

import java.util.Vector;

public abstract class ContenedorGrafico {

    public static Vector<ObjetoGrafico> municionAmiga = new Vector<>();
    public static Vector<ObjetoGrafico> municionEnemiga = new Vector<>();
    public static  Vector<ObjetoGrafico> avionEnemigos = new Vector<>();

    public static void addMunicionAmiga(ObjetoGrafico objetoGrafico){
        municionAmiga.add(objetoGrafico);
    }

    public static void addMunicionEnemiga(ObjetoGrafico objetoGrafico){
        municionEnemiga.add(objetoGrafico);
    }
    public static void addAvionEnemigo(ObjetoGrafico objetoGrafico){
        avionEnemigos.add(objetoGrafico);
    }

}
