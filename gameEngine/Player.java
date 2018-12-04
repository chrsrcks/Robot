package gameEngine;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

    public Player(int _x, int _y, Image _img, int _imgW, int _imgH, int _speed) {
        super( _x, _y, _img, _imgW, _imgH, _speed);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) { // left
            this.dx = -1;
        } else if (key == KeyEvent.VK_D) { // right
            this.dx = 1;
        }
        if (key == KeyEvent.VK_W) { // up
            this.dy = -1;
        } else if (key == KeyEvent.VK_S) { // down
            this.dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            this.dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            this.dy = 0;
        }
    }

}