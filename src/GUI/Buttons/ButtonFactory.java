package GUI.Buttons;

//import GUI.Excluded.InputKeyListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonFactory {

    public JButton createButton (ButtonType type, String btnName, ActionListener listener) {

        JButton jButton = null;

        switch (type) {
/*            case JNUMBUTTON:
//                InputKeyListener keyListener = new InputKeyListener();
                jButton = new JNumButton(btnName, listener);
                break;
            case JSIMPLEOPRBUTTON:
                jButton = new JSButton(btnName, listener);
                break;*/
            case JOPRBUTTON:
                jButton = new JOprButton(btnName, listener);
                break;
            case JMEMBUTTON:
                jButton = new JMemButton(btnName, listener);
                break;
        }

        return jButton;
    }
}
