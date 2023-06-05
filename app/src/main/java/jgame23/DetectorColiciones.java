package jgame23;

import java.awt.*;

public abstract class DetectorColiciones extends Rectangle {
    private static boolean colicion = false;
    public static boolean detectarColicion(Avion_p38 avionP38){
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigoArrayList) {
            colicion = false;
            Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
            if (objeto1.intersects(objeto2)) {
                colicion = true;
                avionP38.crash();
                BattleOfMidway.finalScore += 1000;
            }
        }
        return colicion;
    }
    public static int detectarColicion(Municion objetoGrafico1){
        int valor = -1;
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigoArrayList) {
            Rectangle objeto1 = new Rectangle((int) objetoGrafico1.getX(), (int) objetoGrafico1.getY(), (int) objetoGrafico1.getWidth(), (int) objetoGrafico1.getHeigth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
            if (objeto1.intersects(objeto2)) {
                System.out.println(BattleOfMidway.avionEnemigoArrayList.size());
                valor = BattleOfMidway.avionEnemigoArrayList.indexOf(plane);
                BattleOfMidway.finalScore += 1000;
            }
        }
        return valor;
    }
    public static boolean detectarColicion(Municion municion, Avion_p38 avionP38){
        boolean colicion = false;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        Rectangle objeto2 = new Rectangle((int) municion.getX(), (int) municion.getY(), (int) municion.getHeigth(), (int) municion.getWidth());
        if (objeto2.intersects(objeto1)){
            avionP38.hit();
            colicion = true;
        }
        return colicion;
    }
    public static boolean detectarColicion(Municion municionAmiga, Municion municionEnemiga){
        boolean colicion = false;
        Rectangle objeto1 = new Rectangle((int) municionAmiga.getX(), (int) municionAmiga.getY(), (int) municionAmiga.getHeigth(), (int) municionAmiga.getWidth());
        Rectangle objeto2 = new Rectangle((int) municionEnemiga.getX(), (int) municionEnemiga.getY(), (int) municionEnemiga.getHeigth(), (int) municionEnemiga.getWidth());
        if (objeto1.intersects(objeto2)){
            colicion = true;
            BattleOfMidway.finalScore += 500;
        }
        return colicion;
    }
    /*
    public static void detectarColicionesBala(Avion_p38 avionP38){
        int index = -1;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        for (Municion municion : BattleOfMidway.municionAmigaArrayList) {
            Rectangle objeto2 = new Rectangle((int) municion.getX(), (int) municion.getY(), (int) municion.getHeigth(), (int) municion.getWidth());
            if (objeto2.intersects(objeto1)) {
                avionP38.hit();
                index = BattleOfMidway.municionAmigaArrayList.indexOf(municion);
            }
            BattleOfMidway.municionEnemigaArrayList.remove(index);
        }
    }
    public static void detectarColiciones(Avion_p38 avionP38){
        int index = -1;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        for (Misil misil: BattleOfMidway.misilArrayList){
            Rectangle objeto2 = new Rectangle((int) misil.getX(), (int) misil.getY(), (int) misil.getHeigth(), (int) misil.getWidth());
            if (objeto2.intersects(objeto1)){
                index = BattleOfMidway.misilArrayList.indexOf(misil);
            }
        }
        BattleOfMidway.misilArrayList.remove(index);
    }
    */
}
