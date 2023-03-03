package GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.historyPane;
import static GUI.JCalcVars.currentOpr;
import static GUI.JCalcVars.operatorStack;

public class OpenBracketListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        currentOpr = evt.getActionCommand();
        operatorStack.push(currentOpr);

        historyPane.historyText.append(evt.getActionCommand());
    }
}
