package GUI.Listeners;

import Library.OneStep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.historyPane;
import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;
import static Library.CorrectDisplayString.correctDisplayString;

public class OneStepBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        oneStepFlag = true;
        actionStatus = ActionStatus.actionIsCorrect;

        if(evt.getActionCommand().contains("x")) {
            if (!String.valueOf(historyPane.historyText.getText()).equals("")) {
                try {
                    while(String.valueOf(numArray).contains(String.valueOf(historyPane.historyText.getLastChar()))) {
                        historyPane.historyText.removeLastChar();
                    }
                } catch(Exception ex) {
//                    ex.printStackTrace();
                }
            }
            historyPane.historyText.append(evt.getActionCommand().replace("x", correctDisplayString(xInDbl))); // todo output
        }

        OneStep.Evaluate(evt.getActionCommand());

        if(!evt.getActionCommand().contains("x")) {
            historyPane.historyText.appendDouble(xInDbl);
        }

        ioPane.display.setDisplay(xInDbl);

        xInStr = ""; // обнуляем ввод
    }
}
