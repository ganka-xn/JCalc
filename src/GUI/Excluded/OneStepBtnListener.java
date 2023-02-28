package GUI.Excluded;

import GUI.Display;
import Library.OneStep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.*;

// todo доработать

public class OneStepBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        oneStepFlag = true;
        oneStepOpr = evt.getActionCommand();
        actionStatus = ActionStatus.actionIsCorrect;

        x0 = x1;
        x1 = xInDbl;

        OneStep.Evaluate();

        Display.setDisplay(xInDbl);
        x1 = xInDbl; // двойной счет??
        xInput = xInDbl;
        xInStr = ""; // обнуляем ввод
    }

}
