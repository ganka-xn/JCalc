package Library;

import static GUI.JCalcVars.*;

public class TwoStep {

    public static void Evaluate(String operator) {

        // fixme 2+sqrt(3)

        switch (operator) {
            case "":
                break;
            case "=":
//                    xInDbl = x1;
                break;
            case "+":
                xInDbl = x0 + xInDbl;
                break;
            case "-":
                xInDbl = x0 - xInDbl;
                break;
            case "\u00d7": //multiply
                xInDbl = x0 * xInDbl;
                break;
            case "\u00f7": //divide
                if (x1 == 0) {
                    actionStatus = ActionStatus.Infinity;
                } else {
                    xInDbl = x0 / xInDbl;
                }
                break;
            case "x^a":
                xInDbl = Math.pow(x0, xInDbl);
                break;
            case "a\u221ax": // y root of x
                xInDbl = Math.pow(x0, 1/xInDbl);
                break;
            case "loga(x)":
                xInDbl = Math.log(xInDbl) / Math.log(x0);
                break;
        }
    }
}
