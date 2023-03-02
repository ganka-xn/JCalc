package GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.*;
import static GUI.JCalcVars.*;

public class NumBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (xInStr.contains(".") && evt.getActionCommand() == ".") {
            return;
        } else if (xInStr.equals("") && evt.getActionCommand().equals("0") && xInDbl == 0) {
            return;
        } else if (xInStr.equals("") && evt.getActionCommand().equals(".")) {
            xInStr = "0.";
            xInDbl = 0;
            ioPane.fieldX.setText(xInStr);
        } else {
            xInStr += evt.getActionCommand();
            ioPane.fieldX.setText(xInStr);
            xInDbl = Double.parseDouble(xInStr);
        }
//        xInDbl = xInput;
        currentOpr = evt.getActionCommand();
    }
}
