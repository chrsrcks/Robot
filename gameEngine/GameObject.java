package gameEngine;

import java.awt.*;

public class GameObject {

    int x; int y;
    Image img;
    int imgW; int imgH;

    public GameObject(int _x, int _y, Image _img, int _imgW, int _imgH) {
        this.x = _x;
        this.y = _y;
        this.img = _img;
        this.imgW = _imgW;
        this.imgH = _imgH;
    }

    public void draw(Graphics g) {

        g.drawImage(this.img, this.x - (this.imgW/2), this.y - (this.imgH/2), null);
    }
}
