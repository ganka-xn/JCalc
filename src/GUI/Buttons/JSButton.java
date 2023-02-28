package GUI.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static GUI.ColorLib.*;
import static GUI.JCalcVars.frameWidth;

public class JSButton extends JButton {

    public JSButton(String name, ActionListener listener) {

        this.setText(name);
        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 22));
        this.setForeground(Color.white);
        this.setBackground(lightningYellowColor); // default charcoalColor
        this.setBorder(new LineBorder(bunkerColor));
        this.setMinimumSize(new Dimension(frameWidth / 5, 40));
        this.setMaximumSize(new Dimension(frameWidth / 5 * 2 + 20, 60));
        this.addActionListener(listener);
    }
}
