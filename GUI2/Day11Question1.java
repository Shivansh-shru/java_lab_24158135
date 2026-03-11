import java.awt.*;
import java.awt.event.*;

public class Day11Question1 extends Frame implements ActionListener {

    TextField display;
    Button b[];
    String s1="", op="";

    Day11Question1() {

        setTitle("CALCULATOR");
        setSize(260,260);
        setLayout(null);
        setBackground(Color.cyan);

        Label title = new Label("CALCULATOR");
        title.setBounds(20,40,100,20);
        title.setForeground(Color.blue);
        add(title);

        display = new TextField();
        display.setBounds(120,40,100,25);
        add(display);

        String btn[]={
                "1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "/","0","%","="
        };

        b = new Button[16];

        int x=20,y=70,k=0;

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                b[k]=new Button(btn[k]);
                b[k].setBounds(x,y,45,30);
                b[k].addActionListener(this);
                add(b[k]);

                x+=50;
                k++;
            }
            x=20;
            y+=35;
        }

        Button off = new Button("OFF");
        off.setBounds(80,210,80,30);
        off.addActionListener(e -> System.exit(0));
        add(off);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();

        if(cmd.matches("[0-9]"))
            display.setText(display.getText()+cmd);

        else if(cmd.matches("[+\\-*/%]")){
            s1 = display.getText();
            op = cmd;
            display.setText("");
        }

        else if(cmd.equals("=")){

            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(display.getText());
            double r=0;

            if(op.equals("+")) r=a+b;
            if(op.equals("-")) r=a-b;
            if(op.equals("*")) r=a*b;
            if(op.equals("/")) r=a/b;
            if(op.equals("%")) r=a%b;

            display.setText(String.valueOf(r));
        }
    }

    public static void main(String args[]){
        new Day11Question1();
    }
}