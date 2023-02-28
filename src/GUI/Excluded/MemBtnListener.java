package GUI.Excluded;

import GUI.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.*;


public class MemBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evt) {

        String memOpr = evt.getActionCommand();
        actionStatus = ActionStatus.actionIsCorrect;

        switch (memOpr) {
            case "m+":
                memDbl += xInDbl;
                break;
            case "m-":
                memDbl -= xInDbl;
                break;
            case "mr":
                xInDbl = memDbl;
                Display.setDisplay(xInDbl);
                break;
            case "mc":
                memDbl = 0;
                break;
        }

        xInStr = "";

    }

}
