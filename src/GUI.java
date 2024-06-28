import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GUI extends JPanel implements ActionListener {
    public static int value = 0;

    public final static JButton[][] buttons = new JButton[3][3];

    public GUI() {
        setBounds(0, 0, 617, 642);
        setBackground(Color.black);
        setLayout(null);

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setBounds(x * 200, y * 200, 200, 200);
                buttons[x][y].setBackground(Color.black);
                buttons[x][y].setFont(Config.cellFont);
                buttons[x][y].addActionListener(this);
                add(buttons[x][y]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (value % 2 == 0) {
            button.setText("X");
            button.setUI(new MetalButtonUI() {
                protected Color getDisabledTextColor() {
                    return Color.red;
                }
            });
        } else {
            button.setText("O");
            button.setUI(new MetalButtonUI() {
                protected Color getDisabledTextColor() {
                    return Color.blue;
                }
            });
        }
        button.setEnabled(false);
        value++;

        checkForWinner();
        Bot bot = new Bot();
    }

    private void checkForWinner() {
        // Проверка победы по горизонтали
        for (int i = 0; i < 3; i++) {
            if(buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].isEnabled()) {
                createLoseOrWinFon(buttons[0][i].getText());
            }
        }
        // Проверка победы по вертикали
        for (int i = 0; i < 3; i++) {
            if(buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].isEnabled()) {
                createLoseOrWinFon(buttons[i][0].getText());
            }
        }
        // Проверка победы по диоганали
        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].isEnabled()) {
            createLoseOrWinFon(buttons[0][0].getText());
        }
        if (buttons[2][0].getText().equals(buttons[1][1].getText())
                && buttons[2][0].getText().equals(buttons[0][2].getText()) && !buttons[2][0].isEnabled()) {
            createLoseOrWinFon(buttons[2][0].getText());
        }
    }

    private void resetGame() {
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                buttons[x][y].setBounds(0, 0, 0, 0);
                buttons[x][y].setText("");
                buttons[x][y].setEnabled(true);
            }
        }
    }

    private void createLoseOrWinFon(String value) {
        resetGame();
        new CreateLoseOrWinFon(this, value, buttons);
    }
}
