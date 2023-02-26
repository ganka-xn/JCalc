package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Buttons.JNumButton;
import GUI.Buttons.JOprButton;
import GUI.Listeners.*;
import GUI.Buttons.ButtonType;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class NumPanel extends JPanel {

    //Var
    private JNumButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPoint;
    private JOprButton btnPlus, btnMinus, btnMultiply, btnDivide;
    private JOprButton btnSign, btnEquals, btnDel, btnAC;

    //Constructor
    public NumPanel() {

        //======== this ========
        setMinimumSize(new Dimension(360, 200));
        setPreferredSize(new Dimension(360, 200));
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

/*        Doughnut cherry =
        Doughnut chocolate = factory.getDoughnut(DoughnutTypes.CHOCOLATE);
        Doughnut almond = factory.getDoughnut(DoughnutTypes.ALMOND);

        cherry.eat();
        chocolate.eat();
        almond.eat();*/

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

/*        btnZero = new JNumBtn("0");
        add(btnZero, "cell 0 3 2 1");

        btnOne = new JNumBtn("1");
        add(btnOne, "cell 0 2");

        btnTwo = new JNumBtn("2");
        add(btnTwo, "cell 1 2");

        btnThree = new JNumBtn("3");
        add(btnThree, "cell 2 2");

        btnFour = new JNumBtn("4");
        add(btnFour, "cell 0 1");

        btnFive = new JNumBtn("5");
        add(btnFive, "cell 1 1");

        btnSix = new JNumBtn("6");
        add(btnSix, "cell 2 1");

        btnSeven = new JNumBtn("7");
        add(btnSeven, "cell 0 0");

        btnEight = new JNumBtn("8");
        add(btnEight, "cell 1 0");

        btnNine = new JNumBtn("9");
        add(btnNine, "cell 2 0");

        btnPoint = new JNumBtn(".");
        add(btnPoint, "cell 2 3");*/

        //================================================================

        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "+", twoStepBtnListener), "cell 3 3");
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "-", twoStepBtnListener), "cell 3 2");
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "\u00d7", twoStepBtnListener), "cell 3 1"); // Multiply
        add(factory.createButton(ButtonType.JSIMPLEOPRBUTTON, "\u00f7", twoStepBtnListener), "cell 3 0"); // Divide

/*        btnPlus = new JOprBtn("+", 24);
        btnPlus.setBackground(lightningYellowColor);
        btnPlus.addActionListener(twoStepBtnListener);
        add(btnPlus, "cell 3 3");

        btnMinus = new JOprBtn("-", 24);
        btnMinus.setBackground(lightningYellowColor);
        btnMinus.addActionListener(twoStepBtnListener);
        add(btnMinus, "cell 3 2");

        btnMultiply = new JOprBtn("\u00d7", 24);
        btnMultiply.setBackground(lightningYellowColor);
        btnMultiply.addActionListener(twoStepBtnListener);
        add(btnMultiply, "cell 3 1");

        btnDivide = new JOprBtn("\u00f7", 24);
        btnDivide.setBackground(lightningYellowColor);
        btnDivide.addActionListener(twoStepBtnListener);
        add(btnDivide, "cell 3 0");*/

        //================================================================

        setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 24));

        add(factory.createButton(ButtonType.JOPRBUTTON, "=", equalBtnListener), "cell 4 0"); // Equal button
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u00b1", oneStepBtnListener), "cell 4 1"); // Sign button
        add(factory.createButton(ButtonType.JOPRBUTTON, "Del", oneStepBtnListener), "cell 4 2"); // Del button
        add(factory.createButton(ButtonType.JOPRBUTTON, "C", resetBtnListener), "cell 4 3"); // Reset button

/*        btnSign = new JOprBtn("\u00b1", 24);
        btnSign.addActionListener(oneStepBtnListener);
        add(btnSign, "cell 4 1");

        btnEquals = new JOprBtn("=", 24);
        btnEquals.addActionListener(equalBtnListener);
        add(btnEquals, "cell 4 0");

        btnDel = new JOprBtn("DEL", 18);
        btnDel.addActionListener(oneStepBtnListener);
        add(btnDel, "cell 4 2");

        btnAC = new JOprBtn("C", 24);
        btnAC.addActionListener(btnResetListener);
        add(btnAC, "cell 4 3");*/
    }
}