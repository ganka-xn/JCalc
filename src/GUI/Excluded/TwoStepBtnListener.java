package GUI.Excluded;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.Display;
import Library.TwoStep;

import static GUI.JCalcVars.*;

public class TwoStepBtnListener implements ActionListener {

   @Override
    public void actionPerformed(ActionEvent evt) {

        if (oneStepFlag == false) {
            x0 = x1;
            x1 = xInDbl;
        }

        if (repeatFlag == true) {
            xInDbl = xInput;
        }

        oneStepFlag = false;

        previousOpr = currentOpr;  // save
        currentOpr = evt.getActionCommand();
        if (currentOpr == previousOpr) {
            repeatFlag = true;
        }
        else {
            repeatFlag = false;
        }

        actionStatus = ActionStatus.actionIsCorrect;

        TwoStep.Evaluate(previousOpr);

        Display.setDisplay(xInDbl);
        x1 = xInDbl;
        xInStr = "";

    }

}
