package GUI;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static GUI.JCalcVars.*;
import static GUI.JCalc.ioPane;
import GUI.JCalc;

public class Display {

    static int counter = 0;
    static ScheduledExecutorService service;

    public static void setDisplay(double displayValue) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (counter++ >= 2) {
                    service.shutdown();
                    counter = 0;
                } else {
                    if (counter % 2 == 1) {
                        ioPane.fieldX.setForeground(ioPane.getBackground());
                    } else {
                        ioPane.fieldX.setForeground(ColorLib.sazeracColor);
                    }
                }
            }
        };
        String displayString = "";
//        ioPane.fieldX.setText(displayString);

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
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 100, TimeUnit.MILLISECONDS);

    }
}
