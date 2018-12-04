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
    private int height = 480;
    private Image img;
    private Player player;
    private Tilemap tilemap;
    private Image tile;
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

        tilemap = new Tilemap(width, height,64, new Image[]{tile});

    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) { // draw loop
        super.paintComponent(g);

        //drawDonut(g);
        tilemap.drawTiles(g);
        //tilemap.draw(g);
        player.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }

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
    }

    private void update() {

        player.update();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/assets/robot_64.png");
        img = ii.getImage();
        ii = new ImageIcon("src/assets/platform.png");
        tile = ii.getImage();
    }


    private void drawDonut(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }


    private class Input extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

    }


}