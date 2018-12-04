package gameEngine;

import javax.swing.*;
import java.awt.*;

public class Tilemap extends Matrix {

    private Image[] images;
    private int[][] map;

    public Tilemap(int _w, int _h, int _s, Image[] _i/*, int[][] _m*/) {
        super(_w, _h, _s);
        this.images = _i;
        this.map = /*_m;*/ new int[_w][_h];
        this.map[4][4] = 1; this.map[4][5] = 1;
    }

    public void drawTiles(Graphics g) {

        for (int y = 0; y < (this.height/this.tileize)+1; y++) {
            for (int x = 0; x < (this.width/this.tileize)+1; x++) {

                if (map[y][x] != 0) // TODO v [map[y][x]]
                    g.drawImage(this.images[0], x*this.tileize, y*this.tileize, null);
            }
        }

    }
}
