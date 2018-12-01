import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {

        add( new Board() ); // Here we put the Board to the center of the JFrame container.
        pack(); // set the size of this.JFrame to his child JPanel "Board"
        //setResizable(false);

        setTitle("Robot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
