package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.frameWidth;

public class JNumButton extends JButton {

    public JNumButton(String name, Color backColor, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 22));
        this.setForeground(Color.white);
        this.setBackground(backColor); // steelColor
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setMinimumSize(new Dimension(frameWidth / 5, 40));
        this.setMaximumSize(new Dimension(frameWidth / 5 * 2 + 20, 60));
        this.addActionListener(listener);
    }
}

