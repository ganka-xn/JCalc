package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo{

    public void buildGui(){
        JFrame frame = new JFrame("key buttons");
        JPanel panel = new JPanel(new BorderLayout());
        JButton a = new JButton("0");
        a.addActionListener(evt->{ System.out.println("0 pressed");});
        JButton b = new JButton("1");
        b.addActionListener(evt->{ System.out.println("1 pressed");});

        panel.add(a, BorderLayout.EAST);
        panel.add(b, BorderLayout.WEST);

        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KeyStroke us = KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false);
        panel.getInputMap().put(us, "0");
        panel.getActionMap().put("0", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent evt){
                a.doClick();
            }
        });

        KeyStroke us2 = KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false);
        panel.getInputMap().put(us2, "1");
        panel.getActionMap().put("1", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent evt){
                b.doClick();
            }
        });
        a.setFocusable(false);
        b.setFocusable(false);

    }

    public static void main(String[] args){
        EventQueue.invokeLater( new Demo()::buildGui);
    }
}
