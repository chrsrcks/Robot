package gameEngine;

import javax.swing.*;
import java.awt.*;

public class Tilemap {

    private final int width;
    private final int height;
    private final int tileize;
    public boolean debug=true;
    // TODO private Image[] images;

    public Tilemap(int _w, int _h, int _s) { // TODO Image[] _i
        this.width = _w;
        this.height = _h;
        this.tileize = _s;
        // TODO this.images = _i;
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

        for (int y = 0; y < (this.height/this.tileize)+1; y++) {
            for (int x = 0; x < (this.width/this.tileize)+1; x++) {
                g2d.setColor(Color.gray);
                g2d.drawRect(x*this.tileize, y*this.tileize, this.tileize, this.tileize);
                if (this.debug) {
                    g2d.setColor(Color.red);
                    g2d.drawString(" x: " + x + " y: " + y, x * this.tileize, y * this.tileize + 20);
                    g2d.drawString(" index: " + (y * (this.width / this.tileize) + x), x * this.tileize, y * this.tileize + 40);
                }
            }
        }

    }
}
