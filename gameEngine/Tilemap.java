package gameEngine;

import javax.swing.*;
import java.awt.*;

public class Tilemap {

    private final int width;
    private final int height;

    public Tilemap(int _w, int _h) {
        this.width = _w;
        this.height = _h;
    }

    /*public Tilemap(JPanel parent) {
        Dimension size = parent.getSize();
        this.width = (int)size.getWidth();
        this.height = (int)size.getHeight();
    }*/

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        /*RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);*/

        g2d.setStroke(new BasicStroke(1));

        for (int y = 0; y < (this.height/50); y++) {
            for (int x = 0; x < (this.width/50); x++) {
                g2d.setColor(Color.gray);
                g2d.drawRect(x*50, y*50, 50, 50);
                g2d.setColor(Color.red);
                g2d.drawString("x: "+ x +" y: "+ y,x*50, y*50+20);
                g2d.drawString(" index: "+ (y*(this.width/50)+x),x*50, y*50+40);
            }
        }

    }
}
