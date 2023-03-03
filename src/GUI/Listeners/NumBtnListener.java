package GUI.Listeners;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.*;
import static GUI.JCalcVars.*;



public class NumBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        oneStepFlag = true;

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

//        if (numFlag == true) {
            if (!String.valueOf(historyPane.historyText.getText()).equals("")) {
                try {
                    while(String.valueOf(numArray).contains(String.valueOf(historyPane.historyText.getLastChar()))) {
                        historyPane.historyText.removeLastChar();
                    }
                } catch(Exception ex) {
//                    ex.printStackTrace();
                }
            }
//        }

        historyPane.historyText.append(xInStr); // todo ошибка при вводе длинного числа
        currentOpr = evt.getActionCommand();
        numFlag = true;
    }

}
