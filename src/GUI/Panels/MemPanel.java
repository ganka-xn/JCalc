package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Buttons.ButtonType;
import GUI.Buttons.JOprButton;

import GUI.Listeners.*;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

import static GUI.ColorLib.bunkerColor;
import static GUI.JCalcVars.frameWidth;

public class MemPanel extends JPanel {

/*    // Var
    private JOprButton btnMR;
    private JOprButton btnMPlus;
    private JOprButton btnMMinus;
    private JOprButton btnMC;
    private JOprButton btnLD;
    private JOprButton btnAlt;*/

    // Constructor
    public MemPanel() {

        //======== this ========
        setSize(new Dimension(frameWidth, 60));
        setBackground(bunkerColor);
        setLayout(new MigLayout(
                "insets 0 0 0 0,hidemode 3,gap 1 1",
                // columns
                "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]",
                // rows
                "[grow,fill]"));

        //content
        MemBtnListener memBtnListener = new MemBtnListener();
        LDBtnListener ldBtnListener = new LDBtnListener();
        AltBtnListener altBtnListener = new AltBtnListener();

        ButtonFactory factory = new ButtonFactory();

        add(factory.createButton(ButtonType.JMEMBUTTON, "mr", memBtnListener), "cell 0 0");
        add(factory.createButton(ButtonType.JMEMBUTTON, "m+", memBtnListener), "cell 1 0");
        add(factory.createButton(ButtonType.JMEMBUTTON, "m-", memBtnListener), "cell 2 0");
        add(factory.createButton(ButtonType.JMEMBUTTON, "mc", memBtnListener), "cell 3 0");

        add(factory.createButton(ButtonType.JMEMBUTTON, "L/D", ldBtnListener), "cell 4 0");
        add(factory.createButton(ButtonType.JMEMBUTTON, "Alt", altBtnListener), "cell 5 0");

        // todo btnAlt

    }
}
