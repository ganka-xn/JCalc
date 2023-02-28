package Library;

import static GUI.JCalcVars.*;

public class TwoStep {

    public static void Evaluate(String operator) {

        switch (operator) {
            case "+":
                xInDbl = xStack.pop() + xInDbl;
                break;
            case "-":
                xInDbl = xStack.pop() - xInDbl;
                break;
            case "\u00d7":                                      //multiply
                xInDbl = xStack.pop() * xInDbl;
                break;
            case "\u00f7":                                      //divide
                if (xInDbl == 0) {
                    actionStatus = ActionStatus.Infinity;
                } else {
                    xInDbl = xStack.pop() / xInDbl;
                }
                break;
            case "x^y":
                xInDbl = Math.pow(xStack.pop(), xInDbl);
                break;
            case "y\u221ax":                                    // y root of x
                xInDbl = Math.pow(xStack.pop(), 1/xInDbl);
                break;
            case "logy(x)":
                xInDbl = Math.log(xInDbl) / Math.log(xStack.pop());
                break;
            case "%":
                if (xStack.peek() == 0) {
                    xInDbl = xInDbl / 100;
                }
                else {
                    xInDbl = xStack.pop() * xInDbl / 100;
                }
                break;
        }
    }
}
