package GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.*;
import static GUI.JCalcVars.*;

public class ResetBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        x0 = x1 = 0;
        xInStr = "";
        currentOpr = "";
        previousOpr = "";
        ioPane.fieldX.setText("0");
    }
}
