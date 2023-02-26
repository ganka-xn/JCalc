package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Buttons.ButtonType;
import GUI.Buttons.JOprButton;

import GUI.Listeners.*;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

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
        setSize(new Dimension(360, 60));
        setLayout(new MigLayout(
                "fillx,insets 0 0 0 0,hidemode 3,gap 0 0",
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

/*        //---- btnMR ----
        btnMR = new JOprButton("mr");
        btnMR.addActionListener(memBtnListener);
        add(btnMR, "cell 0 0");

        //---- btnMPlus ----
        btnMPlus = new JOprButton("m+");
        btnMPlus.addActionListener(memBtnListener);
        add(btnMPlus, "cell 1 0");

        //---- btnMMinus ----
        btnMMinus = new JOprButton("m-");
        btnMMinus.addActionListener(memBtnListener);
        add(btnMMinus, "cell 2 0");

        //---- btnMC ----
        btnMC = new JOprButton("mc");
        btnMC.addActionListener(memBtnListener);
        add(btnMC, "cell 3 0");

        //---- button1 ----
        btnLD = new JOprButton("L/D");
        btnLD.addActionListener(btnLDListener);
        add(btnLD, "cell 4 0");

        //---- btnOpt ----

        // todo btnAlt
        btnAlt = new JOprButton("Alt");
        add(btnAlt, "cell 5 0");*/

    }
}
