package gameEngine;

import java.awt.*;

public class Matrix {

    protected final int width;
    protected final int height;
    protected int tileize;
    public boolean debug=false;

    public Matrix(int _w, int _h, int _s) {
        this.width = _w;
        this.height = _h;
        this.tileize = _s;
    }

    public void drawDebug(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (this.debug) {

            g2d.setStroke(new BasicStroke(1));

            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {

                    g2d.setColor(Color.gray);
                    g2d.drawRect(x*this.tileize, y*this.tileize, this.tileize, this.tileize);

                    g2d.setColor(Color.green);
                    g2d.drawString(" x: " + x + " y: " + y, x * this.tileize, y * this.tileize + 20);
                    //g2d.drawString("ASC index: " + (y * (this.width / this.tileize) + x), x * this.tileize, y * this.tileize + 40);

                }
            }
        }

    }
}
