package GUI;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static GUI.JCalc.ioPane;
import static Library.CorrectDisplayString.correctDisplayString;

public class Display {

    static int counter = 0;
    static ScheduledExecutorService service;

    public void setDisplay(double displayValue) {

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

        ioPane.fieldX.setText(correctDisplayString(displayValue));

        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 100, TimeUnit.MILLISECONDS);

    }



}
