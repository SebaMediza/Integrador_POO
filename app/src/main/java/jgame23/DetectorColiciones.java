package jgame23;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class DetectorColiciones extends Rectangle {
    private static boolean colicion = false;

    public static boolean detectarColicion(ObjetoGrafico objetoGrafico1, Avion_p38 objetoGrafico2){
//        Rectangle objeto1 = new Rectangle((int) objetoGrafico1.getX(),(int) objetoGrafico1.getY(),(int)  objetoGrafico1.getHeigth(), (int) objetoGrafico1.getWidth());
//        Rectangle objeto2 = new Rectangle((int) objetoGrafico2.getX(),(int) objetoGrafico2.getY(),(int)  objetoGrafico2.getHeigth(), (int) objetoGrafico2.getWidth());
//        if (objeto2.intersects(objeto1)) {
//            colicion = true;
//            System.out.println("coco");
//        }
        return colicion;
    }

    public static boolean detectarColicion(ObjetoGrafico objetoGrafico1, Enemigo objetoGrafico2){
        if (objetoGrafico1.getX() == objetoGrafico2.getX() && objetoGrafico1.getY() == objetoGrafico2.getY()){
            colicion = true;
        }
        return colicion;
    }
}
