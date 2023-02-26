package GUI;

import java.text.DecimalFormat;

import static GUI.JCalcVars.*;
import static GUI.JCalc.ioPane;

public class Display {

    public static void setDisplay(double displayValue) {

        String displayString = "";

        switch (actionStatus) {
            case actionIsCorrect:
                if (displayValue > 999999999999.0) {
                    DecimalFormat df = new DecimalFormat("##0.######E0");
                    displayString = df.format(displayValue);
                } else {
                    DecimalFormat df = new DecimalFormat("###.############");
                    displayString = df.format(displayValue);
                    if (displayString.length() > 2) {
                        String last2DisplayChars = displayString.substring(displayString.length() - 2);
                        if (last2DisplayChars.equals(".0")) {
                            displayString = displayString.substring(0, displayString.length() - 2);
                        }
                    }
                }
                break;
            case Infinity:
                displayString = "Infinity";
                break;
            case NotANumber:
                displayString = "Not a number";
                break;
            case OutOfRange:
                displayString = "Input is out of range";
                break;
        }
        ioPane.fieldX.setText(displayString);
    }

}
