import java.awt.*;
import java.awt.event.*;

public class Day11Question2 extends Frame implements ActionListener {

    TextField t1,t2;
    Button caps,small,reverse,words,letters,vowels,reset;

    Day11Question2(){

        setTitle("My Frame");
        setSize(700,400);
        setLayout(new FlowLayout());

        Label l1 = new Label("Enter the string:");
        Label l2 = new Label("String in upper case:");

        t1 = new TextField(40);
        t2 = new TextField(40);

        caps = new Button("IN CAPS");
        small = new Button("IN SMALL");
        reverse = new Button("REVERSE");
        words = new Button("WORDS");
        letters = new Button("LETTERS");
        vowels = new Button("VOWELS");
        reset = new Button("RESET");

        add(l1); add(t1);
        add(l2); add(t2);

        add(caps);
        add(small);
        add(reverse);
        add(words);
        add(letters);
        add(vowels);
        add(reset);

        caps.addActionListener(this);
        small.addActionListener(this);
        reverse.addActionListener(this);
        words.addActionListener(this);
        letters.addActionListener(this);
        vowels.addActionListener(this);
        reset.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String s = t1.getText();

        if(e.getSource()==caps)
            t2.setText(s.toUpperCase());

        if(e.getSource()==small)
            t2.setText(s.toLowerCase());

        if(e.getSource()==reverse){
            StringBuffer sb = new StringBuffer(s);
            t2.setText(sb.reverse().toString());
        }

        if(e.getSource()==words){
            String w[] = s.split(" ");
            t2.setText("Words: "+w.length);
        }

        if(e.getSource()==letters){
            t2.setText("Letters: "+s.length());
        }

        if(e.getSource()==vowels){
            int count=0;
            for(char c: s.toLowerCase().toCharArray()){
                if("aeiou".indexOf(c)!=-1) count++;
            }
            t2.setText("Vowels: "+count);
        }

        if(e.getSource()==reset){
            t1.setText("");
            t2.setText("");
        }
    }

    public static void main(String args[]){
        new Day11Question2();
    }
}