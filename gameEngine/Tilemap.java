package gameEngine;

import java.awt.*;

public class Tilemap extends Matrix {

    private Image[] images;
    private int[][] map;

    public Tilemap(int _w, int _h, int _s, Image[] _i/*, int[][] _m*/) {
        super(_w, _h, _s);
        this.images = _i;
        this.map = /*_m;*/ new int[][]{
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1},
        };
    }

    public void drawTiles(Graphics g) {

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {

                if (map[y][x] != 0) // TODO v [map[y][x]]
                    g.drawImage(this.images[map[y][x]-1], x*this.tileize, y*this.tileize, null);
            }
        }

    }

    public void drawDebug(Graphics g) {
        super.drawDebug(g);

        if (this.debug) {
            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {

                    g.setColor(Color.green);
                    g.drawString("img: " + map[y][x], x * this.tileize, y * this.tileize + 40);
                }
            }
        }


    }
}
