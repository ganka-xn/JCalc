package GUI.Listeners;

import GUI.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.xInDbl;
import static GUI.JCalcVars.xInStr;

public class BackSpaceListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (!xInStr.equals("")) {
            xInStr = xInStr.substring(0, xInStr.length() - 1);
            if (xInStr.equals("")) {
                xInDbl = 0;
                ioPane.fieldX.setText("0");
            }
            else {
                xInDbl = Double.parseDouble(xInStr);
                ioPane.fieldX.setText(xInStr);
            }
//            Display.setDisplay(xInDbl);
//            ioPane.fieldX.setText(xInStr);
        }

    }
}
