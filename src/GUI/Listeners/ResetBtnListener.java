package GUI.Listeners;

import GUI.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.*;

public class ResetBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        xInStr = "";
        currentOpr = "";
        previousOpr = "";
//        ioPane.fieldX.setText("0");

        xStack.clear();
        operatorStack.clear();

        Display.setDisplay(0);
    }
}
