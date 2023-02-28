package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;
import static GUI.JCalcVars.frameWidth;

public class JOprButton extends JButton {

    public JOprButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 17));
        this.setForeground(sazeracColor);
        this.setBackground(charcoalColor); // default charcoalColor
        this.setBorder(new LineBorder(bunkerColor));
        this.setMinimumSize(new Dimension(frameWidth / 6, 40));
        this.setMaximumSize(new Dimension(frameWidth / 5 + 5, 60));
        this.addActionListener(listener);
    }
}
