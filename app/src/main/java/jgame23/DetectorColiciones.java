package jgame23;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public abstract class DetectorColiciones extends Rectangle {
    private static boolean colicion = false;

    public static boolean detectarColicion(Municion objetoGrafico1, AvionEnemigo objetoGrafico2, int nro_bala){
        colicion = false;
        Rectangle objeto1 = new Rectangle((int) objetoGrafico1.getX(),(int) objetoGrafico1.getY(),(int) objetoGrafico1.getWidth(), (int) objetoGrafico1.getHeigth());
        Rectangle objeto2 = new Rectangle((int) objetoGrafico2.getX(),(int) objetoGrafico2.getY(),(int) objetoGrafico1.getHeigth(),(int) objetoGrafico1.getWidth());
//        Rectangle objeto2 = new Rectangle();
        if (objeto1.intersects(objeto2)) {
            colicion = true;
            System.out.println("hit");
        }
        return colicion;
    }

    public static boolean detectarColicion(Avion_p38 avionP38){
        int valor = -1;
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigos) {
            colicion = false;
            Rectangle objeto1 = new Rectangle((int) avionP38.getX(), (int) avionP38.getY(), (int) avionP38.getHeigth(), (int) avionP38.getWidth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
//        Rectangle objeto2 = new Rectangle();
            if (objeto1.intersects(objeto2)) {
                colicion = true;
//                BattleOfMidway.avionEnemigos.remove(plane);
//                System.out.println("hit");
//                System.out.println(BattleOfMidway.avionEnemigos.size());
//                valor = BattleOfMidway.avionEnemigos.indexOf(plane);
            }
        }
        return colicion;
//        return valor;

    }

    public static int detectarColicion(Municion objetoGrafico1){
        int valor = -1;
        for (AvionEnemigo plane: BattleOfMidway.avionEnemigos) {
//            colicion = false;
            Rectangle objeto1 = new Rectangle((int) objetoGrafico1.getX(), (int) objetoGrafico1.getY(), (int) objetoGrafico1.getWidth(), (int) objetoGrafico1.getHeigth());
            Rectangle objeto2 = new Rectangle((int) plane.getX(), (int) plane.getY(), (int) plane.getHeigth(), (int) plane.getWidth());
//        Rectangle objeto2 = new Rectangle();
            if (objeto1.intersects(objeto2)) {
                colicion = true;
//                BattleOfMidway.avionEnemigos.remove(plane);
                System.out.println("hit");
                System.out.println(BattleOfMidway.avionEnemigos.size());
                valor = BattleOfMidway.avionEnemigos.indexOf(plane);
            }
        }
//        return colicion;
        return valor;
    }
}
