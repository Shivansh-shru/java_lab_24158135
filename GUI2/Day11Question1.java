import java.awt.*;
import java.awt.event.*;

public class Day11Question1 extends Frame implements ActionListener {

    TextField display;
    Button b[] = new Button[17];

    String s1="", s2="", op="";

    Day11Question1() {

        setTitle("Calculator");
        setSize(250,300);
        setLayout(new BorderLayout());

        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        Panel p = new Panel();
        p.setLayout(new GridLayout(5,4,5,5));

        String btn[] = {
                "1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "/","0","%","=",
                "OFF"
        };

        for(int i=0;i<17;i++) {
            b[i] = new Button(btn[i]);
            b[i].addActionListener(this);
            p.add(b[i]);
        }

        add(p,BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if(cmd.matches("[0-9]")) {
            display.setText(display.getText()+cmd);
        }

        else if(cmd.matches("[+\\-*/%]")) {
            s1 = display.getText();
            op = cmd;
            display.setText("");
        }

        else if(cmd.equals("=")) {

            s2 = display.getText();

            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(s2);
            double r = 0;

            if(op.equals("+")) r = a+b;
            if(op.equals("-")) r = a-b;
            if(op.equals("*")) r = a*b;
            if(op.equals("/")) r = a/b;
            if(op.equals("%")) r = a%b;

            display.setText(String.valueOf(r));
        }

        else if(cmd.equals("OFF")) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Day11Question1();
    }
}