package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;
import static GUI.JCalcVars.frameWidth;

public class JMemButton extends JButton {

    public JMemButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(charcoalColor); // charcoalColor
        this.setBorder(new EmptyBorder(0,0,0,0));
        this.setMinimumSize(new Dimension(frameWidth / 8 , 40));
        this.setMaximumSize(new Dimension(frameWidth / 5, 40));
        this.addActionListener(listener);

    }
}
