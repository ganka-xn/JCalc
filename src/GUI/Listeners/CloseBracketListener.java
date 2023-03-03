package GUI.Listeners;

import GUI.Display;
import Library.TwoStep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.historyPane;
import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

public class CloseBracketListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (operatorStack.contains("(")) {

            historyPane.historyText.appendDouble(xInDbl);

            while (!operatorStack.peek().equals("(")) {
                TwoStep.Evaluate(operatorStack.pop());
            }

            operatorStack.pop();
            ioPane.display.setDisplay(xInDbl);

            historyPane.historyText.append(evt.getActionCommand());

        }
    }
}
