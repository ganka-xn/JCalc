package Library;

public class JMath {

    private static long n = 0, x0 = 0, x1 = 1;
    private static long valueL;
    private static double value;

    public static long fib(double input) {
        n = Math.round(input);
        if (n < 0 || n > 88) {
            return 0;
        }
        else {
            if (n == 0) {
                valueL = x0;
            }
            else if (n == 1) {
                valueL = x1;
            }
            for (int i = 2; i <= n; i++) {
                valueL = x0 + x1;
                x0 = x1;
                x1 = valueL;
            }
            x0 = 0;
            x1 = 1;
            return valueL;
        }
    }

    public static long factorial(double input) {
        n = Math.round(input);
        valueL = 1;
        if (n <= 0) {
            return 0;
        }
        else if (n > 20) { // уточнить
            return 0;
        }
        else {
            for (long i = 1; i <= n; i++) {
                valueL *= i;
            }
            return valueL;
        }
    }

    public static double jSin(double input) {
        Double inputInRad = Math.toRadians(input);
        value = Math.sin(inputInRad);
        return value;
    }
    public static double jCos(double input) {
        Double inputInRad = Math.toRadians(input);
        value = Math.cos(inputInRad);
        return value;
    }
    public static double jTg(double input) {
        Double inputInRad = Math.toRadians(input);
        value = Math.tan(inputInRad);
        return value;
    }
}
