package Library;

import static GUI.JCalcVars.*;

public class OneStep {

    public static void Evaluate(String operator) {

        switch (operator) {
            case "Del":
                break;
            // todo доработать
            case "\u00b1":
                xInDbl = -xInDbl;
                break;
            case "%":
                if (xStack.empty()) {
                    xInDbl = xInDbl / 100;
                }
                else {
                    xInDbl = xStack.peek() * xInDbl / 100;
                }
                break;
            case "x^2":
                xInDbl = Math.pow(xInDbl, 2);
                break;
            case "x^3":
                xInDbl = Math.pow(xInDbl, 3);
                break;
            case "e^x":
                xInDbl = Math.exp(xInDbl);
                break;
            case "10^x":
                xInDbl = Math.pow(10, xInDbl);
                break;
            case "1/x":
                xInDbl = 1/xInDbl;
                break;
// todo: add complex result for sqrt(-1)
            case "\u221ax":
                xInDbl = Math.sqrt(xInDbl);
                break;
            case "3\u221ax":
                xInDbl = Math.cbrt(xInDbl);
                break;
            case "ln":
                xInDbl = Math.log(xInDbl);
                break;
            case "lg":
                xInDbl = Math.log10(xInDbl);
                break;
            case "sin":
                xInDbl = JMath.jSin(xInDbl);
                break;
            case "cos":
                xInDbl = JMath.jCos(xInDbl);
                break;
            case "tg":
                xInDbl = JMath.jTg(xInDbl);
                break;
            case "Deg":
                xInDbl = Math.toDegrees(xInDbl);
                break;
            case "e":
                xInDbl = Math.exp(1);
                break;
            case "x!":
                xInDbl = JMath.factorial(xInDbl);
                break;
            case "rand":
                xInDbl = Math.random();
                break;
            case "Fib(n)":
                if (xInDbl < 0 || xInDbl > 88) {
                    actionStatus = ActionStatus.OutOfRange;
                } else {
                    xInDbl = JMath.fib(xInDbl);
                }
                break;
            case "\u03c0":
                xInDbl = Math.PI;
                break;
        }
    }
}
