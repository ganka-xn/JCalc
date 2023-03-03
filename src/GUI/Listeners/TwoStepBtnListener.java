package GUI.Listeners;

import GUI.OperatorPriority;
import Library.TwoStep;

import javax.swing.text.BadLocationException;

import static GUI.JCalc.historyPane;
import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoStepBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        actionStatus = ActionStatus.actionIsCorrect;
//        historyPane.historyText.appendDouble(xInDbl);
        historyPane.historyText.append(evt.getActionCommand());

        if (!operatorStack.empty()) {
            if (oneStepFlag == false) {
                operatorStack.removeElementAt(operatorStack.size() - 1);
                historyPane.historyText.removeLastChar();
                historyPane.historyText.append(evt.getActionCommand());
            }
            else {
                if (OperatorPriority.getP(operatorStack.peek()) >= OperatorPriority.getP(evt.getActionCommand())) {
                    TwoStep.Evaluate(operatorStack.pop());
                }
            }
        }

        currentOpr = evt.getActionCommand();
        operatorStack.push(currentOpr);

        xStack.push(xInDbl);
        xInStr = "";

        ioPane.display.setDisplay(xInDbl);

        oneStepFlag = false;

    }



}

