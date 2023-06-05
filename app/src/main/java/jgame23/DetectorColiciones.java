package jgame23;

import java.awt.*;

public abstract class DetectorColiciones extends Rectangle {
    private static boolean colicion = false;
    public static boolean detectarColicion(Avion_p38 avionP38){
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigos) {
            colicion = false;
            Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
            if (objeto1.intersects(objeto2)) {
                colicion = true;
                avionP38.crash();
            }
        }
        return colicion;
    }

    public static int detectarColicion(Municion objetoGrafico1){
        int valor = -1;
        boolean checkColicion=false;
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigos) {
            Rectangle objeto1 = new Rectangle((int) objetoGrafico1.getX(), (int) objetoGrafico1.getY(), (int) objetoGrafico1.getWidth(), (int) objetoGrafico1.getHeigth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
            if (objeto1.intersects(objeto2)) {
                checkColicion = true;
                System.out.println(BattleOfMidway.avionEnemigos.size());
                valor = BattleOfMidway.avionEnemigos.indexOf(plane);
            }
        }
//        return checkColicion;
        return valor;
    }
    public static int detectarColicion(Municion municion, Avion_p38 avionP38){
        int index = -1;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        Rectangle objeto2 = new Rectangle((int) municion.getX(), (int) municion.getY(), (int) municion.getHeigth(), (int) municion.getWidth());
        if (objeto2.intersects(objeto1)){
            avionP38.hit();
            BattleOfMidway.municionEnemiga.indexOf(municion);
        }
        return index;
    }
    public static void detectarColicionesBala(Avion_p38 avionP38){
        int index = -1;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        for (Municion municion : BattleOfMidway.municionAmiga) {
            Rectangle objeto2 = new Rectangle((int) municion.getX(), (int) municion.getY(), (int) municion.getHeigth(), (int) municion.getWidth());
            if (objeto2.intersects(objeto1)) {
                avionP38.hit();
                index = BattleOfMidway.municionAmiga.indexOf(municion);
            }
            BattleOfMidway.municionEnemiga.remove(index);
        }
    }
    public static void detectarColiciones(Avion_p38 avionP38){
        int index = -1;
        Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
        for (Misil misil: BattleOfMidway.misilEnemigo){
            Rectangle objeto2 = new Rectangle((int) misil.getX(), (int) misil.getY(), (int) misil.getHeigth(), (int) misil.getWidth());
            if (objeto2.intersects(objeto1)){
                index = BattleOfMidway.misilEnemigo.indexOf(misil);
            }
        }
        BattleOfMidway.misilEnemigo.remove(index);
    }
}
