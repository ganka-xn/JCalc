package GUI;

import GUI.JCalc;

import javax.swing.*;
import java.util.Stack;

public class JCalcVars {

    public static double
            x0 = 0,
            x1 = 0,
            xInDbl = 0,
            memDbl = 0,
            xInput = 0;
    public static String xInStr = "";                                                      // the number entered as String

    public enum ActionStatus { Infinity, NotANumber, actionIsCorrect, OutOfRange }
    public static ActionStatus actionStatus = ActionStatus.actionIsCorrect;

    public static  Stack<String> operatorStack = new Stack<>();
    public static  Stack<Double> xStack = new Stack<>();

    public enum ButtonClick { NumButton, OprButton }
    public static ButtonClick curButton, prevButton;

    public static String previousOpr = "";  // the previous operator
    public static String currentOpr = "";   // the current operator
    public static String prevOprSave = "";
    public static String oneStepOpr = "";
    public static boolean oneStepFlag = false;
    public static boolean repeatFlag = false;


    public enum LightFlag { Light, Dark }
    public static LightFlag lightFlag = LightFlag.Dark;

}
