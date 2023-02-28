package GUI.Excluded;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.*;

public class NumBtnListener implements ActionListener {

// todo добавить ввод с клавиатуры

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (xInStr.contains(".") && evt.getActionCommand() == ".") {
            return;
        } else if (xInStr == "" && evt.getActionCommand() == "0" && x1 == 0) {
            return;
        } else if (xInStr == "" && evt.getActionCommand() == ".") {
            xInStr = "0.";
            xInput = 0;
            ioPane.fieldX.setText(xInStr);
        } else {
            xInStr += evt.getActionCommand();
            ioPane.fieldX.setText(xInStr);
            xInput = Double.parseDouble(xInStr);
        }
        xInDbl = xInput;
        curButton = ButtonClick.NumButton;
//            numBtnFlag = true;
    }

}
