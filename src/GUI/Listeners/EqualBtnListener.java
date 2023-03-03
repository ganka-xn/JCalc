package GUI.Listeners;

import GUI.OperatorPriority;
import GUI.Display;
import Library.TwoStep;

import static GUI.JCalc.historyPane;
import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EqualBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (!currentOpr.equals(evt.getActionCommand())) {

            int priority = 2;

//            historyPane.appendDouble(xInDbl);

            if (!operatorStack.empty() && oneStepFlag == false) {
                operatorStack.removeElementAt(operatorStack.size() - 1);
            }

            while (!operatorStack.empty()) {
                if(OperatorPriority.getP(operatorStack.peek()) >= priority) {
                    TwoStep.Evaluate(operatorStack.pop());
                }
            }

            historyPane.historyText.append(evt.getActionCommand());
            historyPane.historyText.appendDouble(xInDbl);
            historyPane.historyText.append("\n");

            ioPane.display.setDisplay(xInDbl);
            xStack.push(xInDbl);

            xInStr = "";

        }
    }
}
