import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateLoseOrWinFon {
    private final static JLabel winLabel = new JLabel("You win!");
    private final static JLabel loseLabel = new JLabel("You lose!");
    private final static JLabel tieLabel = new JLabel("Game is tie");
    private final static JButton resetButton = new JButton("Restart");

    public CreateLoseOrWinFon(GUI gui, String value, JButton[][] buttons) {
        if (value.equals("X")) {
            winLabel.setBounds(142, 150, 400, 80);
            winLabel.setForeground(Color.lightGray);
            winLabel.setFont(Config.labelsFont);
            gui.add(winLabel);
        }
        else {
            loseLabel.setBounds(142, 150, 400, 80);
            loseLabel.setForeground(Color.lightGray);
            loseLabel.setFont(Config.labelsFont);
            gui.add(loseLabel);
        }
        if (!buttons[0][0].isEnabled() && !buttons[0][1].isEnabled() && !buttons[0][2].isEnabled()
                && !buttons[1][0].isEnabled() && !buttons[1][1].isEnabled() && !buttons[1][2].isEnabled()
                && !buttons[2][0].isEnabled() && !buttons[2][1].isEnabled() && !buttons[2][2].isEnabled()) {
            tieLabel.setBounds(142, 150, 400, 80);
            tieLabel.setForeground(Color.lightGray);
            tieLabel.setFont(Config.labelsFont);
            gui.add(tieLabel);
        }

        resetButton.setBounds(130, 300, 350, 100);
        resetButton.setBackground(Color.green);
        resetButton.setForeground(Color.black);
        resetButton.setFont(Config.cellFont);
        gui.add(resetButton);

        resetButton.addActionListener(new ActionListener() {    // Анонимный класс для действий при нажатии кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.remove(resetButton);
                gui.remove(winLabel);
                for(int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        buttons[x][y].setBounds(x * 200, y * 200, 200, 200);
                    }
                }
            }
        });
    }
}
