package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;

public class JOprButton extends JButton {

    public JOprButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 18));
        this.setForeground(sazeracColor);
        this.setBackground(charcoalColor); // default charcoalColor
        this.setBorder(new LineBorder(bunkerColor));
        this.setMinimumSize(new Dimension(60, 40));
        this.setMaximumSize(new Dimension(300, 60));
        this.addActionListener(listener);
    }
}
