import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private int width = 640;
    private int height = 480;
    private Image robot;

    public Board() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.DARK_GRAY);

        loadImage();

    }

    @Override
    public void paintComponent(Graphics g) { // draw loop
        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);

        drawDonut(g);
        drawRobot(g);
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("robot.png");
        robot = ii.getImage();
    }

    private void drawRobot(Graphics g) {

        int robotW = robot.getWidth(this);
        int robotH =  robot.getHeight(this);

        g.drawImage(robot, width/2-(robotW/2), height/2-(robotH/2), null);

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
}
