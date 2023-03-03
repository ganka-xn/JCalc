package Library;

import java.text.DecimalFormat;

import static GUI.JCalcVars.actionStatus;

public class CorrectDisplayString {

    public static String correctDisplayString(Double stringToCorrect) {

        String displayString = "";

        switch (actionStatus) {
            case actionIsCorrect:
                if (stringToCorrect > 999999999999.0) {
                    DecimalFormat df = new DecimalFormat("##0.######E0");
                    displayString = df.format(stringToCorrect);
                } else {
                    DecimalFormat df = new DecimalFormat("###.############");
                    displayString = df.format(stringToCorrect);
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

        return displayString;
    }

}
