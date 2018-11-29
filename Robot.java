import java.awt.EventQueue;
import javax.swing.JFrame;

public class Robot extends JFrame {

    public Robot() {

        initUI();
    }

    private void initUI() {

        add( new Board() ); // Here we put the Board to the center of the JFrame container.
        pack();
        //setResizable(false);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Robot ex = new Robot();
            ex.setVisible(true);
        });
    }
}
