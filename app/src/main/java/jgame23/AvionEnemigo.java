package jgame23;

import com.entropyinteractive.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class AvionEnemigo extends Enemigo{
    BufferedImage picture;
    Point2D.Double position = new Point2D.Double();
    public AvionEnemigo(String filename){
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filename)));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setPosition( getHeight() / 2,getWidth() / 2);
    }
    @Override
    public void disparar() {
        super.disparar();
    }

    @Override
    public void mover(double delta, Keyboard keyboard) {}

    @Override
    public double getCoordenadas() {
        return 0;
    }
    public void draw(Graphics2D g) {
        super.draw(g);
    }
}
