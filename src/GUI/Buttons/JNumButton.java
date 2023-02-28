package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;
import static GUI.JCalcVars.frameWidth;

public class JNumButton extends JButton {

    public JNumButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 22));
        this.setForeground(Color.white);
        this.setBackground(steelColor); // steelColor
        this.setBorder(new LineBorder(Color.darkGray));
        this.setMinimumSize(new Dimension(frameWidth / 5, 40));
        this.setMaximumSize(new Dimension(frameWidth / 5 * 2 + 20, 60));
        this.addActionListener(listener);
    }
}

