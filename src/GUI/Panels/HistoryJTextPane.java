package GUI.Panels;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import static Library.CorrectDisplayString.correctDisplayString;

public class HistoryJTextPane extends JTextPane {

    public HistoryJTextPane() {

        this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 20));
        this.setEditable(false);
//        this.setPreferredSize(new Dimension(frameWidth - 100, 260));
    }

    public void append(String s) {
        try {
            Document doc = this.getDocument();
            doc.insertString(doc.getLength(), s, null);
        } catch(BadLocationException exc) {
            exc.printStackTrace();
        }
    }

    public void appendDouble(Double resultToAppend) {
        this.append(correctDisplayString(resultToAppend));
    }

    public char getLastChar() {
        return this.getText().charAt(this.getText().length() - 1);
    }

    public void removeLastChar() {
        int length = this.getText().length();
        this.setText(this.getText().substring(0, length - 1));

/*        Document doc = this.getDocument();
        try {
            doc.remove(doc.getLength() - 2, 2);
        } catch(BadLocationException ex) {}*/
    }

    public void clearHistoryArea() {
        this.setText(null);
    }

    /**
     * Select all the text of a <code>JTextPane</code> first and then set the line spacing.
//     * @param pane <code>JTextPane</code> to apply the change
     * @param factor the factor of line spacing. For example, <code>1.0f</code>.
     * @param replace whether the new <code>AttributeSet</code> should replace the old set. If set to <code>false</code>, will merge with the old one.
     */
    public void changeLineSpacing(float factor, boolean replace) {
        this.selectAll();
        MutableAttributeSet set = new SimpleAttributeSet(this.getParagraphAttributes());
        StyleConstants.setLineSpacing(set, factor);
        this.setParagraphAttributes(set, replace);
        this.setMargin(new Insets(10, 10, 10, 10)); //top, left, bottom, right
    }
}
