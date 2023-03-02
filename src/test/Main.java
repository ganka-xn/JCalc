package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton btn = new JButton("A");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });
        btn.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
                    ((JButton) e.getSource()).doClick();
                }
            }
        });
        panel.add(btn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 800, 600);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
