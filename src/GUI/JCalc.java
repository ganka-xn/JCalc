package GUI;import calc.JMath;import com.formdev.flatlaf.FlatDarkLaf;import com.formdev.flatlaf.FlatLightLaf;import net.miginfocom.swing.*;import javax.swing.*;import javax.swing.border.EmptyBorder;import javax.swing.border.LineBorder;import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.font.TextAttribute;import java.text.DecimalFormat;import java.util.Map;public class JCalc extends JPanel {    private double x0 = 0, x1 = 0, xInDbl = 0, memDbl = 0;    private enum ActionStatus { Infinity, NotANumber, actionIsCorrect, OutOfRange }    private ActionStatus actionStatus = ActionStatus.actionIsCorrect;    private String xInStr = ""; // the number entered as String    private String previousOpr = "";  // the previous operator    private String currentOpr = "";   // the current operator    private String prevOprSave = "";    private String oneStepOpr = "";    private boolean oneStepFlag = false;    private IOPanel ioPane;    private JSeparator separator1, separator2;    private MemPanel memPane;    private FuncPanel funcPane;    private NumPanel numPane;    private enum LightFlag { Light, Dark }    private LightFlag lightFlag = LightFlag.Dark;    private final Color lightningYellowColor = new Color(245, 163, 54);    private final Color charcoalColor = new Color(62, 62,66);    private final Color steelColor = new Color(100,101,103);    private final Color bunkerColor = new Color(42,43,47);    private final Color sazeracColor = new Color(241,241, 241);    public static void main(String[] args) {        SwingUtilities.invokeLater(new Runnable() {            @Override            public void run() {                try {                    UIManager.setLookAndFeel(new FlatDarkLaf());                } catch( Exception ex ) {                    System.err.println( "Failed to initialize LaF" );                }                JFrame frame = new JFrame("JCalc");                frame.setContentPane(new JCalc());                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                frame.pack();                frame.setResizable(false);                frame.setVisible(true);            }        });    }    // Constructor    private JCalc() {        initComponents();    }    private void initComponents() {        //======== this ========        setSize(new Dimension(360, 540));        setLayout(new MigLayout(                "insets 0 0 0 0,hidemode 3,gap 0 0",                // columns                "[fill]",                // rows                "[fill]" +                        "[fill]" +                        "[fill]" +                        "[fill]" +                        "[fill]" +                        "[fill]"));        ioPane = new IOPanel();        add(ioPane, "cell 0 0");        separator1 = new JSeparator();        separator1.setForeground(Color.gray);//        separator1.setSize(new Dimension(420, 4));        add(separator1, "cell 0 1");        memPane = new MemPanel();        add(memPane, "cell 0 2");;        //---- functional keys Pane ----        funcPane = new FuncPanel();        add(funcPane, "cell 0 3");        separator2 = new JSeparator();        separator2.setForeground(Color.gray);//        separator2.setSize(new Dimension(420, 4));        add(separator2, "cell 0 4");        //---- numbers Pane ----        numPane = new NumPanel();        add(numPane, "cell 0 5");    }    private void setLight() {    }    private class IOPanel extends JPanel {        private JTextField fieldX;        private IOPanel() {            setLayout(new MigLayout(                    "insets 5 5 2 5,hidemode 3,alignx center,gap 10 0",                    // columns                    "[fill]",                    // rows                    "[fill]"));            // Content            fieldX = new JTextField(16);            // fieldX.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 32));            fieldX.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 42));            fieldX.setForeground(sazeracColor);            Font font = fieldX.getFont();            Map attributes = font.getAttributes();            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);            fieldX.setFont(font.deriveFont(attributes));            fieldX.setHorizontalAlignment(SwingConstants.RIGHT);            fieldX.setMinimumSize(new Dimension(360, 40));            fieldX.setBorder(new EmptyBorder(0, 0, 0, 0));            fieldX.setText("0");            fieldX.setEditable(false);            add(fieldX, "cell 0 0,alignx right,growx 0");        }    }    private class MemPanel extends JPanel {        // Var        private JOprButton btnMR;        private JOprButton btnMPlus;        private JOprButton btnMMinus;        private JOprButton btnMC;        private JOprButton btnLD;        private JOprButton btnAlt;        // Constructor        private MemPanel() {            //======== this ========            setSize(new Dimension(360, 60));            setLayout(new MigLayout(                    "fillx,insets 0 0 0 0,hidemode 3,gap 0 0",                    // columns                    "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]",                    // rows                    "[grow,fill]"));            //content            MemBtnListener memBtnListener = new MemBtnListener();            BtnLDListener btnLDListener = new BtnLDListener();            //---- btnMR ----            btnMR = new JOprButton("mr");            btnMR.addActionListener(memBtnListener);            add(btnMR, "cell 0 0");            //---- btnMPlus ----            btnMPlus = new JOprButton("m+");            btnMPlus.addActionListener(memBtnListener);            add(btnMPlus, "cell 1 0");            //---- btnMMinus ----            btnMMinus = new JOprButton("m-");            btnMMinus.addActionListener(memBtnListener);            add(btnMMinus, "cell 2 0");            //---- btnMC ----            btnMC = new JOprButton("mc");            btnMC.addActionListener(memBtnListener);            add(btnMC, "cell 3 0");            //---- button1 ----            btnLD = new JOprButton("L/D");            btnLD.addActionListener(btnLDListener);            add(btnLD, "cell 4 0");            //---- btnOpt ----            btnAlt = new JOprButton("Alt");            add(btnAlt, "cell 5 0");        }    }    private class FuncPanel extends JPanel {        private JOprButton btnPercent, btnX2, btnX3, btnXA, btnEX, btn10X, btn1X, btnSqrt, btnCbrt, btnAX, btnLn,                btnLg, btnSin, btnCos, btnTg, btnRad, btnLogAX, btnE, btnParenthesisOpen, btnParenthesisClose,                btnFactorial, btnRnd, btnFib, btnPi;        private FuncPanel() {            //======== this ========            setPreferredSize(new Dimension(360, 180));            setLayout(new MigLayout(                    "insets 0 0 0 0,hidemode 3,gap 0 0",                    // columns                    "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]",                    // rows                    "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]"));            OneStepBtnListener oneStepBtnListener = new OneStepBtnListener();            TwoStepBtnListener twoStepBtnListener = new TwoStepBtnListener();            //---- btnPercent ----            btnPercent = new JOprButton("%");            btnPercent.addActionListener(oneStepBtnListener);            add(btnPercent, "cell 0 0");            //---- btnX2 ----            btnX2 = new JOprButton("x^2");            btnX2.addActionListener(oneStepBtnListener);            add(btnX2, "cell 1 0");            //---- btnX3 ----            btnX3 = new JOprButton("x^3");            btnX3.addActionListener(oneStepBtnListener);            add(btnX3, "cell 2 0");            //---- btnXY ----            btnXA = new JOprButton("x^a");            btnXA.addActionListener(twoStepBtnListener);            add(btnXA, "cell 3 0");            //---- btnEX ----            btnEX = new JOprButton("e^x");            btnEX.addActionListener(oneStepBtnListener);            add(btnEX, "cell 4 0");            //---- btn10X ----            btn10X = new JOprButton("10^x");            btn10X.addActionListener(oneStepBtnListener);            add(btn10X, "cell 5 0");            //---- btn1X ----            btn1X = new JOprButton("1/x");            btn1X.addActionListener(oneStepBtnListener);            add(btn1X, "cell 0 1");            //---- btnSqrt ----            btnSqrt = new JOprButton("\u221ax");            btnSqrt.addActionListener(oneStepBtnListener);            add(btnSqrt, "cell 1 1");            //---- btnQbrt ----            btnCbrt = new JOprButton("3\u221ax");            btnCbrt.addActionListener(oneStepBtnListener);            add(btnCbrt, "cell 2 1");            //---- btnYX ----            btnAX = new JOprButton("a\u221ax"); // y root of x            btnAX.addActionListener(twoStepBtnListener);            add(btnAX, "cell 3 1");            //---- btnLn ----            btnLn = new JOprButton("ln");            btnLn.addActionListener(oneStepBtnListener);            add(btnLn, "cell 4 1");            //---- btnLg ----            btnLg = new JOprButton("lg");            btnLg.addActionListener(oneStepBtnListener);            add(btnLg, "cell 5 1");            //---- btnSin ----            btnSin = new JOprButton("sin");            btnSin.addActionListener(oneStepBtnListener);            add(btnSin, "cell 0 2");            //---- btnCos ----            btnCos = new JOprButton("cos");            btnCos.addActionListener(oneStepBtnListener);            add(btnCos, "cell 1 2");            //---- btnTg ----            btnTg = new JOprButton("tg");            btnTg.addActionListener(oneStepBtnListener);            add(btnTg, "cell 2 2");            //---- bynRad ----            btnRad = new JOprButton("Deg");            btnRad.addActionListener(oneStepBtnListener);            add(btnRad, "cell 3 2");            //---- btnLogXY ----            btnLogAX = new JOprButton("loga(x)");            btnLogAX.addActionListener(twoStepBtnListener);            add(btnLogAX, "cell 4 2");            //---- btnE ----            btnE = new JOprButton("e");            btnE.addActionListener(oneStepBtnListener);            add(btnE, "cell 5 2");            //---- btnParenthesisOpen ----            btnParenthesisOpen = new JOprButton("(");            btnParenthesisOpen.addActionListener(oneStepBtnListener);            add(btnParenthesisOpen, "cell 0 3");            //---- btnParenthesisClose ----            btnParenthesisClose = new JOprButton(")");            btnParenthesisClose.addActionListener(oneStepBtnListener);            add(btnParenthesisClose, "cell 1 3");            //---- btnFactorial ----            btnFactorial = new JOprButton("x!");            btnFactorial.addActionListener(oneStepBtnListener);            add(btnFactorial, "cell 2 3");            //---- btnRnd ----            btnRnd = new JOprButton("Rand");            btnRnd.addActionListener(oneStepBtnListener);            add(btnRnd, "cell 3 3");            //---- btnFib ----            btnFib = new JOprButton("Fib(n)");            btnFib.addActionListener(oneStepBtnListener);            add(btnFib, "cell 4 3");            //---- btnPi ----            btnPi = new JOprButton("\u03c0");            btnPi.addActionListener(oneStepBtnListener);            add(btnPi, "cell 5 3");        }    }    private class NumPanel extends JPanel {        //Var        private JNumButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPoint;        private JOprButton btnPlus, btnMinus, btnMultiply, btnDivide;        private JOprButton btnSign, btnEquals, btnDel, btnAC;        //Constructor        private NumPanel() {            //======== this ========            setMinimumSize(new Dimension(360, 200));            setPreferredSize(new Dimension(360, 200));            setLayout(new MigLayout(                    "insets 0 0 0 0,hidemode 3,gap 0 0",                    // columns                    "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]",                    // rows                    "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]" +                            "[grow,fill]"));            //===components===            OneStepBtnListener oneStepBtnListener = new OneStepBtnListener();            TwoStepBtnListener twoStepBtnListener = new TwoStepBtnListener();            BtnResetListener btnResetListener = new BtnResetListener();            // Num buttons            btnZero = new JNumButton("0");            add(btnZero, "cell 0 3 2 1");            btnOne = new JNumButton("1");            add(btnOne, "cell 0 2");            btnTwo = new JNumButton("2");            add(btnTwo, "cell 1 2");            btnThree = new JNumButton("3");            add(btnThree, "cell 2 2");            btnFour = new JNumButton("4");            add(btnFour, "cell 0 1");            btnFive = new JNumButton("5");            add(btnFive, "cell 1 1");            btnSix = new JNumButton("6");            add(btnSix, "cell 2 1");            btnSeven = new JNumButton("7");            add(btnSeven, "cell 0 0");            btnEight = new JNumButton("8");            add(btnEight, "cell 1 0");            btnNine = new JNumButton("9");            add(btnNine, "cell 2 0");            btnPoint = new JNumButton(".");            add(btnPoint, "cell 2 3");            //================================================================            btnPlus = new JOprButton("+", 24);            btnPlus.setBackground(lightningYellowColor);            btnPlus.addActionListener(twoStepBtnListener);            add(btnPlus, "cell 3 3");            btnMinus = new JOprButton("-", 24);            btnMinus.setBackground(lightningYellowColor);            btnMinus.addActionListener(twoStepBtnListener);            add(btnMinus, "cell 3 2");            btnMultiply = new JOprButton("\u00d7", 24);            btnMultiply.setBackground(lightningYellowColor);            btnMultiply.addActionListener(twoStepBtnListener);            add(btnMultiply, "cell 3 1");            btnDivide = new JOprButton("\u00f7", 24);            btnDivide.setBackground(lightningYellowColor);            btnDivide.addActionListener(twoStepBtnListener);            add(btnDivide, "cell 3 0");            //================================================================            btnSign = new JOprButton("\u00b1", 24);            btnSign.addActionListener(oneStepBtnListener);            add(btnSign, "cell 4 1");            btnEquals = new JOprButton("=", 24);            btnEquals.addActionListener(twoStepBtnListener);            add(btnEquals, "cell 4 0");            btnDel = new JOprButton("DEL", 18);            btnDel.addActionListener(oneStepBtnListener);            add(btnDel, "cell 4 2");            btnAC = new JOprButton("C", 24);            btnAC.addActionListener(btnResetListener);            add(btnAC, "cell 4 3");        }    }    private class JNumButton extends JButton {        private JNumButton(String name) {            NumBtnListener numBtnListener = new NumBtnListener();            this.setText(name);            this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 24));            this.setForeground(Color.white);            this.setBorder(new LineBorder(Color.darkGray));            this.setBackground(steelColor);            this.setMinimumSize(new Dimension(60, 40));            this.setMaximumSize(new Dimension(300, 60));            this.addActionListener(numBtnListener);        }    }    private class JOprButton extends JButton {        public JOprButton(String name) {            this.setText(name);            this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 16));            this.setForeground(sazeracColor);            this.setBackground(charcoalColor);            this.setBorder(new LineBorder(bunkerColor));            this.setMinimumSize(new Dimension(60, 40));            this.setMaximumSize(new Dimension(300, 60));        }        public JOprButton(String name, int fontSize) {            this.setText(name);            this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, fontSize));            this.setForeground(sazeracColor);            this.setBackground(charcoalColor);            this.setBorder(new LineBorder(bunkerColor));            this.setMinimumSize(new Dimension(60, 40));            this.setMaximumSize(new Dimension(300, 60));        }    }//    private class JMemButton extends JButton {////        private JMemButton(String name) {//////            MemBtnListener memBtnListener = new MemBtnListener();////            this.setText(name);//            this.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 16));//            this.setForeground(Color.white);//            this.setBorder(new LineBorder(Color.darkGray));//            this.setMinimumSize(new Dimension(60, 35));//            this.setMaximumSize(new Dimension(100, 60));////            this.addActionListener(memBtnListener);////        }//    }    private class NumBtnListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            if (xInStr.contains(".") && evt.getActionCommand() == ".") {                return;            } else if (xInStr == "" && evt.getActionCommand() == "0" && x1 == 0) {                return;            } else if (xInStr == "" && evt.getActionCommand() == ".") {                xInStr = "0.";                xInDbl = 0;                ioPane.fieldX.setText(xInStr);            } else {                xInStr += evt.getActionCommand();                ioPane.fieldX.setText(xInStr);                xInDbl = Double.parseDouble(xInStr);            }        }    }    private class OneStepBtnListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            oneStepFlag = true;            oneStepOpr = evt.getActionCommand();            actionStatus = ActionStatus.actionIsCorrect;            x0 = x1;            x1 = xInDbl;            oneStepEvaluate();            setDisplay(xInDbl);            x1 = xInDbl; // двойной счет??            xInStr = ""; // обнуляем ввод        }    }    private class TwoStepBtnListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            if (oneStepFlag == false) {                x0 = x1;                x1 = xInDbl;            }            oneStepFlag = false;            previousOpr = currentOpr;  // save            currentOpr = evt.getActionCommand();            actionStatus = ActionStatus.actionIsCorrect;            twoStepEvaluate();            setDisplay(xInDbl);            x1 = xInDbl;            xInStr = "";        }    }    private class EqualBtnListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            x0 = x1;            if (currentOpr != "") {                x1 = xInDbl;                prevOprSave = currentOpr;            }            oneStepFlag = false;            previousOpr = currentOpr;            currentOpr = evt.getActionCommand(); // можно заменить на "="            actionStatus = ActionStatus.actionIsCorrect;            twoStepEvaluate();            setDisplay(xInDbl);//            x1 = xInDbl;            xInStr = "";        }    }    private class MemBtnListener  implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            String memOpr = evt.getActionCommand();            actionStatus = ActionStatus.actionIsCorrect;            switch (memOpr) {                case "m+":                    memDbl += xInDbl;                    break;                case "m-":                    memDbl -= xInDbl;                    break;                case "mr":                    xInDbl = memDbl;                    setDisplay(xInDbl);                    break;                case "mc":                    memDbl = 0;                    break;            }            xInStr = "";        }    }    private class BtnResetListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            x0 = x1 = 0;            xInStr = "";            currentOpr = "";            previousOpr = "";            ioPane.fieldX.setText("0");        }    }    private class BtnLDListener implements ActionListener {        @Override        public void actionPerformed(ActionEvent evt) {            switch (lightFlag) {                case Dark -> {                    lightFlag = LightFlag.Light;                    try {                        UIManager.setLookAndFeel(new FlatLightLaf());                    } catch (Exception ex) {                        System.err.println("Failed to initialize LaF");                    }                }                case Light -> {                    lightFlag = LightFlag.Dark;                    try {                        UIManager.setLookAndFeel(new FlatDarkLaf());                    } catch (Exception ex) {                        System.err.println("Failed to initialize LaF");                    }                }            }        }    }    private void oneStepEvaluate() {        switch (oneStepOpr) {//                case "=":////                    break;//                case "C"://                    x0 = x1 = 0;//                    xInStr = "";//                    currentOpr = "";//                    previousOpr = "";//                    ioPane.fieldX.setText("0");//                    break;            case "Del":                break;            case "\u00b1":                xInDbl = -x1;                break;            case "%":                if (x0 == 0) {                    xInDbl = x1 / 100;                }                else {                    xInDbl = x0 * x1 / 100;                }                break;            case "x^2":                xInDbl = Math.pow(x1, 2);                break;            case "x^3":                xInDbl = Math.pow(x1, 3);                break;            case "e^x":                xInDbl = Math.exp(x1);                break;            case "10^x":                xInDbl = Math.pow(10, x1);                break;            case "1/x":                xInDbl = 1/x1;                break;            case "\u221ax":                xInDbl = Math.sqrt(x1);                break;            case "3\u221ax":                xInDbl = Math.cbrt(x1);                break;            case "ln":                xInDbl = Math.log(x1);                break;            case "lg":                xInDbl = Math.log10(x1);                break;            case "sin":                xInDbl = JMath.jSin(x1);                break;            case "cos":                xInDbl = JMath.jCos(x1);                break;            case "tg":                xInDbl = JMath.jTg(x1);                break;            case "Deg":                xInDbl = Math.toDegrees(x1);                break;            case "e":                xInDbl = Math.exp(1);                break;            case "(":                break;            case ")":                break;            case "x!":                xInDbl = JMath.factorial(x1);                break;            case "Rand":                xInDbl = Math.random();                break;            case "Fib(n)":                if (x1 < 0 || x1 > 88) {                    actionStatus = ActionStatus.OutOfRange;                } else {                    xInDbl = JMath.fib(x1);                }                break;            case "\u03c0":                xInDbl = Math.PI;                break;        }    }    private void twoStepEvaluate() {        switch (previousOpr) {            case "":                break;            case "="://                    xInDbl = x1;                break;            case "+":                xInDbl = x0 + x1;                break;            case "-":                xInDbl = x0 - x1;                break;            case "\u00d7": //multiply                xInDbl = x0 * x1;                break;            case "\u00f7": //divide                if (x1 == 0) {                    actionStatus = ActionStatus.Infinity;                } else {                    xInDbl = x0 / x1;                }                break;            case "x^a":                xInDbl = Math.pow(x0, x1);                break;            case "a\u221ax": // y root of x                xInDbl = Math.pow(x0, 1/x1);                break;            case "loga(x)":                xInDbl = Math.log(x1) / Math.log(x0);                break;        }    }    private void setDisplay(double displayValue) {        String displayString = "";        switch (actionStatus) {            case actionIsCorrect:                DecimalFormat df = new DecimalFormat("###.############");                displayString = df.format(displayValue);                if (displayString.length() > 2) {                    String last2DisplayChars = displayString.substring(displayString.length() - 2);                    if (last2DisplayChars.equals(".0")) {                        displayString = displayString.substring(0 , displayString.length() - 2);                    }                }                break;            case Infinity:                displayString = "Infinity";                break;            case NotANumber:                displayString = "Not a number";                break;            case OutOfRange:                displayString = "Input is out of range";                break;        }        ioPane.fieldX.setText(displayString);    }}