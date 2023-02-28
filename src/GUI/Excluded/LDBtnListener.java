package GUI.Excluded;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.JCalcVars.LightFlag;
import static GUI.JCalcVars.lightFlag;

// fixme btnLDListener

public class LDBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (lightFlag) {
            case Dark -> {
                lightFlag = LightFlag.Light;
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (Exception ex) {
                    System.err.println("Failed to initialize LaF");
                }
            }
            case Light -> {
                lightFlag = LightFlag.Dark;
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (Exception ex) {
                    System.err.println("Failed to initialize LaF");
                }
            }
        }
    }
}
