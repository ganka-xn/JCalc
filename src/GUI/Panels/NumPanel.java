package GUI.Panels;

import GUI.Buttons.*;
import GUI.Listeners.*;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static GUI.ColorLib.*;
import static GUI.JCalcVars.frameWidth;

public class NumPanel extends JPanel {

    public JNumButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPoint;
    public JNumButton btnPlus, btnMinus, btnMultiply, btnDivide;
    public JNumButton btnSign, btnEquals, btnDel, btnAC;

    //Constructor
    public NumPanel() {

        //======== this ========
        setMinimumSize(new Dimension(frameWidth, 200));
        setBackground(bunkerColor);
        setLayout(new MigLayout(
                "insets 0 0 0 0,hidemode 3,gap 1 1",
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
        BackSpaceListener backSpaceListener = new BackSpaceListener();

//        ButtonFactory factory = new ButtonFactory();

        // Num buttons
        btnZero = new JNumButton("0", steelColor, numBtnListener);
        add(btnZero, "cell 0 3 2 1");

        btnOne = new JNumButton("1", steelColor, numBtnListener);
        add(btnOne, "cell 0 2");

        btnTwo = new JNumButton("2", steelColor, numBtnListener);
        add(btnTwo, "cell 1 2");

        btnThree = new JNumButton("3", steelColor, numBtnListener);
        add(btnThree, "cell 2 2");

        btnFour = new JNumButton("4", steelColor, numBtnListener);
        add(btnFour, "cell 0 1");

        btnFive = new JNumButton("5", steelColor, numBtnListener);
        add(btnFive, "cell 1 1");

        btnSix = new JNumButton("6", steelColor, numBtnListener);
        add(btnSix, "cell 2 1");

        btnSeven = new JNumButton("7", steelColor, numBtnListener);
        add(btnSeven, "cell 0 0");

        btnEight = new JNumButton("8", steelColor, numBtnListener);
        add(btnEight, "cell 1 0");

        btnNine = new JNumButton("9", steelColor, numBtnListener);
        add(btnNine, "cell 2 0");

        btnPoint = new JNumButton(".", steelColor, numBtnListener);
        add(btnPoint, "cell 2 3");
        /*
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
*/

        //================================================================
        btnPlus = new JNumButton("+", lightningYellowColor, twoStepBtnListener);
        add(btnPlus, "cell 3 3");

        btnMinus = new JNumButton("-", lightningYellowColor, twoStepBtnListener);
        add(btnMinus, "cell 3 2");

        btnMultiply = new JNumButton("\u00d7", lightningYellowColor, twoStepBtnListener);
        add(btnMultiply, "cell 3 1");

        btnDivide = new JNumButton("\u00f7", lightningYellowColor, twoStepBtnListener);
        add(btnDivide, "cell 3 0");

        //================================================================


        btnEquals = new JNumButton("=", charcoalColor, equalBtnListener);
        add(btnEquals, "cell 4 0");

        btnSign = new JNumButton("\u00b1", charcoalColor, oneStepBtnListener);
        add(btnSign, "cell 4 1");

        btnDel = new JNumButton("del", charcoalColor, backSpaceListener);
        add(btnDel, "cell 4 2");

        btnAC = new JNumButton("C", charcoalColor, resetBtnListener);
        add(btnAC, "cell 4 3");

/*
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "=", equalBtnListener), "cell 4 0"); // Equal button
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u00b1", oneStepBtnListener), "cell 4 1"); // Sign button
        add(factory.createButton(ButtonType.JOPRBUTTON, "Del", oneStepBtnListener), "cell 4 2"); // Del button
        add(factory.createButton(ButtonType.JOPRBUTTON, "C", resetBtnListener), "cell 4 3"); // Reset button
*/

    }
}