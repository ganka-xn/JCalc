package GUI.Listeners;

import GUI.Display;
import Library.TwoStep;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EqualBtnListener implements ActionListener {

    // todo check more operations

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (oneStepFlag == false) {
            x0 = x1;
            x1 = xInDbl;
        }

        if (currentOpr != "=") {
            x1 = xInDbl;
            prevOprSave = currentOpr;
        }

        oneStepFlag = true;
        previousOpr = currentOpr;
        currentOpr = evt.getActionCommand(); // можно заменить на "="
        repeatFlag = currentOpr == previousOpr;


        if (repeatFlag == true) {
            xInDbl = xInput;
        }

        actionStatus = ActionStatus.actionIsCorrect;

        TwoStep.Evaluate(prevOprSave); // доработать с параметром

        Display.setDisplay(xInDbl);
        x1 = xInDbl;
        xInStr = "";
    }

}
