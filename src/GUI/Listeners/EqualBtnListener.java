package GUI.Listeners;

import GUI.OperatorPriority;
import GUI.Display;
import Library.TwoStep;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EqualBtnListener implements ActionListener {

    // todo check more operations

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (!currentOpr.equals(evt.getActionCommand())) {

            int priority = 2;

            while (!operatorStack.empty()) {
                if(OperatorPriority.getP(operatorStack.peek()) >= priority) {
                    TwoStep.Evaluate(operatorStack.pop());
                }
            }

            Display.setDisplay(xInDbl);
            xStack.push(xInDbl);

            xInStr = "";

        }
    }
}
