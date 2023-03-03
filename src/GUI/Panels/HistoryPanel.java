package GUI.Panels;

import GUI.ColorLib;

import javax.swing.*;
import java.awt.*;

import static GUI.JCalcVars.*;

public class HistoryPanel extends JPanel {

    public HistoryJTextPane historyText;

    public HistoryPanel() {

        setPreferredSize(new Dimension(520, 320));
        setMinimumSize(new Dimension(frameWidth-20, 320));
        setForeground(Color.white);
        setBackground(ColorLib.charcoalColor);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //======== historyScrollPane ========
        JScrollPane historySPane = new JScrollPane();
        historySPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        historySPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        {
            //---- historyArea ----
            historyText = new HistoryJTextPane();
            historyText.changeLineSpacing(0.2f, true);

            historyText.setVisible(true);
            historySPane.setViewportView(historyText);
        }

        historySPane.setVisible(true);
        add(historySPane, "cell 0 0 2 1");
    }
}
