/*
 * Created by JFormDesigner on Thu Mar 02 16:52:46 MSK 2023
 */

package test;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author ganka
 */
public class test extends JPanel {
    public test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setPreferredSize(new Dimension(540, 340));
        setMinimumSize(new Dimension(540, 340));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //======== scrollPane1 ========
        {
            scrollPane1.setAutoscrolls(true);

            //---- textArea1 ----
            textArea1.setPreferredSize(new Dimension(240, 220));
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
