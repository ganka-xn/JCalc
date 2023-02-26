package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Buttons.ButtonType;
import GUI.Buttons.JOprButton;
import GUI.Listeners.OneStepBtnListener;
import GUI.Listeners.TwoStepBtnListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class FuncPanel extends JPanel {

    private JOprButton btnPercent, btnX2, btnX3, btnXA, btnEX, btn10X, btn1X, btnSqrt, btnCbrt, btnAX, btnLn,
            btnLg, btnSin, btnCos, btnTg, btnRad, btnLogAX, btnE, btnParenthesisOpen, btnParenthesisClose,
            btnFactorial, btnRnd, btnFib, btnPi;

    public FuncPanel() {

        //======== this ========
        setPreferredSize(new Dimension(360, 180));
        setLayout(new MigLayout(
                "insets 0 0 0 0,hidemode 3,gap 0 0",
                // columns
                "[grow,fill]" +
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

        OneStepBtnListener oneStepBtnListener = new OneStepBtnListener();
        TwoStepBtnListener twoStepBtnListener = new TwoStepBtnListener();

        ButtonFactory factory = new ButtonFactory();

        add(factory.createButton(ButtonType.JOPRBUTTON, "%", oneStepBtnListener), "cell 0 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^2", oneStepBtnListener), "cell 1 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^3", oneStepBtnListener), "cell 2 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^a", twoStepBtnListener), "cell 3 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "e^x", oneStepBtnListener), "cell 4 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "10^x", oneStepBtnListener), "cell 5 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "1/x", oneStepBtnListener), "cell 0 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u221ax", oneStepBtnListener), "cell 1 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "3\u221ax", oneStepBtnListener), "cell 2 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "a\u221ax", twoStepBtnListener), "cell 3 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "ln", oneStepBtnListener), "cell 4 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "lg", oneStepBtnListener), "cell 5 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "sin", oneStepBtnListener), "cell 0 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "cos", oneStepBtnListener), "cell 1 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "tg", oneStepBtnListener), "cell 2 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "deg", oneStepBtnListener), "cell 3 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "loga(x)", twoStepBtnListener), "cell 4 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "e", oneStepBtnListener), "cell 5 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "(", oneStepBtnListener), "cell 0 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, ")", oneStepBtnListener), "cell 1 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x!", oneStepBtnListener), "cell 2 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "rand", oneStepBtnListener), "cell 3 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "Fib(n)", oneStepBtnListener), "cell 4 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u03c0", oneStepBtnListener), "cell 5 3");

/*        //---- btnPercent ----
        btnPercent = new JOprButton("%");
        btnPercent.addActionListener(oneStepBtnListener);
        add(btnPercent, "cell 0 0");

        //---- btnX2 ----
        btnX2 = new JOprButton("x^2");
        btnX2.addActionListener(oneStepBtnListener);
        add(btnX2, "cell 1 0");

        //---- btnX3 ----
        btnX3 = new JOprButton("x^3");
        btnX3.addActionListener(oneStepBtnListener);
        add(btnX3, "cell 2 0");

        //---- btnXY ----
        btnXA = new JOprButton("x^a");
        btnXA.addActionListener(twoStepBtnListener);
        add(btnXA, "cell 3 0");

        //---- btnEX ----
        btnEX = new JOprButton("e^x");
        btnEX.addActionListener(oneStepBtnListener);
        add(btnEX, "cell 4 0");

        //---- btn10X ----
        btn10X = new JOprButton("10^x");
        btn10X.addActionListener(oneStepBtnListener);
        add(btn10X, "cell 5 0");

        //---- btn1X ----
        btn1X = new JOprButton("1/x");
        btn1X.addActionListener(oneStepBtnListener);
        add(btn1X, "cell 0 1");

        //---- btnSqrt ----
        btnSqrt = new JOprButton("\u221ax");
        btnSqrt.addActionListener(oneStepBtnListener);
        add(btnSqrt, "cell 1 1");

        //---- btnQbrt ----
        btnCbrt = new JOprButton("3\u221ax");
        btnCbrt.addActionListener(oneStepBtnListener);
        add(btnCbrt, "cell 2 1");

        //---- btnYX ----
        btnAX = new JOprButton("a\u221ax"); // y root of x
        btnAX.addActionListener(twoStepBtnListener);
        add(btnAX, "cell 3 1");

        //---- btnLn ----
        btnLn = new JOprButton("ln");
        btnLn.addActionListener(oneStepBtnListener);
        add(btnLn, "cell 4 1");

        //---- btnLg ----
        btnLg = new JOprButton("lg");
        btnLg.addActionListener(oneStepBtnListener);
        add(btnLg, "cell 5 1");

        //---- btnSin ----
        btnSin = new JOprButton("sin");
        btnSin.addActionListener(oneStepBtnListener);
        add(btnSin, "cell 0 2");

        //---- btnCos ----
        btnCos = new JOprButton("cos");
        btnCos.addActionListener(oneStepBtnListener);
        add(btnCos, "cell 1 2");

        //---- btnTg ----
        btnTg = new JOprButton("tg");
        btnTg.addActionListener(oneStepBtnListener);
        add(btnTg, "cell 2 2");

        //---- bynRad ----
        btnRad = new JOprButton("Deg");
        btnRad.addActionListener(oneStepBtnListener);
        add(btnRad, "cell 3 2");

        //---- btnLogXY ----
        btnLogAX = new JOprButton("loga(x)");
        btnLogAX.addActionListener(twoStepBtnListener);
        add(btnLogAX, "cell 4 2");

        //---- btnE ----
        btnE = new JOprButton("e");
        btnE.addActionListener(oneStepBtnListener);
        add(btnE, "cell 5 2");

        //---- btnParenthesisOpen ----
        btnParenthesisOpen = new JOprButton("(");
        btnParenthesisOpen.addActionListener(oneStepBtnListener);
        add(btnParenthesisOpen, "cell 0 3");

        //---- btnParenthesisClose ----
        btnParenthesisClose = new JOprButton(")");
        btnParenthesisClose.addActionListener(oneStepBtnListener);
        add(btnParenthesisClose, "cell 1 3");

        //---- btnFactorial ----
        btnFactorial = new JOprButton("x!");
        btnFactorial.addActionListener(oneStepBtnListener);
        add(btnFactorial, "cell 2 3");

        //---- btnRnd ----
        btnRnd = new JOprButton("Rand");
        btnRnd.addActionListener(oneStepBtnListener);
        add(btnRnd, "cell 3 3");

        //---- btnFib ----
        btnFib = new JOprButton("Fib(n)");
        btnFib.addActionListener(oneStepBtnListener);
        add(btnFib, "cell 4 3");

        //---- btnPi ----
        btnPi = new JOprButton("\u03c0");
        btnPi.addActionListener(oneStepBtnListener);
        add(btnPi, "cell 5 3");*/
    }
}
