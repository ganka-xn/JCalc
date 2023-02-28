package GUI.Listeners;

import GUI.Display;
import GUI.OperatorPriority;
import Library.TwoStep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.*;

public class CloseBracketListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (operatorStack.contains("(")) {
            while (!operatorStack.peek().equals("(")) {
                TwoStep.Evaluate(operatorStack.pop());
            }
            operatorStack.pop();
            Display.setDisplay(xInDbl);
        }
    }
}
