package GUI.Listeners;

import GUI.OperatorPriority;
import GUI.Display;
import Library.TwoStep;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoStepBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        actionStatus = ActionStatus.actionIsCorrect;

        if (!operatorStack.empty()) {
            if (OperatorPriority.getP(operatorStack.peek()) >= OperatorPriority.getP(evt.getActionCommand())) {
                TwoStep.Evaluate(operatorStack.pop());
            }
        }

        currentOpr = evt.getActionCommand();
        operatorStack.push(currentOpr);

        Display.setDisplay(xInDbl);
        xStack.push(xInDbl);
        xInStr = "";

    }
}

