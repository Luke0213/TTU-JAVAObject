package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame Cat = new JFrame("cat");
        Cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cat.setResizable(false);

        Panel p = new Panel();
        Cat.add(p);
        Cat.pack();

        Cat.setLocationRelativeTo(null);
        Cat.setVisible(true);
    }
}
