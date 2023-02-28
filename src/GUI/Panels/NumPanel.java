package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Listeners.*;
import GUI.Buttons.ButtonType;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static GUI.JCalcVars.frameWidth;

public class NumPanel extends JPanel {

    //Constructor
    public NumPanel() {

        //======== this ========
        setMinimumSize(new Dimension(frameWidth, 200));
        setLayout(new MigLayout(
                "insets 0 0 0 0,hidemode 3,gap 0 0",
                // columns
                "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]",
                // rows
                "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]"));


        //===components===
        NumBtnListener numBtnListener = new NumBtnListener();
        OneStepBtnListener oneStepBtnListener = new OneStepBtnListener();
        TwoStepBtnListener twoStepBtnListener = new TwoStepBtnListener();
        ResetBtnListener resetBtnListener = new ResetBtnListener();
        EqualBtnListener equalBtnListener = new EqualBtnListener();


        // Num buttons

        ButtonFactory factory = new ButtonFactory();

        add(factory.createButton(ButtonType.JNUMBUTTON, "0", numBtnListener), "cell 0 3 2 1");
        add(factory.createButton(ButtonType.JNUMBUTTON, "1", numBtnListener), "cell 0 2");
        add(factory.createButton(ButtonType.JNUMBUTTON, "2", numBtnListener), "cell 1 2");
        add(factory.createButton(ButtonType.JNUMBUTTON, "3", numBtnListener), "cell 2 2");
        add(factory.createButton(ButtonType.JNUMBUTTON, "4", numBtnListener), "cell 0 1");
        add(factory.createButton(ButtonType.JNUMBUTTON, "5", numBtnListener), "cell 1 1");
        add(factory.createButton(ButtonType.JNUMBUTTON, "6", numBtnListener), "cell 2 1");
        add(factory.createButton(ButtonType.JNUMBUTTON, "7", numBtnListener), "cell 0 0");
        add(factory.createButton(ButtonType.JNUMBUTTON, "8", numBtnListener), "cell 1 0");
        add(factory.createButton(ButtonType.JNUMBUTTON, "9", numBtnListener), "cell 2 0");
        add(factory.createButton(ButtonType.JNUMBUTTON, ".", numBtnListener), "cell 2 3");

        //================================================================

        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "+", twoStepBtnListener), "cell 3 3");
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "-", twoStepBtnListener), "cell 3 2");
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "\u00d7", twoStepBtnListener), "cell 3 1"); // Multiply
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "\u00f7", twoStepBtnListener), "cell 3 0"); // Divide

        //================================================================

        setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 24));

        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "=", equalBtnListener), "cell 4 0"); // Equal button
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u00b1", oneStepBtnListener), "cell 4 1"); // Sign button
        add(factory.createButton(ButtonType.JOPRBUTTON, "Del", oneStepBtnListener), "cell 4 2"); // Del button
        add(factory.createButton(ButtonType.JOPRBUTTON, "C", resetBtnListener), "cell 4 3"); // Reset button

    }
}