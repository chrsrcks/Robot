package gameEngine;

import java.awt.*;

public class GameObject {

    public int x; public int y; // x, y position
    private Image img;
    public int imgW; public int imgH; // width, height of image
    public int speed;
    protected int dx=0; // direction x
    protected int dy=0; // direction y

    public GameObject(int _x, int _y, Image _img, int _imgW, int _imgH, int _speed) {
        this.x = _x;
        this.y = _y;
        this.img = _img;
        this.imgW = _imgW;
        this.imgH = _imgH;
        this.speed = _speed;
    }

    public void draw(Graphics g) {

        g.drawImage(this.img, this.x - (this.imgW/2), this.y - (this.imgH/2), null);
    }

    public void update() {

        int speed;

        if (this.dx != 0 && this.dy != 0) speed = this.speed / 2;
        else speed = this.speed;

        this.x += this.dx * speed;
        this.y += this.dy * speed;

    }

    /*public void tryMove(int _dirX, int _dirY) {

        this.x += _dirX * this.speed;
        this.y += _dirY * this.speed;

    }*/


}
