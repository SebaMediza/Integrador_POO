package jgame23;

public abstract class DetectorColiciones {
    private boolean colicion = false;
    public boolean detectarColicion(ObjetoGrafico objetoGrafico1, ObjetoGrafico objetoGrafico2){
        if (objetoGrafico1.getX() == objetoGrafico2.getX() && objetoGrafico1.getY() == objetoGrafico2.getY()){
            colicion = true;
        }
    return colicion;
    }
}
