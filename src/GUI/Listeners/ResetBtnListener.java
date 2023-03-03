package GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

public class ResetBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        clearAllFields();
    }

    public static void clearAllFields() {
        xInStr = "";
        currentOpr = "";
        previousOpr = "";

        xStack.clear();
        operatorStack.clear();

        ioPane.display.setDisplay(0);

        oneStepFlag = true;

    }
}
