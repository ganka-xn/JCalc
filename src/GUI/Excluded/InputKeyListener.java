package GUI.Excluded;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static GUI.JCalc.ioPane;
import static GUI.JCalcVars.xInStr;
import static GUI.JCalcVars.xInput;

public class InputKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent evt) {

        if (evt.getKeyChar() == '0') {
            ((JButton) evt.getSource()).doClick();
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {


    }

    @Override
    public void keyReleased(KeyEvent evt) {

    }
}
