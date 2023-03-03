package GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalc.historyPane;

public class ClearHistoryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {

        historyPane.historyText.clearHistoryArea();
        ResetBtnListener.clearAllFields();

    }
}
