import java.awt.*;
import java.awt.event.*;

public class Day11Question2 extends Frame implements ActionListener {

    TextField t1, t2;
    Button caps, small, convert, words, letters, reverse, vowels, frequency, begin, reset;

    Day11Question2() {

        setTitle("My Frame");
        setSize(900,500);
        setLayout(null);
        setBackground(new Color(230,150,150)); // pink background

        Label l1 = new Label("Enter the string:");
        l1.setBounds(80,120,120,20);
        add(l1);

        t1 = new TextField();
        t1.setBounds(250,120,300,25);
        add(t1);

        Label l2 = new Label("String in upper case:");
        l2.setBounds(80,180,150,20);
        add(l2);

        t2 = new TextField();
        t2.setBounds(250,180,300,25);
        add(t2);

        caps = new Button("IN CAPS");
        caps.setBounds(50,300,90,25);

        small = new Button("IN SMALL");
        small.setBounds(180,300,90,25);

        convert = new Button("CONVERT CASE");
        convert.setBounds(330,300,120,25);

        words = new Button("WORDS");
        words.setBounds(500,300,90,25);

        letters = new Button("LETTERS");
        letters.setBounds(650,300,90,25);

        reverse = new Button("REVERSE");
        reverse.setBounds(110,330,90,25);

        vowels = new Button("VOWELS");
        vowels.setBounds(300,330,90,25);

        frequency = new Button("FREQUENCY");
        frequency.setBounds(440,330,100,25);

        begin = new Button("BEGIN CAPS");
        begin.setBounds(600,330,100,25);

        reset = new Button("RESET");
        reset.setBounds(400,380,100,30);
        reset.setBackground(Color.blue);
        reset.setForeground(Color.white);

        add(caps);
        add(small);
        add(convert);
        add(words);
        add(letters);
        add(reverse);
        add(vowels);
        add(frequency);
        add(begin);
        add(reset);

        caps.addActionListener(this);
        small.addActionListener(this);
        convert.addActionListener(this);
        words.addActionListener(this);
        letters.addActionListener(this);
        reverse.addActionListener(this);
        vowels.addActionListener(this);
        frequency.addActionListener(this);
        begin.addActionListener(this);
        reset.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String s = t1.getText();

        if(e.getSource()==caps)
            t2.setText(s.toUpperCase());

        if(e.getSource()==small)
            t2.setText(s.toLowerCase());

        if(e.getSource()==convert) {
            String result="";
            for(char c : s.toCharArray()) {
                if(Character.isUpperCase(c))
                    result += Character.toLowerCase(c);
                else
                    result += Character.toUpperCase(c);
            }
            t2.setText(result);
        }

        if(e.getSource()==reverse)
            t2.setText(new StringBuffer(s).reverse().toString());

        if(e.getSource()==words)
            t2.setText("Words: " + s.split(" ").length);

        if(e.getSource()==letters)
            t2.setText("Letters: " + s.length());

        if(e.getSource()==vowels){
            int count=0;
            for(char c : s.toLowerCase().toCharArray())
                if("aeiou".indexOf(c)!=-1) count++;
            t2.setText("Vowels: " + count);
        }

        if(e.getSource()==frequency){
            int freq = s.length();
            t2.setText("Length: " + freq);
        }

        if(e.getSource()==begin){
            String[] words = s.split(" ");
            String result="";
            for(String w : words)
                result += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
            t2.setText(result);
        }

        if(e.getSource()==reset){
            t1.setText("");
            t2.setText("");
        }
    }

    public static void main(String args[]) {
        new Day11Question2();
    }
}