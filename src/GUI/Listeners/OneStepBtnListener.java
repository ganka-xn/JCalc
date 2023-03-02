package GUI.Listeners;

import GUI.Display;
import Library.OneStep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

public class OneStepBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        actionStatus = ActionStatus.actionIsCorrect;

        OneStep.Evaluate(evt.getActionCommand());

        Display.setDisplay(xInDbl);
        xInStr = ""; // обнуляем ввод
    }

}
