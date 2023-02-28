package GUI.Panels;

import GUI.Buttons.ButtonFactory;
import GUI.Buttons.ButtonType;
import GUI.Buttons.JOprButton;
import GUI.Listeners.CloseBracketListener;
import GUI.Listeners.OneStepBtnListener;
import GUI.Listeners.OpenBracketListener;
import GUI.Listeners.TwoStepBtnListener;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static GUI.JCalcVars.frameWidth;

public class FuncPanel extends JPanel {

    public FuncPanel() {

        //======== this ========
        setMinimumSize(new Dimension(frameWidth, 180));
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
        OpenBracketListener openBracketListener = new OpenBracketListener();
        CloseBracketListener closeBracketListener = new CloseBracketListener();

        ButtonFactory factory = new ButtonFactory();

        add(factory.createButton(ButtonType.JOPRBUTTON, "%", oneStepBtnListener), "cell 0 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^2", oneStepBtnListener), "cell 1 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^3", oneStepBtnListener), "cell 2 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x^y", twoStepBtnListener), "cell 3 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "e^x", oneStepBtnListener), "cell 4 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "10^x", oneStepBtnListener), "cell 5 0");
        add(factory.createButton(ButtonType.JOPRBUTTON, "1/x", oneStepBtnListener), "cell 0 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u221ax", oneStepBtnListener), "cell 1 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "3\u221ax", oneStepBtnListener), "cell 2 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "y\u221ax", twoStepBtnListener), "cell 3 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "ln", oneStepBtnListener), "cell 4 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "lg", oneStepBtnListener), "cell 5 1");
        add(factory.createButton(ButtonType.JOPRBUTTON, "sin", oneStepBtnListener), "cell 0 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "cos", oneStepBtnListener), "cell 1 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "tg", oneStepBtnListener), "cell 2 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "deg", oneStepBtnListener), "cell 3 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "logy(x)", twoStepBtnListener), "cell 4 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "e", oneStepBtnListener), "cell 5 2");
        add(factory.createButton(ButtonType.JOPRBUTTON, "(", openBracketListener), "cell 0 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, ")", closeBracketListener), "cell 1 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "x!", oneStepBtnListener), "cell 2 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "rand", oneStepBtnListener), "cell 3 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "Fib(n)", oneStepBtnListener), "cell 4 3");
        add(factory.createButton(ButtonType.JOPRBUTTON, "\u03c0", oneStepBtnListener), "cell 5 3");

    }
}
