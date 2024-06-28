import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private final static GUI gui = new GUI() {};

    public TicTacToe() {
        setVisible(true);
        setResizable(false);

        setSize(618, 642);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 300, dimension.height / 2 - 300);

        setTitle("Tic Tac Toe");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(gui);
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
    }
}
