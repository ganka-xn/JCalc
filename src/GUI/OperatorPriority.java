package GUI;

public class OperatorPriority {

    public static int getP(String token) {
        if (token == "(") return 0;
        else if (token == ")") return 1;
        else if (token == "+" || token == "-") return 2;
        else if (token == "\u00d7" || token == "\u00f7") return 3;
        else return 4;
    }

}
