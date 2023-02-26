package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;

public class JMemButton extends JButton {

    public JMemButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 18));
        this.setForeground(Color.white);
        this.setBorder(new LineBorder(Color.darkGray));
        this.setBackground(charcoalColor); // charcoalColor
        this.setMinimumSize(new Dimension(60, 40));
        this.setMaximumSize(new Dimension(300, 60));
        this.addActionListener(listener);
    }

}
