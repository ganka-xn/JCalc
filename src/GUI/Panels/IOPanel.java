package GUI.Panels;

import GUI.ColorLib;
//import GUI.Excluded.InputKeyListener;
import GUI.Display;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

import static GUI.JCalcVars.frameWidth;

public class IOPanel extends JPanel {

    public JTextField fieldX;
    public Display display;

    public IOPanel() {

        display = new Display();

        setLayout(new MigLayout(
                "insets 5 5 2 5,hidemode 3,alignx center,gap 10 0",
                // columns
                "[fill]",
                // rows
                "[fill]"));

        // Content
        fieldX = new JTextField(16);
        fieldX.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 36));
        fieldX.setForeground(ColorLib.sazeracColor);

        Font font = fieldX.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);
        fieldX.setFont(font.deriveFont(attributes));

        fieldX.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldX.setMinimumSize(new Dimension(frameWidth, 50));
        fieldX.setMaximumSize(new Dimension(frameWidth, 50));
        fieldX.setBorder(new EmptyBorder(0, 0, 0, 0));
        fieldX.setText("0");
        fieldX.setEditable(false);
        add(fieldX, "cell 0 0,alignx right,growx 0");
//        fieldX.addKeyListener(new InputKeyListener());

    }

}
