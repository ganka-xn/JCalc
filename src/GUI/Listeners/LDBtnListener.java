package GUI.Listeners;

import static GUI.JCalcVars.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
