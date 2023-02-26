package GUI.Listeners;

import GUI.Display;
import static GUI.JCalcVars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
