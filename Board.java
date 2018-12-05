import gameEngine.Player;
import gameEngine.Tilemap;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

    private final int DELAY  = 10;
    private Thread animator;
    private int width = 640;
    private int height = 448;
    private Image img;
    private Player player;
    private Tilemap tilemap;
    private Image tile;
    int[][] starPos;
    private boolean pause=false;

    public Board() {

        setFocusable(true);
        addKeyListener(new Input());
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);

        loadImage();
        int imgW = img.getWidth(this);
        int imgH =  img.getHeight(this);
        player = new Player(width/2,height/2,img,imgW,imgH,2);

        tilemap = new Tilemap(10, 7,64, new Image[]{tile});

        starPos = new int[20][2];
        for (int i = 0; i < starPos.length; i++) {

            starPos[i][0] = (int) (Math.random() * width);
            starPos[i][1] = (int) (Math.random() * height);
        }

    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    } // start new thread

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            update();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0)  sleep = 2;

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    } // run update & repaint

    private void update() {
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStars(g);
        tilemap.drawTiles(g);
        player.draw(g);

        tilemap.drawDebug(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/assets/robot.png");
        img = ii.getImage();
        ii = new ImageIcon("src/assets/platform.png");
        tile = ii.getImage();
    }


    private void drawStars(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        for (int i = 0; i < starPos.length; i++) {

            g2d.setColor(Color.white);
            g2d.setStroke(new BasicStroke(i % 4));
            g2d.drawLine(starPos[i][0], starPos[i][1], starPos[i][0], starPos[i][1]);
        }

    }


    private class Input extends KeyAdapter {

        private boolean strgHold;

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_CONTROL) strgHold = true;
            if (key == KeyEvent.VK_D && strgHold) tilemap.debug = !tilemap.debug;
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_CONTROL) strgHold = false;
        }

    }


}